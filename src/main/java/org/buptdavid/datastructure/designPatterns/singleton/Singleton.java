package org.buptdavid.datastructure.designPatterns.singleton;

/**
 * 五种单例模式的实现
 * @author weijielu
 *
 */
public class Singleton {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 静态变量初始化实现线程安全的单例模式
        org.buptdavid.datastructure.designPatterns.singleton.statics.Singleton instance1 = 
                org.buptdavid.datastructure.designPatterns.singleton.statics.Singleton.getInstance();
        
        // 静态内部类实现的线程安全的单例模式
        org.buptdavid.datastructure.designPatterns.singleton.staticInnerClass.Singleton instance2 = 
                org.buptdavid.datastructure.designPatterns.singleton.staticInnerClass.Singleton.getInstance();
        
        // 经典的非线程安全单例模式实现类
        org.buptdavid.datastructure.designPatterns.singleton.classic.Singleton instance3 = 
                org.buptdavid.datastructure.designPatterns.singleton.classic.Singleton.getInstance();
        
        // 线程安全的单例模式实现类
        org.buptdavid.datastructure.designPatterns.singleton.threadSafety.Singleton instance4 = 
                org.buptdavid.datastructure.designPatterns.singleton.threadSafety.Singleton.getInstance();
        
        // 高效的线程安全的单例模式实现类
        org.buptdavid.datastructure.designPatterns.singleton.threadSafetyVolatile.Singleton instance5 = 
                org.buptdavid.datastructure.designPatterns.singleton.threadSafetyVolatile.Singleton.getInstance();
    }

}
