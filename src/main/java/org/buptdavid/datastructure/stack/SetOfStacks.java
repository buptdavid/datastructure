package org.buptdavid.datastructure.stack;

import java.util.ArrayList;
import java.util.List;

import org.buptdavid.datastructure.Node;


/**
 * 此类用来表示若干具有一定容量的栈的集合<br>
 * 当第一个栈push满后，push第二个栈，以此类推<br>
 * 当最后一个栈pop空后，pop倒数第二个栈，依次类推<br>
 * 
 * @author weijielu
 * @see StackTest
 * @see IStack
 * @see Node
 */
public class SetOfStacks<T> implements IStack<T> {
	List<StackCapacity<T>> stacks = new ArrayList<StackCapacity<T>>();

	public static int index = -1;
	private int capacity;

	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}

	public void push(T item) {
		StackCapacity<T> last = getLastStack();
		if (last != null && !last.isFull()) {
			last.push(item);
		} else {
			StackCapacity<T> stack = new StackCapacity<T>(capacity);
			stack.push(item);
			stacks.add(stack);
			index++;
		}
	}

	public T pop() {
		StackCapacity<T> last = getLastStack();
		T value = null;
		if (last != null) {
			value = last.pop();
			if (last.getIndex() == 0) {
				stacks.remove(index--);
			}
		}
		return value;
	}

	public T peek() {
		StackCapacity<T> last = getLastStack();
		T value = null;
		if (last != null) {
			value = last.peek();
		}
		return value;
	}

	public boolean isEmpty() {
		StackCapacity<T> last = getLastStack();
		return (last == null);
	}

	/**
	 * 返回最后的栈
	 * 
	 * @return
	 */
	private StackCapacity<T> getLastStack() {
		if (stacks.size() == 0) {
			return null;
		} else {
			return stacks.get(index);
		}
	}

}
