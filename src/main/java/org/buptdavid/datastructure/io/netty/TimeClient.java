package org.buptdavid.datastructure.io.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Netty时间服务器客户端 TimeClient
 * @author weijielu
 *
 */
public class TimeClient {
    
    public void connect(int port, String host) throws Exception{
        // 配置客户端NIO线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>(){
                    // 作用是当创建NioSocketChannel成功之后，在初始化它的时候将它的ChannelHandler设置到ChannelPipeline中
                    // 用于处理网络IO事件
                    @Override
                    protected void initChannel(SocketChannel arg0) throws Exception {
                        arg0.pipeline().addLast(new TimeClientHandler());
                    }
                });
            
            // 发起异步连接操作
            ChannelFuture f = b.connect(host, port).sync();
            
            // 等待客户端链路关闭
            f.channel().closeFuture().sync();
            
        } finally {
            // 优雅退出，释放NIO线程组
            group.shutdownGracefully();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        

    }

}
