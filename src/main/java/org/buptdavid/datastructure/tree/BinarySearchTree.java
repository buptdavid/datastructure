package org.buptdavid.datastructure.tree;

/**
 * 二叉查找树的判断<br>
 * 二叉查找树:对所有节点来说:所有左子树节点都小于等于其根节点;所有右子树节点都大于其根节点
 * @author weijielu
 * @see BinarySearchTreeTest
 * @see TreeNode
 */
public class BinarySearchTree {
	
	/**
	 * Check root左子树所有节点小于等于max,root右子树所有节点大于min
	 * 
	 * @param root
	 * @param min
	 * @param max
	 * @return
	 */
	private static boolean checkBSTMinMax(TreeNode<Integer> root, Integer min, Integer max){
		if(root  == null){
			return true;
		}
		
		if(root.data > max || root.data <= min){
			return false;
		}
		
		if(!checkBSTMinMax(root.left, min, root.data) || !checkBSTMinMax(root.right, root.data, max)){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Check root是否二叉查找树
	 * @param root
	 * @return
	 */
	public static boolean checkBST(TreeNode<Integer> root){
		return checkBSTMinMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

}
