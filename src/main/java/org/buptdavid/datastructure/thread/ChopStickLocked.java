package org.buptdavid.datastructure.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 哲学家就餐问题的筷子
 * @author weijielu
 * @see PhilosopherLocked
 * @see PhilosopherLockedEat
 */
public class ChopStickLocked {
	/* 锁  */
	protected Lock lock;
	
	public ChopStickLocked(){
		lock = new ReentrantLock();
	}
	
	/**
	 * 拿起筷子
	 * @return 
	 */
	public boolean pickUp(){
		lock.lock();
//		try {
//			int sleepTime = (int)(Math.random() * 500 + 10);
//			Thread.sleep(sleepTime);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return true;
	}
	
	/**
	 * 放下筷子
	 */
	public boolean putDown(){
		lock.unlock();
//		try {
//			int sleepTime = (int)(Math.random() * 500 + 10);
//			Thread.sleep(sleepTime);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		return true;
	}

}
