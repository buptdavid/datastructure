package org.buptdavid.datastructure.queue;

/**
 * 队列的接口
 * @author weijielu
 */
public interface IQueue<T> {
	
	/**
	 * 入队列操作
	 * @param item
	 */
	void enqueue(T item);
	
	/**
	 * 出队列操作
	 * @return
	 */
	T dequeue();
	
	/**
	 * 返回队列头，但不出退咧
	 * @return
	 */
	T peek();
	
	/**
	 * 队列是否为空
	 * @return
	 */
	boolean isEmpty();
}
