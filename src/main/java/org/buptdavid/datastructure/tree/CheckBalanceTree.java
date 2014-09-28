package org.buptdavid.datastructure.tree;

/**
 * 检查是否平衡树,此处平衡树的定义是两棵子树的高度差不超过1
 * @author weijielu
 * @see CheckBalanceTreeTest
 * @see TreeNode
 */
public class CheckBalanceTree {
	
	/**
	 * 返回树的高度
	 * @param root
	 * @return
	 */
	private static int getHeight(TreeNode<Integer> root){
		if(root == null){
			return 0;
		}
		
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	/**
	 * 判断树是否平衡<br>
	 * 此方法时间复杂度为O(NlogN),效率不高
	 * @param root
	 * @return
	 */
	public static boolean isBalanced(TreeNode<Integer> root){
		if(root == null){
			return true;
		}
		
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if(Math.abs(heightDiff) > 1){
			return false;
		}else{
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}

	/**
	 * 检查树的高度,若子树不平衡直接返回-1
	 * @return
	 */
	private static int checkHeight(TreeNode<Integer> root){
		if(root == null){
			return 0;
		}
		
		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1){
			return -1;
		}
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == -1){
			return -1;
		}
		
		int heightDiff = leftHeight -  rightHeight;
		if(Math.abs(heightDiff) > 1){
			return -1;
		}else{
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	public static boolean isBalancedGood(TreeNode<Integer> root){
		if(checkHeight(root) == -1){
			return false;
		}else{
			return true;
		}
	}
	
}
