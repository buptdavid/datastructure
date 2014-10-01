package org.buptdavid.datastructure.graph;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * DirectedGraphPach测试
 * @author weijielu
 * @see GraphNode
 * @see DirectedGraphPathCheck
 */
public class DirectedGraphPathCheckTest {
	static GraphNode<Integer> node1;
	static GraphNode<Integer> node2;
	static GraphNode<Integer> node3;
	static GraphNode<Integer> node4;
	static GraphNode<Integer> node5;
	static GraphNode<Integer> node6;
	static GraphNode<Integer> node7;
	static GraphNode<Integer> node8;
	static GraphNode<Integer> node9;
	static GraphNode<Integer> node10;
	
	@BeforeClass
	public static void beforeClass(){
		node1 = new GraphNode<Integer>(1);
		node2 = new GraphNode<Integer>(2);
		node3 = new GraphNode<Integer>(3);
		node4 = new GraphNode<Integer>(4);
		node5 = new GraphNode<Integer>(5);
		node6 = new GraphNode<Integer>(6);
		node7 = new GraphNode<Integer>(7);
		node8 = new GraphNode<Integer>(8);
		node9 = new GraphNode<Integer>(9);
		node10 = new GraphNode<Integer>(10);
		
		node1.neighborList.add(node2);
		node1.neighborList.add(node3);
		node1.neighborList.add(node4);
		
		node2.neighborList.add(node5);
		node2.neighborList.add(node6);
		
		node3.neighborList.add(node8);
		
		node4.neighborList.add(node5);
		node4.neighborList.add(node8);
		
		node5.neighborList.add(node10);
		
		node8.neighborList.add(node7);
		
		node7.neighborList.add(node9);
	}
	
	@Test
	public void testPathCheckDFS(){
		Assert.assertTrue(DirectedGraphPathCheck.pathCheckDFS(node1, node9));
		Assert.assertTrue(DirectedGraphPathCheck.pathCheckDFS(node4, node4));
		
		Assert.assertTrue(DirectedGraphPathCheck.pathCheckDFS(node4, node8));
		
		Assert.assertTrue(DirectedGraphPathCheck.pathCheckDFS(node4, node9));
		Assert.assertTrue(DirectedGraphPathCheck.pathCheckDFS(node9, node4));
		
		Assert.assertFalse(DirectedGraphPathCheck.pathCheckDFS(node3, node4));
		Assert.assertFalse(DirectedGraphPathCheck.pathCheckDFS(node6, node4));
	}
	
	@Test
	public void testPathCheckBFS(){
		Assert.assertTrue(DirectedGraphPathCheck.pathCheckBFS(node1, node9));
		Assert.assertTrue(DirectedGraphPathCheck.pathCheckBFS(node4, node4));
		
		Assert.assertTrue(DirectedGraphPathCheck.pathCheckBFS(node4, node8));
		
		Assert.assertTrue(DirectedGraphPathCheck.pathCheckBFS(node4, node9));
		Assert.assertTrue(DirectedGraphPathCheck.pathCheckBFS(node9, node4));
		
		Assert.assertFalse(DirectedGraphPathCheck.pathCheckBFS(node3, node4));
		Assert.assertFalse(DirectedGraphPathCheck.pathCheckBFS(node6, node4));
	}
	

}
