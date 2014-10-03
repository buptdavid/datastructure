package org.buptdavid.datastructure.thread;

/**
 * 实现接口Runnable来实现线程类
 * @author weijielu
 */
public class RunableThread implements Runnable{
	public int count = 0;
	
	public void run() {
		System.out.println("RunnableThread starting.....");
		try{
			while(count < 5){
				Thread.sleep(500);
				System.out.println("In Thread, count is " + count);
				count++;
			}
		} catch (InterruptedException e){
			System.out.println("RunnableThread interrupted.");
		}
		
		System.out.println("RunnableThread terminating.");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RunableThread instance = new RunableThread();
		Thread thread = new Thread(instance);
		thread.start();
		
		while(instance.count != 5){
			try{
				Thread.sleep(250);
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}

	}


}
