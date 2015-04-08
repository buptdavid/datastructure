package org.buptdavid.datastructure.io.netty.tcpacketsplicing;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

/**
 * Netty时间服务器客户端 TimeClientHandler
 * @author weijielu
 *
 */
public class TimeClientHandler extends ChannelHandlerAdapter {
    
    private static final Logger logger = Logger.getLogger(TimeClientHandler.class.getName());
    
    private int counter;
    private byte[] req;
    
    /**
     * Creates a client-side handler
     */
    public TimeClientHandler(){
        req = (("QUERY TIME ORDER") + System.getProperty("line.separator")).getBytes();
    }

    /**
     * 当客户端和服务器端TCP链路建立成功之后，Netty的NIO线程会调用channelActive方法<br>
     * 发送查询时间的指令给服务端，调用ChannelHandlerContext的writeAndFlush方法将请求消息发送给服务端<br>
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ctx.writeAndFlush(firstMessage);
        ByteBuf message = null;
        for(int i = 0; i < 100; i++){
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
    }

    /**
     * 当服务端返回应答消息时，channelRead方法被调用
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf)msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "UTF-8");
        
        String body = (String) msg;        
        System.out.println("Now is : " + body + " ; the counter is : " + ++counter);
    }

    /**
     * 当发生异常时，打印异常日志，释放客户端资源
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 释放资源
        logger.warning("Unexpected exception from downstream : " + cause.getMessage());
        ctx.close();
    }

    
}
