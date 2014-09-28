package org.buptdavid.datastructure.tree;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 平衡树Check测试类
 * @author weijielu
 * @see CheckBalanceTree
 * @see TreeNode
 */
public class CheckBalanceTreeTest {
	@Test
	public void testNull(){
		Assert.assertTrue(CheckBalanceTree.isBalanced(null));
		Assert.assertTrue(CheckBalanceTree.isBalancedGood(null));
	}
	
	@Test
	public void testBalanced(){
		TreeNode<Integer> node1 = new TreeNode<Integer>(1);
		TreeNode<Integer> node2 = new TreeNode<Integer>(2);
		TreeNode<Integer> node3 = new TreeNode<Integer>(3);
		TreeNode<Integer> node4 = new TreeNode<Integer>(4);
		TreeNode<Integer> node5 = new TreeNode<Integer>(5);
		TreeNode<Integer> node6 = new TreeNode<Integer>(6);
		TreeNode<Integer> node7 = new TreeNode<Integer>(7);
		TreeNode<Integer> node8 = new TreeNode<Integer>(8);
		TreeNode<Integer> node9 = new TreeNode<Integer>(9);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		
		node4.left = node8;
		
		node7.right = node9;
		
		Assert.assertTrue(CheckBalanceTree.isBalanced(node1));
		Assert.assertTrue(CheckBalanceTree.isBalancedGood(node1));
	}
	
	@Test
	public void testUnBalanced(){
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
		
		Assert.assertFalse(CheckBalanceTree.isBalanced(node1));
		Assert.assertFalse(CheckBalanceTree.isBalancedGood(node1));
	}

}
