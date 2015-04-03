package org.buptdavid.datastructure.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Netty时间服务器服务端 TimeServer
 * @author weijielu
 *
 */
public class TimeServer {
    
    public void bind(int port) throws Exception{
        // 配置服务端的NIO线程组
        // 用于服务端接受客户端的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 用于进行SocketChannel的网络读写
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        
        try{
            // Netty用于启动NIO服务端的辅助启动类，目的是降低服务端的开发复杂度
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChildChannelHandler());
            
            // 绑定端口，同步等待成功
            // 类似java.util.concurrrent.Future,主要用于异步操作的通知回调
            ChannelFuture f = b.bind(port).sync();
            
            // 等待服务端监听端口关闭
            // 进行阻塞，等待服务端链路关闭后main函数才退出
            f.channel().closeFuture().sync();
            
        } finally {
            // 优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
    
    /**
     * 类似于Reactor模式中的handler，主要用于处理网络IO事件，例如日志记录，对消息进行编解码等
     *
     */
    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

        @Override
        protected void initChannel(SocketChannel arg0) throws Exception {
            arg0.pipeline().addLast(new TimeServerHandler());
        }
        
    }

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        int port = 8080;
        if(args != null && args.length > 0){
            try{
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                
            }
        }
        
        new TimeServer().bind(port);
    }

}
