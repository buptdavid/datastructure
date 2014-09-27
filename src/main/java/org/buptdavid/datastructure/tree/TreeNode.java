package org.buptdavid.datastructure.tree;

/**
 * 树的节点
 * @author weijielu
 *
 */
public class TreeNode<T> {
	T data;
	TreeNode<T> left;
	TreeNode<T> right;
	
	public TreeNode(T data){
		this.data = data;
	}
}
