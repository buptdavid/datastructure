package org.buptdavid.datastructure.tree;

/**
 * 实现树的前序,中序,后续遍历搜索
 * @author weijielu
 * @see TreeSearchTest
 * @see TreeNode
 */
public class TreeSearch<T> {
	StringBuffer searchPath = new StringBuffer();
	private boolean isSearched = false;
	
	/**
	 * 前序遍历root查询item
	 * @param item
	 * @return
	 */
	public void preorderTraversal(TreeNode<T> root, T data){
		if(root == null){
			return;
		}
		
		if(!isSearched){
			if(!searchPath.toString().equals("")){
				searchPath.append("->");
			}
			searchPath.append(root.data);
			if(root.data.equals(data))
				isSearched = true;
		}
		
		if(!isSearched)
		    preorderTraversal(root.left, data);
		if(!isSearched)
		    preorderTraversal(root.right, data);
	}
	
	/**
	 * 中序遍历root查询item
	 * @param root
	 * @param item
	 * @return
	 */
	public void inorderTraversal(TreeNode<T> root, T data){
		if(root == null){
			return;
		}
		
		if(!isSearched)
		    inorderTraversal(root.left, data);
		
		if(!isSearched){
			if(!searchPath.toString().equals("")){
				searchPath.append("->");
			}
			searchPath.append(root.data);
			if(root.data.equals(data))
				isSearched = true;
		}
		
		if(!isSearched)
		    inorderTraversal(root.right, data);
	}
	
	/**
	 * 后续遍历root查询item
	 * @param item
	 * @return
	 */
	public void postorderTraversal(TreeNode<T> root, T data){
		if(root == null){
			return;
		}
		
		if(!isSearched)
		    postorderTraversal(root.left, data);
		
		if(!isSearched)
		    postorderTraversal(root.right, data);
		
		if(!isSearched){
			if(!searchPath.toString().equals("")){
				searchPath.append("->");
			}
			searchPath.append(root.data);
			if(root.data.equals(data))
				isSearched = true;
		}
	}
}
