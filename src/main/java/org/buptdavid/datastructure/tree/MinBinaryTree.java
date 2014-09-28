package org.buptdavid.datastructure.tree;

/**
 * 将一个有序的数组变成一个最小高度的二叉查找树
 * @author weijielu
 */
public class MinBinaryTree {
	
	public static TreeNode<Integer> insertNodeFromArray(int[] array, int start, int end){
		if(end < start){
			return null;
		}
		
		int middle =  (start + end) / 2;
		
		TreeNode<Integer> treeNode = new TreeNode<Integer>(array[middle]);
		
		treeNode.left = insertNodeFromArray(array, start, middle - 1);
		treeNode.right = insertNodeFromArray(array, middle + 1, end);
		
		return treeNode;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		MinBinaryTree.insertNodeFromArray(array, 0, array.length - 1);

	}

}
