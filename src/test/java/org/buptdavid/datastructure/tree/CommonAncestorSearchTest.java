package org.buptdavid.datastructure.tree;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * CommonAncestorSearch测试类
 * @author weijielu
 * @see CommonAncestorSearch
 * @see TreeNode
 */
public class CommonAncestorSearchTest {
	TreeNode<Integer> root;
	TreeNode<Integer> node8;
	TreeNode<Integer> node6;
	TreeNode<Integer> node4;
	TreeNode<Integer> node7;
	TreeNode<Integer> node5;
	TreeNode<Integer> node3;
	TreeNode<Integer> node11;
	TreeNode<Integer> node9;
	TreeNode<Integer> node10;
	TreeNode<Integer> node12;
	
	/**
	 *          8
	 *       /   \
	 *     6       11
	 *    / \     / \
	 *   4   7   9   12
	 *  / \     /
	 * 3   5   10
	 */
	@Before
	public void testBefore(){
		node8 = new TreeNode<Integer>(8);
		node6 = new TreeNode<Integer>(6);
		node4 = new TreeNode<Integer>(4);
		node7 = new TreeNode<Integer>(7);
		node5 = new TreeNode<Integer>(5);
		node3 = new TreeNode<Integer>(3);
		node11 = new TreeNode<Integer>(11);
		node9 = new TreeNode<Integer>(9);
		node10 = new TreeNode<Integer>(10);
	    node12 = new TreeNode<Integer>(12);
	    
	    node8.left = node6;
		node8.right = node11;
		
		node6.left = node4;
		node6.right = node7;
		
		node4.left = node3;
		node4.right = node5;
		
		node11.left = node9;
		node11.right = node12;
		
		node9.left = node10;
		
		root = node8;
	}
	
	@Test
	public void searchCommonAncestorTest(){
		Assert.assertEquals(node4, CommonAncestorSearch.searchCommonAncestor(root, node3, node5));
		Assert.assertEquals(node6, CommonAncestorSearch.searchCommonAncestor(root, node3, node7));
		
		Assert.assertEquals(root, CommonAncestorSearch.searchCommonAncestor(root, node5, node10));
		
		Assert.assertEquals(node11, CommonAncestorSearch.searchCommonAncestor(root, node10, node12));
		
		Assert.assertEquals(null, CommonAncestorSearch.searchCommonAncestor(node6, node3, node10));
		Assert.assertEquals(null, CommonAncestorSearch.searchCommonAncestor(node6, root, node3));
	}
}
