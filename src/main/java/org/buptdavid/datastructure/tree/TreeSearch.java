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
	public void frontSearch(TreeNode<T> root, T data){
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
			frontSearch(root.left, data);
		if(!isSearched)
		frontSearch(root.right, data);
	}
	
	/**
	 * 中序遍历root查询item
	 * @param root
	 * @param item
	 * @return
	 */
	public void middleSearch(TreeNode<T> root, T data){
		if(root == null){
			return;
		}
		
		if(!isSearched)
			middleSearch(root.left, data);
		
		if(!isSearched){
			if(!searchPath.toString().equals("")){
				searchPath.append("->");
			}
			searchPath.append(root.data);
			if(root.data.equals(data))
				isSearched = true;
		}
		
		if(!isSearched)
			middleSearch(root.right, data);
	}
	
	/**
	 * 后续遍历root查询item
	 * @param item
	 * @return
	 */
	public void behindSearch(TreeNode<T> root, T data){
		if(root == null){
			return;
		}
		
		if(!isSearched)
			behindSearch(root.left, data);
		
		if(!isSearched)
			behindSearch(root.right, data);
		
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
