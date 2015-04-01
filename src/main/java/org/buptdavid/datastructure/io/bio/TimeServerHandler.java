package org.buptdavid.datastructure.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * BIO的TimeServerhandler
 * @author weijielu
 */
public class TimeServerHandler implements Runnable {
	
	private Socket socket;
	
	public TimeServerHandler(Socket socket){
		this.socket = socket;
	}

	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(), true);
			
			String currentTime = null;
			String body = null;
			while(true){
				body = in.readLine();
				if(body == null){
					break;
				}
				System.out.println("The time server receive order : " + body);
				currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new java.util.Date(System.currentTimeMillis()).toString() : "BAD ORDER";
				out.println(currentTime);
			}
		} catch (Exception e) {
			if(in != null){
				try {
					in.close();
				} catch (IOException e1){
					e1.printStackTrace();
				}
				in = null;
			}
			
			if(out != null){
				out.close();
				out = null;
			}
			
			if(this.socket != null){
				try {
					this.socket.close();
				} catch (IOException e1){
					e1.printStackTrace();
				}
				this.socket = null;
			}
		}
	}

}
