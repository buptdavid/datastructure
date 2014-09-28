package org.buptdavid.datastructure.stack;

import junit.framework.Assert;

import org.buptdavid.datastructure.Node;
import org.junit.Test;

/**
 * 栈的实现测试类
 * @author weijielu
 * @see Stack
 * @see SetOfStacks
 * @see StackWithMin
 * @see IStack
 * @see Node
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
	
	@Test
	public void testSetOfStacks(){
		stack = new SetOfStacks<Integer>(3);
        stack.push(5);
        stack.push(8);
        stack.push(7);
        stack.push(3);
        stack.push(2);
        
        Assert.assertEquals(Integer.valueOf(2), stack.pop());
        Assert.assertEquals(Integer.valueOf(3), stack.peek());
        Assert.assertEquals(Integer.valueOf(3), stack.pop());
        stack.push(1);
        Assert.assertEquals(Integer.valueOf(1), stack.peek());
        Assert.assertEquals(Integer.valueOf(1), stack.pop());
        Assert.assertTrue(stack.pop().equals(7));
	}
	
	@Test
	public void testStackWithMin(){
		StackWithMin s = new StackWithMin();
        s.push(4);
        s.push(2);
        Assert.assertEquals(Integer.valueOf(2), s.min());
        
        s.push(3);
        Assert.assertEquals(Integer.valueOf(2), s.min());
        
        s.push(1);
        Assert.assertEquals(Integer.valueOf(1), s.min());
        
        Assert.assertEquals(Integer.valueOf(1), s.peek());
        Assert.assertEquals(Integer.valueOf(1), s.pop());
        Assert.assertEquals(Integer.valueOf(2), s.min());
	}
}
