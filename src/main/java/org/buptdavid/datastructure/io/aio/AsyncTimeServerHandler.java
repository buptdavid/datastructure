package org.buptdavid.datastructure.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * AIO时间服务器服务端  AsyncTimeServerHandler
 * @author weijielu
 *
 */
public class AsyncTimeServerHandler implements Runnable {
    
    private int port;
    
    CountDownLatch latch;
    AsynchronousServerSocketChannel asynchronousServerSocketChannel;
    
    public AsyncTimeServerHandler(int port){
        this.port = port;
        try {
            // 创建异步服务器通道，绑定监听端口
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("The time server is start in port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // 初始化CountDownLatch对象，作用是在完成一组正在执行的操作之前，允许当前的线程一直阻塞
        latch = new CountDownLatch(1);
        doAccept();
        
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void doAccept(){
        // 接受客户端的连接，由于是异步操作，可以传递一个CompletionHandler<AsynchronousSocketChannel, ? super A>类型的实例
        // 来接受accept操作成功的通知消息
        asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
    }

}
