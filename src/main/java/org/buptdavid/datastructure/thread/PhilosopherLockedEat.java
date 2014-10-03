package org.buptdavid.datastructure.thread;

/**
 * 十个死锁哲学家就餐
 * @author weijielu
 * @see ChopStickLocked
 * @see PhilosopherLocked
 */
public class PhilosopherLockedEat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ChopStickLocked chopStick1 = new ChopStickLocked();
		ChopStickLocked chopStick2 = new ChopStickLocked();
		PhilosopherLocked philosopherA = new PhilosopherLocked("A", chopStick1, chopStick2);
		ChopStickLocked chopStick3 = new ChopStickLocked();
		PhilosopherLocked philosopherB = new PhilosopherLocked("B", chopStick2, chopStick3);
		ChopStickLocked chopStick4 = new ChopStickLocked();
		PhilosopherLocked philosopherC = new PhilosopherLocked("C", chopStick3, chopStick4);
		ChopStickLocked chopStick5 = new ChopStickLocked();
		PhilosopherLocked philosopherD = new PhilosopherLocked("D", chopStick4, chopStick5);
		ChopStickLocked chopStick6 = new ChopStickLocked();
		PhilosopherLocked philosopherE = new PhilosopherLocked("E", chopStick5, chopStick6);
		ChopStickLocked chopStick7 = new ChopStickLocked();
		PhilosopherLocked philosopherF = new PhilosopherLocked("F", chopStick6, chopStick7);
		ChopStickLocked chopStick8 = new ChopStickLocked();
		PhilosopherLocked philosopherG = new PhilosopherLocked("G", chopStick7, chopStick8);
		ChopStickLocked chopStick9 = new ChopStickLocked();
		PhilosopherLocked philosopherH = new PhilosopherLocked("H", chopStick8, chopStick9);
		ChopStickLocked chopStick10 = new ChopStickLocked();
		PhilosopherLocked philosopherI = new PhilosopherLocked("I", chopStick9, chopStick10);
		
		PhilosopherLocked philosopherJ = new PhilosopherLocked("J", chopStick10, chopStick1);
		
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
