package org.buptdavid.datastructure.queue;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author weijielu
 *
 */
public class QueueTest {
	IQueue<Integer> queue;
	
	@Test
	public void testQueue(){
		queue = new Queue<Integer>();
		test();
	}
	
	@Test
	public void testQueueWith2Stack(){
		queue = new QueueWith2Stack<Integer>();
		test();
	}
	
	public void test(){
		queue.enqueue(1);
		queue.enqueue(2);
		Assert.assertEquals(Integer.valueOf(1), queue.peek());
		Assert.assertEquals(Integer.valueOf(1), queue.dequeue());
		
		queue.enqueue(3);
		Assert.assertFalse(queue.isEmpty());
		Assert.assertEquals(Integer.valueOf(2), queue.dequeue());
		Assert.assertEquals(Integer.valueOf(3), queue.dequeue());
		
		Assert.assertEquals(null, queue.dequeue());
		Assert.assertEquals(null, queue.peek());
		Assert.assertTrue(queue.isEmpty());
	}

}
