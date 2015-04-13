package org.buptdavid.datastructure.designPatterns.singleton.statics;

/**
 * 静态变量初始化实现线程安全的单例模式<br>
 * static变量 instance 是在类被加载时初始化并仅被初始化一次，这样就可以保证只有一个instance被初始化
 * @author weijielu
 *
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    
    private Singleton(){}
    
    public static Singleton getInstance(){
        return instance;
    }

}
