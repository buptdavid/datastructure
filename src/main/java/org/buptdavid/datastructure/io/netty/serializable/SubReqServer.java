package org.buptdavid.datastructure.io.netty.serializable;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * Netty JAVA序列化 订购服务端主函数 SubReqServer
 * @author weijielu
 *
 */
public class SubReqServer {
    
    public void bind(int port) throws Exception{
        // 配置服务端的NIO线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 100)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>(){
                    @Override
                    protected void initChannel(SocketChannel arg0) throws Exception {
                        // 创建一个新的ObjectDecoder，它负责对实现Serializable的POJO对象进行解码，它有多个构造函数，支持不同的ClassResolver，
                        // 在此我们使用weakCachingConcurrentResolver创建线程安全的WeakReferenceMap对类加载器进行缓存，
                        // 它支持多线程并发访问，当虚拟机内存不足时，会释放缓存中的内存，防止内存泄露，为了防止异常码流和解码错位导致的内存溢出
                        // 这里将单个对象最大序列化后的字节数组长度设置为1M，
                        arg0.pipeline().addLast(new ObjectDecoder(1024*1024, ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
                        // 新增一个ObjectEncoder,它可以在消息发送的时候自动将实现Serializable的POJO对象进行编码，因此用户无需亲自对对象进行手工序列化，
                        // 只需要关注自己的业务逻辑处理即可，对象序列化和反序列化都由Netty的对象编码器搞定
                        arg0.pipeline().addLast(new ObjectEncoder());
                        arg0.pipeline().addLast(new SubReqServerHandler());
                    }
            });
            
            // 绑定端口，同步等待成功
            ChannelFuture f = b.bind(port).sync();
            
            // 等待服务端监听端口关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
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
        
        new SubReqServer().bind(port);
    }

}
