package org.buptdavid.datastructure.io.nio;

/**
 * NIO时间服务器 TimeServer
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
        
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }

}
