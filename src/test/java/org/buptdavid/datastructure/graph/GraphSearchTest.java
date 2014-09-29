package org.buptdavid.datastructure.graph;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * GraphSearch测试
 * @author weijielu
 * @see GraphNode
 * @see GraphSearch
 */
public class GraphSearchTest {
	GraphNode<Integer> node1;
	GraphNode<Integer> node2;
	GraphNode<Integer> node3;
	GraphNode<Integer> node4;
	GraphNode<Integer> node5;
	GraphNode<Integer> node6;
	GraphNode<Integer> node7;
	GraphNode<Integer> node8;
	GraphNode<Integer> node9;
	GraphNode<Integer> node10;
	
	@Before
	public void before(){
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
		
		node2.neighborList.add(node4);
		node2.neighborList.add(node5);
		node2.neighborList.add(node6);
		
		node3.neighborList.add(node1);
		node3.neighborList.add(node6);
		node3.neighborList.add(node7);
		node3.neighborList.add(node8);
		
		node4.neighborList.add(node2);
		node4.neighborList.add(node5);
		
		node5.neighborList.add(node2);
		node5.neighborList.add(node4);
		node5.neighborList.add(node6);
		
		node6.neighborList.add(node2);
		node6.neighborList.add(node5);
		node6.neighborList.add(node3);
		node6.neighborList.add(node8);
		node6.neighborList.add(node9);
		node6.neighborList.add(node10);
		
		node7.neighborList.add(node3);
		
		node8.neighborList.add(node3);
		node8.neighborList.add(node6);
		node8.neighborList.add(node9);
		
		node9.neighborList.add(node6);
		node9.neighborList.add(node8);
		node9.neighborList.add(node10);
		
		node10.neighborList.add(node6);
		node10.neighborList.add(node9);
	}
	
	@Test
	public void searchDFSTest(){
		GraphSearch<Integer> graphSearch = new GraphSearch<Integer>();
		graphSearch.searchDFS(node1);
		
		String expectedSearchPath = "1->2->4->5->6->3->7->8->9->10";
		Assert.assertEquals(expectedSearchPath, graphSearch.searchPathDFS.toString());
	}

	@Test
	public void searchBFSTest(){
		GraphSearch<Integer> graphSearch = new GraphSearch<Integer>();
		graphSearch.searchBFS(node1);
		
		String expectedSearchPath = "1->2->3->4->5->6->7->8->9->10";
		Assert.assertEquals(expectedSearchPath, graphSearch.searchPathBFS.toString());
	}
}
