package org.buptdavid.datastructure.designPatterns.singleton.threadSafety;

/**
 * 线程安全的单例模式实现类
 * @author weijielu
 *
 */
public class Singleton {
    private static Singleton instance;
    
    private Singleton(){}
    
    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        
        return instance;
    }

}
