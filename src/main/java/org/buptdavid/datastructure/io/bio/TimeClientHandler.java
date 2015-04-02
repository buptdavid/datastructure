package org.buptdavid.datastructure.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * BIO的TimeClientHandler
 * @author weijielu
 */
public class TimeClientHandler implements Runnable {
	
	private int port;
	
	public TimeClientHandler(int port){
		this.port = port;
	}

	@Override
	public void run() {
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			socket = new Socket("127.0.0.1", port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			// Sleep 0-10 s中的随机时间
			Thread.sleep((long) (1000 * Math.random() * 10));
			out.println("QUERY TIME ORDER");
			System.out.println("Send order to server succeed.");
			
			String resp = in.readLine();
			System.out.println("Now is : " + resp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(out != null){
				out.close();
				out = null;
			}
			
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in = null;
			}
			
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				socket = null;
			}
		}
	}

}
