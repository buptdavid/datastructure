package org.buptdavid.datastructure.io.aio;

/**
 * AIO时间服务器服务端  TimeServer
 * @author weijielu
 *
 */
public class TimeServer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int port = 8080;
        if(args != null && args.length > 0){
            try{
                port = Integer.valueOf(args[0]);
            } catch(NumberFormatException e){
                
            }
        }
        
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();

    }

}
