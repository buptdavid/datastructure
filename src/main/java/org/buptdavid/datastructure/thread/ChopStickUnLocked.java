package org.buptdavid.datastructure.thread;

/**
 * 
 * @author weijielu
 */
public class ChopStickUnLocked extends ChopStickLocked {
	public ChopStickUnLocked(){
		super();
	}
	
	public boolean pickUp(){
		return lock.tryLock();
	}

}
