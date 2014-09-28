package org.buptdavid.datastructure.stack;

/**
 * 栈的接口
 * @author weijielu
 * @see Stack
 * @see SetOfStacks
 * @see StackWithMin
 * @see StackTest
 */
public interface IStack<T> {
	
	/**
	 * 入栈操作
	 * @param item
	 */
	void push(T item);
	
	/**
	 * 出栈操作
	 * @return
	 */
	T pop();
	
	/**
	 * 返回栈顶元素，但不出栈
	 * @return
	 */
	T peek();
	
	/**
     * 栈是否为空
     * @return boolean
     */
	boolean isEmpty();
}
