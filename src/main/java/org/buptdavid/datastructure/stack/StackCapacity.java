package org.buptdavid.datastructure.stack;

/**
 * 记录栈的最大存储容量和栈中内容实际索引值
 * 
 * @author weijielu
 * 
 */
public class StackCapacity<T> extends Stack<T> {
	private int capacity;
	private int index = 0;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public StackCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void push(T data) {
		super.push(data);
		index++;
	}

	public T pop() {
		index--;
		return super.pop();
	}

	public boolean isFull() {
		return (index == capacity);
	}
}
