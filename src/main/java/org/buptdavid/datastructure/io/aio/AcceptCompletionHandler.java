package org.buptdavid.datastructure.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * AIO时间服务器服务端  AcceptCompletionHandler
 * @author weijielu
 *
 * @param <AsynchronousSocketChannel>
 * @param <AsyncTimeServerHandler>
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
        /**
         * 再次调用AsyncTimeServerHandler.asynchronousServerSocketChannel的accept方法
         * 当我们调用AsynchronousServerSocketChannel的accept方法后，如果有新的客户端连接接入，系统将回调我们传入的CompletionHandler
         * 实例的completed方法，表示新的客户端已经接入成功，因为一个AsynchronousServerSocketChannel可以接受成千上万个客户端，
         * 所以我们需要继续调用它的accept方法，接受其他的客户端连接，最终形成一个循环。每当接受一个客户读取成功之后，
         * 再异步接受新的客户端连接
         */
        attachment.asynchronousServerSocketChannel.accept(attachment, this);
        
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        /**
         * 异步读取操作
         * @param buffer 接受缓冲区，用于从异步Channel中读取数据包
         * @para buffer 异步Channel携带的附件，通知回调的时候作为入参使用
         * @para ReadCompletionHandler 接受通知回调的业务handler
         */
        result.read(buffer, buffer, new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }

}
