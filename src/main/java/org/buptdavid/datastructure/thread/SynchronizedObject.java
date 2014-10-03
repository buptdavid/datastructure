package org.buptdavid.datastructure.thread;

/**
 * 同步对象
 * @author weijielu
 * @see SynchronizedThread
 */
public class SynchronizedObject {
	public synchronized void syn(String name){
		try{
			System.out.println("Thread " + name + ".syn(): starting.");
			Thread.sleep(3000);
			System.out.println("Thread " + name + ".syn(): ending.");
		} catch (InterruptedException e){
			System.out.println("Thread " + name + ": interrupted.");
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		System.out.println("Different SynchronizedObject");
		SynchronizedObject sObject1 = new SynchronizedObject();
		SynchronizedObject sObject2 = new SynchronizedObject();
		SynchronizedThread sThread1 = new SynchronizedThread(sObject1, "1");
		SynchronizedThread sThread2 = new SynchronizedThread(sObject2, "2");
		
		Thread thread1 = new Thread(sThread1);
		thread1.start();
		Thread thread2 = new Thread(sThread2);
		thread2.start();
		
		Thread.sleep(7000);
		
		System.out.println();
		System.out.println("Same SynchronizedObject");
		SynchronizedObject sObject3 = new SynchronizedObject();
		SynchronizedThread sThread3 = new SynchronizedThread(sObject3, "3");
		SynchronizedThread sThread4 = new SynchronizedThread(sObject3, "4");
		Thread thread3 = new Thread(sThread3);
		thread3.start();
		Thread thread4 = new Thread(sThread4);
		thread4.start();
	}

}
