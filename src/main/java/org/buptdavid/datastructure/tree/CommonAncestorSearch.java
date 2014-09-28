package org.buptdavid.datastructure.tree;

/**
 * 查找两个节点的共通祖先
 * @author weijielu
 * @see CommonAncestorSearchTest
 * @see TreeNode
 */
public class CommonAncestorSearch {
	
	/**
	 * 判断p节点是否是root节点的子孙节点
	 * @param root
	 * @param p
	 * @return
	 */
	private static boolean isDescendant(TreeNode<Integer> root, TreeNode<Integer> p){
		if(root  == null){
			return false;
		}
		if(root == p){
			return true;
		}
		
		return isDescendant(root.left, p) || isDescendant(root.right, p);
	}
	
	/**
	 * 返回节点p和节点q的第一个祖先节点<br>
	 * 时间复杂度为O(n)
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode<Integer> searchCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q){
		// 确保p和q都是root的子孙节点
		if(!isDescendant(root, p) || !isDescendant(root, q)){
			return null;
		}
		
		if(root == q || root== q){
			return root;
		}
		
		boolean is_p_on_left = isDescendant(root.left, p);
		boolean is_q_on_left = isDescendant(root.left, q);
		
		// 如果p和q在root的两边,则返回root
		if(is_p_on_left != is_q_on_left){
			return root;
		}
		
		// 如果p和q在root的同一边,则遍历访问那一边
		TreeNode<Integer> treeSide = is_p_on_left?root.left:root.right;
		return searchCommonAncestor(treeSide, p, q);
	}
}
