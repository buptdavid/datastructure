package org.buptdavid.datastructure.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现锁的ATM的取款与存款
 * @author weijielu
 * @see LockedATMThread
 */
public class LockedATM {
	private Lock lock;
	private int balance = 10000;
	
	public LockedATM(){
		lock = new ReentrantLock();
	}
	
	/**
	 * 取款value
	 * @param value
	 * @return 取款后的余额
	 */
	public Integer withDraw(int value){
		System.out.println("准备取款: " + value);
		
		lock.lock();
		
		Integer temp = null;
		if(value > balance){
			System.out.println("余额不足");
			temp = null;
		}else{
			temp = balance;
			try{
				Thread.sleep(300);
				temp = temp - value;
				Thread.sleep(200);
				balance = temp;
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		
		lock.unlock();
		
		return temp;
	}
	
	/**
	 * 存款value
	 * @param value 存款后的余额
	 * @return
	 */
	public Integer deposit(int value){
		System.out.println("准备存款: " + value);
		
		lock.lock();
		
		Integer temp = balance;
		try{
			Thread.sleep(300);
			temp = temp + value;
			Thread.sleep(200);
			balance = temp;
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		
		lock.unlock();
		
		return temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LockedATM atm = new LockedATM();
		LockedATMThread thread1 = new LockedATMThread(atm);
		LockedATMThread thread2 = new LockedATMThread(atm);
		LockedATMThread thread3 = new LockedATMThread(atm);
		LockedATMThread thread4 = new LockedATMThread(atm);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
