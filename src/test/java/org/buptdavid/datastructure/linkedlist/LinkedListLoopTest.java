package org.buptdavid.datastructure.linkedlist;

import org.buptdavid.datastructure.Node;
import org.junit.Assert;
import org.junit.Test;

/**
 * LinkedListRing测试类
 * @author weijielu
 * @see LinkedListLoop
 */
public class LinkedListLoopTest {
	
	@Test
	public void test(){
		Node<Integer> node1 = null;
		Node<Integer> node2 = null;
		Node<Integer> node3 = null;
		Node<Integer> node4 = null;
		
		Assert.assertFalse(LinkedListLoop.isExistLoop(node1));
		Assert.assertEquals(0, LinkedListLoop.loopLength(node1));
		Assert.assertEquals(null, LinkedListLoop.findLoopEntrance(node1));
		
		node1 = new Node<Integer>(1);
		node1.next = node1;
		Assert.assertTrue(LinkedListLoop.isExistLoop(node1));
		Assert.assertEquals(1, LinkedListLoop.loopLength(node1));
		Assert.assertEquals(node1, LinkedListLoop.findLoopEntrance(node1));
		
		node1 = new Node<Integer>(1);
		node2 = new Node<Integer>(2);
		node1.next = node2;
		node2.next = node1;
		Assert.assertTrue(LinkedListLoop.isExistLoop(node1));
		Assert.assertEquals(2, LinkedListLoop.loopLength(node1));
		Assert.assertEquals(node1, LinkedListLoop.findLoopEntrance(node1));
		
		node1 = new Node<Integer>(1);
		node2 = new Node<Integer>(2);
		node3 = new Node<Integer>(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node2;
		Assert.assertTrue(LinkedListLoop.isExistLoop(node1));
		Assert.assertEquals(2, LinkedListLoop.loopLength(node1));
		Assert.assertEquals(node2, LinkedListLoop.findLoopEntrance(node1));
		
		node1 = new Node<Integer>(1);
		node2 = new Node<Integer>(2);
		node3 = new Node<Integer>(3);
		node1.next = node2;
		node2.next = node3;
		Assert.assertFalse(LinkedListLoop.isExistLoop(node1));
		Assert.assertEquals(0, LinkedListLoop.loopLength(node1));
		Assert.assertEquals(null, LinkedListLoop.findLoopEntrance(node1));
		
		node1 = new Node<Integer>(1);
		node2 = new Node<Integer>(2);
		node3 = new Node<Integer>(3);
		node4 = new Node<Integer>(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		Assert.assertTrue(LinkedListLoop.isExistLoop(node1));
		Assert.assertEquals(3, LinkedListLoop.loopLength(node1));
		Assert.assertEquals(node2, LinkedListLoop.findLoopEntrance(node1));
	}

}
