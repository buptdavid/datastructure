package org.buptdavid.datastructure.io.bio;


/**
 * BIO的TimeClient
 * @author weijielu
 */
public class TimeClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int port = 8080;
		if(args != null && args.length > 0){
			try{
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e){
				// Do nothing
			}
		}
		
		int i = 0;
		while(i++ < 1000){
			new Thread(new TimeClientHandler(port), "TimeClient-" + i).start();
		}
	}

}
