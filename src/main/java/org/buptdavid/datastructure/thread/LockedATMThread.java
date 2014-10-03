package org.buptdavid.datastructure.thread;

/**
 * LockedATM线程
 * @author weijielu
 * @see LockedATM
 */
public class LockedATMThread extends Thread{
	private LockedATM atm;
	
	public LockedATMThread(LockedATM atm){
		this.atm = atm;
	}
	
	public void run(){
		atm.deposit(200);
		atm.withDraw(700);
		atm.deposit(500);
		atm.withDraw(600);
	}

}
