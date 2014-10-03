package org.buptdavid.datastructure.thread;

/**
 * 哲学家就餐问题的 会死锁的 哲学家
 * @author weijielu
 * @see ChopStickLocked
 * @see PhilosopherLockedEat
 */
public class PhilosopherLocked extends Thread {
	private int bites = 100;
	protected ChopStickLocked left;
	protected ChopStickLocked right;
	public String name;
	
	public PhilosopherLocked(String name, ChopStickLocked left, ChopStickLocked right){
		this.name = name;
		this.left = left;
		this.right = right;
	}

	public void eat(){
		pickUp();
		chew();
		putDown();
	}
	
	/**
	 * 哲学家分别拿起左右手的筷子
	 * @return 
	 */
	public boolean pickUp(){
		System.out.println("哲学家 " + name + " 准备拿左筷子...");
		left.pickUp();
		System.out.println("哲学家 " + name + " 拿起了左筷子");
		System.out.println("哲学家 " + name + " 准备拿右筷子...");
		right.pickUp();
		System.out.println("哲学家 " + name + " 拿起了右筷子");
		return true;
	}
	
	/**
	 * 哲学家开始就餐
	 */
	public void chew(){
		System.out.println("哲学家 " + name + " 准备吃一口...");
		int sleepTime = 0;
		try {
			sleepTime = (int)(Math.random() * 1000);
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("哲学家 " + name + " 吃完这一口, 用时 " + sleepTime + " ms");
	}
	
	/**
	 * 哲学家分别放下右左手的筷子
	 */
	public void putDown(){
		System.out.println("哲学家 " + name + " 准备放下左筷子...");
		left.putDown();
		System.out.println("哲学家 " + name + " 放下了左筷子");
		System.out.println("哲学家 " + name + " 准备放下右筷子...");
		right.putDown();
		System.out.println("哲学家 " + name + " 放下了右筷子");
	}
	
	public void run(){
		for(int i = 0; i < bites; i++){
//			try {
//				int sleepTime = (int)(Math.random() * 1000);
//				Thread.sleep(sleepTime);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			eat();
		}
	}
}
