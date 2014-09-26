/**
 * 
 */
package org.buptdavid.datastructure.stack;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 栈的实现测试类
 * @author weijielu
 */
public class StackTest {
	IStack<Integer> stack;
	
	@Test
	public void testStack(){
		stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		Assert.assertEquals(Integer.valueOf(2), stack.peek());
		Assert.assertEquals(Integer.valueOf(2), stack.pop());
		
		stack.push(3);
		Assert.assertEquals(Integer.valueOf(3), stack.pop());
		Assert.assertFalse(stack.isEmpty());
		Assert.assertEquals(Integer.valueOf(1), stack.pop());
		
		Assert.assertEquals(null, stack.peek());
		Assert.assertEquals(null, stack.pop());
		Assert.assertTrue(stack.isEmpty());
	}
}
