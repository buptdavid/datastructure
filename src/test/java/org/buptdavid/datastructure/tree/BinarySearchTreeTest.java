package org.buptdavid.datastructure.tree;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * 二叉查找树测试
 * @author weijielu
 * @see BinarySearchTree
 * @see TreeNode
 */
public class BinarySearchTreeTest {
	TreeNode<Integer> node8;
	TreeNode<Integer> node6;
	TreeNode<Integer> node4;
	TreeNode<Integer> node7;
	TreeNode<Integer> node5;
	TreeNode<Integer> node4_4;
	TreeNode<Integer> node11;
	TreeNode<Integer> node9;
	TreeNode<Integer> node9_9;
	TreeNode<Integer> node12;
	
	@Before
	public void testBefore(){
		node8 = new TreeNode<Integer>(8);
		node6 = new TreeNode<Integer>(6);
		node4 = new TreeNode<Integer>(4);
		node7 = new TreeNode<Integer>(7);
		node5 = new TreeNode<Integer>(5);
		node4_4 = new TreeNode<Integer>(4);
		node11 = new TreeNode<Integer>(11);
		node9 = new TreeNode<Integer>(9);
		node9_9 = new TreeNode<Integer>(9);
	    node12 = new TreeNode<Integer>(12);
	}
	
	/**
	 * 测试是二叉树情况
	 */
	@Test
	public void testYES(){
		node8.left = node6;
		node8.right = node11;
		
		node6.left = node4;
		node6.right = node7;
		
		node4.left = node4_4;
		node4.right = node5;
		
		node11.left = node9;
		node11.right = node12;
		
		node9.left = node9_9;
		
		Assert.assertTrue(BinarySearchTree.checkBST(node8));
	}
	
	/**
	 * 测试非二叉树情况
	 */
	public void testNO(){
		node8.left = node6;
		node8.right = node11;
		
		node6.left = node4;
		node6.right = node7;
		
		node4.left = node5;
		node4.right = node4_4;
		
		node11.left = node9;
		node11.right = node12;
		
		node9.left = node9_9;
		
		Assert.assertFalse(BinarySearchTree.checkBST(node8));
	}

}
