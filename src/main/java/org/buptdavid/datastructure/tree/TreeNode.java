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
	
	/**
	 * 输出树
	 */
//	public void printTree(){
//		int height = getHeight(this);
//		String[][] array = new String[height][height*2];
//		
//		TreeNode<T> left = this.left;
//		TreeNode<T> right = this.right;
//		
//	}
	
	/**
	 * 返回树root的高度
	 * @param root
	 * @return
	 */
//	private int getHeight(TreeNode<T> root){
//		if(root == null){
//			return 0;
//		}
//		
//		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
//	}
}
