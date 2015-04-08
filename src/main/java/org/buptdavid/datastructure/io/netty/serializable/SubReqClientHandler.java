package org.buptdavid.datastructure.io.netty.serializable;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Netty Java序列化 产品订购客户端 SubReqClientHandler
 * @author weijielu
 *
 */
public class SubReqClientHandler extends ChannelHandlerAdapter {
    
    public SubReqClientHandler(){
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for(int i = 0; i < 10; i++){
            ctx.write(subReq(i));
        }
        ctx.flush();
    }
    
    private SubscribeReq subReq(int i){
        SubscribeReq req = new SubscribeReq();
        req.setAddress("北京市海淀区中关村软件园");
        req.setPhoneNumber("1342222222");
        req.setProductName("Netty 权威指南");
        req.setSubReqID(i);
        req.setUserName("Luweijie");
        return req;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Receive server response : [" + msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
