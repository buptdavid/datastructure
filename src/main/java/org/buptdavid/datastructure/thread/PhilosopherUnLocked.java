package org.buptdavid.datastructure.thread;

/**
 * 哲学家就餐问题的 不会死锁的 哲学家
 * @author weijielu
 * @see ChopStickUnLocked
 * @see PhilosopherUnLockedEat
 */
public class PhilosopherUnLocked extends PhilosopherLocked {

	public PhilosopherUnLocked(String name, ChopStickUnLocked left, ChopStickUnLocked right) {
		super(name, left, right);
	}
	
	public void eat(){
		if(pickUp()){
			chew();
			putDown();
		}
	}
	
	public boolean pickUp(){
		System.out.println("哲学家 " + name + " 准备拿左筷子...");
		if(!left.pickUp()){
			System.out.println("哲学家 " + name + " 放弃拿左筷子");
			return false;
		}
		
		System.out.println("哲学家 " + name + " 准备拿右筷子...");
		if(!right.pickUp()){
			System.out.println("哲学家 " + name + " 放弃拿右筷子...");
			System.out.println("哲学家 " + name + " 放下左筷子...");
			left.putDown();
			return false;
		}
		return true;
	}

}
