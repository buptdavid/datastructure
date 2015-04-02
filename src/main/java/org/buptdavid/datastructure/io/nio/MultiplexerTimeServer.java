package org.buptdavid.datastructure.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO时间服务器 MultiplexerTimeServer
 * @author weijielu
 *
 */
public class MultiplexerTimeServer implements Runnable {
    
    private Selector selector;
    
    private ServerSocketChannel servChannel;
    
    private volatile boolean stop;
    
    /**
     * 初始化多路复用器，绑定监听端口
     * @param port
     */
    public MultiplexerTimeServer(int port){
        try{
            selector = Selector.open();
            
            servChannel = ServerSocketChannel.open();
            servChannel.configureBlocking(false);
            
            servChannel.socket().bind(new InetSocketAddress(port), 1024);
            servChannel.register(selector, SelectionKey.OP_ACCEPT);
            
            System.out.println("The time server is tart in port : " + port);
        } catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public void stop(){
        this.stop = true;
    }

    @Override
    public void run() {
        // 循环遍历selector，休眠时间 1s
        while(!stop){
            try{
                selector.select(1000);
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectedKeys.iterator();
                SelectionKey key = null;
                while(it.hasNext()){
                    key = it.next();
                    it.remove();
                    try{
                        handleInput(key);
                    } catch (Exception e){
                        if(key != null){
                            key.cancel();
                            if(key.channel() != null){
                                key.channel().close();
                            }
                        }
                    }
                }
                
            } catch (Throwable t){
                t.printStackTrace();
            }
        }
        
        // 多路复用器关闭后，所有注册在上面的Channel和Pipe等资源都会被自动去注册并关闭，所以不需要重复释放资源
        if(selector != null){
            try{
                selector.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    
    private void handleInput(SelectionKey key) throws IOException{
        if(key.isValid()){
            // 处理新接入的请求消息
            if(key.isAcceptable()){
                //接受新connection
                ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
                // 完成TCP的三次握手
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                // 添加新connection到selector
                sc.register(selector, SelectionKey.OP_READ);
            }
            
            if(key.isReadable()){
                // 读数据
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                // 非阻塞读取
                int readBytes = sc.read(readBuffer);
                if(readBytes > 0){
                    // 大于0，对字节进行解编码
                    readBuffer.flip(); // 将缓冲区当前的limit设置为position，position设置为0，用于后续对缓冲区的读取操作
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    
                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time server receive order : " + body);
                    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new java.util.Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                    
                    doWrite(sc, currentTime);
                }else if(readBytes < 0){
                    // 小于0(-1)，链路已经关闭，关闭SocketChannel释放资源
                    key.cancel();
                    sc.close();
                }else {
                    // 读到0字节，忽略
                }
            }
        }
    }
    
    /**
     * 将应答消息异步发送给客户端
     * @param channel
     * @param response
     * @throws IOException
     */
    private void doWrite(SocketChannel channel, String response) throws IOException{
        if(response != null && response.trim().length() > 0){
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            // 异步非阻塞写
            channel.write(writeBuffer);
        }
    }

}
