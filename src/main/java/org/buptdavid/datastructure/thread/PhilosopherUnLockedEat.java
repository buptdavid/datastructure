package org.buptdavid.datastructure.thread;

/**
 * 十个不会死锁哲学家就餐
 * @author weijielu
 * @see ChopStickUnLocked
 * @see PhilosopherUnLocked
 */
public class PhilosopherUnLockedEat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ChopStickUnLocked chopStick1 = new ChopStickUnLocked();
		ChopStickUnLocked chopStick2 = new ChopStickUnLocked();
		PhilosopherUnLocked philosopherA = new PhilosopherUnLocked("A", chopStick1, chopStick2);
		ChopStickUnLocked chopStick3 = new ChopStickUnLocked();
		PhilosopherUnLocked philosopherB = new PhilosopherUnLocked("B", chopStick2, chopStick3);
		ChopStickUnLocked chopStick4 = new ChopStickUnLocked();
		PhilosopherUnLocked philosopherC = new PhilosopherUnLocked("C", chopStick3, chopStick4);
		ChopStickUnLocked chopStick5 = new ChopStickUnLocked();
		PhilosopherUnLocked philosopherD = new PhilosopherUnLocked("D", chopStick4, chopStick5);
		ChopStickUnLocked chopStick6 = new ChopStickUnLocked();
		PhilosopherUnLocked philosopherE = new PhilosopherUnLocked("E", chopStick5, chopStick6);
		ChopStickUnLocked chopStick7 = new ChopStickUnLocked();
		PhilosopherUnLocked philosopherF = new PhilosopherUnLocked("F", chopStick6, chopStick7);
		ChopStickUnLocked chopStick8 = new ChopStickUnLocked();
		PhilosopherUnLocked philosopherG = new PhilosopherUnLocked("G", chopStick7, chopStick8);
		ChopStickUnLocked chopStick9 = new ChopStickUnLocked();
		PhilosopherUnLocked philosopherH = new PhilosopherUnLocked("H", chopStick8, chopStick9);
		ChopStickUnLocked chopStick10 = new ChopStickUnLocked();
		PhilosopherUnLocked philosopherI = new PhilosopherUnLocked("I", chopStick9, chopStick10);
		
		PhilosopherUnLocked philosopherJ = new PhilosopherUnLocked("J", chopStick10, chopStick1);
		
		philosopherA.start();
		philosopherB.start();
		philosopherC.start();
		philosopherD.start();
		philosopherE.start();
		philosopherF.start();
		philosopherG.start();
		philosopherH.start();
		philosopherI.start();
		philosopherJ.start();
	}

}
