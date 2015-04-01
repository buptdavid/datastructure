package org.buptdavid.datastructure.io.fakenio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.buptdavid.datastructure.io.bio.TimeServerHandler;

/**
 * 伪异步IO的TimeServer<br>
 * 伪异步IO采用了线程池实现，因此避免了为每个请求都创建一个独立线程造成的线程资源消耗问题<br>
 * 但是由于它底层的通信依然采用同步阻塞模型，因此无法从根本上解决问题<br>
 * 由于同步阻塞IO的InputStream的read方法和OutputStream的write方法都是自动阻塞方法，所以如果通信双方放回应答时间过长会引起一下级联故障:<br>
 * (1) 服务器端处理缓慢，返回应答消息耗费60s，平时只需要10ms<br>
 * (2) 读取故障服务节点的响应会被同步阻塞20s<br>
 * (3) 假如所有的可用线程都被故障服务器阻塞，那么后续所有的IO消息都将在队列中排队<br>
 * (4) 由于线程池采用阻塞队列实现，当队列积满之后，后续入队列的操作将被阻塞<br>
 * (5) 由于前段只有一个线程接受客户端接入，它被阻塞在线程池的同步阻塞队列之后，新的客户端请求消息将被拒绝，客户端会发生大量的链接超时<br>
 * (6) 由于几乎所有的链接都超时，调用者会认为系统已经崩溃，无法接受新的请求消息<br>
 * SOOOOOOOOOOOO,我们不得不使用NIO
 * @author weijielu
 */
public class TimeServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		int port = 8080;
		if(args != null && args.length > 0){
			try{
				port = Integer.valueOf(args[0]);
			}catch(NumberFormatException e){
				// Do nothing
			}
		}
		
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("The time server is start in port : " + port);
			Socket socket = null;
			TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 10000);
			while(true){
				socket = server.accept();
				singleExecutor.execute(new TimeServerHandler(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(server != null){
				System.out.println("The time server close");
				server.close();
				server = null;
			}
		}
	}

}
