package org.buptdavid.datastructure.tree;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * TreeSearch测试类
 * @author weijielu
 * @see TreeSearch
 * @see TreeNode
 */
public class TreeSearchTest {
	
	private static TreeNode<Integer> root;
	
	@BeforeClass
	public static void beforeClass(){
		TreeNode<Integer> node1 = new TreeNode<Integer>(1);
		TreeNode<Integer> node2 = new TreeNode<Integer>(2);
		TreeNode<Integer> node3 = new TreeNode<Integer>(3);
		TreeNode<Integer> node4 = new TreeNode<Integer>(4);
		TreeNode<Integer> node5 = new TreeNode<Integer>(5);
		TreeNode<Integer> node6 = new TreeNode<Integer>(6);
		TreeNode<Integer> node7 = new TreeNode<Integer>(7);
		TreeNode<Integer> node8 = new TreeNode<Integer>(8);
		TreeNode<Integer> node9 = new TreeNode<Integer>(9);
		TreeNode<Integer> node10 = new TreeNode<Integer>(10);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		
		node4.left = node8;
		
		node7.right = node9;
		
		node9.left = node10;
		
		root = node1;
	}
	
	/**
	 * 前序遍历测试
	 */
	@Test
	public void preorderTraversalTest(){
		TreeSearch<Integer> treeSearch = new TreeSearch<Integer>();
		
		Integer value = 5;
		String expectedSearchPath = "1->2->4->8->5";
		treeSearch.preorderTraversal(root, value);
		Assert.assertTrue(expectedSearchPath.equals(treeSearch.searchPath.toString()));
		
		treeSearch = new TreeSearch<Integer>();
		
		value = 6;
		expectedSearchPath = "1->2->4->8->5->3->6";
		treeSearch.preorderTraversal(root, value);
		Assert.assertTrue(expectedSearchPath.equals(treeSearch.searchPath.toString()));
	}
	
	/**
	 * 中序遍历测试
	 */
	@Test
	public void inorderTraversalTest(){
		TreeSearch<Integer> treeSearch = new TreeSearch<Integer>();
		
		Integer value = 5;
		String expectedSearchPath = "8->4->2->5";
		treeSearch.inorderTraversal(root, value);
		Assert.assertTrue(expectedSearchPath.equals(treeSearch.searchPath.toString()));
		
		treeSearch = new TreeSearch<Integer>();
		
		value = 6;
		expectedSearchPath = "8->4->2->5->1->6";
		treeSearch.inorderTraversal(root, value);
		Assert.assertTrue(expectedSearchPath.equals(treeSearch.searchPath.toString()));
	}

	/**
	 * 后序遍历测试
	 */
	@Test
	public void postorderTraversalTest(){
		TreeSearch<Integer> treeSearch = new TreeSearch<Integer>();
		
		Integer value = 5;
		String expectedSearchPath = "8->4->5";
		treeSearch.postorderTraversal(root, value);
		Assert.assertTrue(expectedSearchPath.equals(treeSearch.searchPath.toString()));
		
		treeSearch = new TreeSearch<Integer>();
		
		value = 6;
		expectedSearchPath = "8->4->5->2->6";
		treeSearch.postorderTraversal(root, value);
		Assert.assertTrue(expectedSearchPath.equals(treeSearch.searchPath.toString()));
	}
}
