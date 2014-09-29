package org.buptdavid.datastructure.graph;

import org.buptdavid.datastructure.queue.IQueue;
import org.buptdavid.datastructure.queue.Queue;

/**
 * 图的广度优先搜索和深度优先搜索实现
 * 
 * @author weijielu
 * @see GraphNode
 * @see GraphSearchTest
 */
public class GraphSearch<T> {

	public StringBuffer searchPathDFS = new StringBuffer();
	public StringBuffer searchPathBFS = new StringBuffer();

	/**
	 * 深度优先搜索实现
	 * 
	 * @param root
	 */
	public void searchDFS(GraphNode<T> root) {
		if (root == null) {
			return;
		}

		// visited root
		if (searchPathDFS.length() > 0) {
			searchPathDFS.append("->");
		}
		searchPathDFS.append(root.data.toString());
		root.visited = true;

		for (GraphNode<T> node : root.neighborList) {
			if (!node.visited) {
				searchDFS(node);
			}
		}
	}

	/**
	 * 广度优先搜索实现,使用队列
	 * 
	 * @param root
	 */
	public void searchBFS(GraphNode<T> root) {
		IQueue<GraphNode<T>> queue = new Queue<GraphNode<T>>();
		
		// visited root
		if (searchPathBFS.length() > 0) {
			searchPathBFS.append("->");
		}
		searchPathBFS.append(root.data.toString());
		root.visited = true;
		
		// 加到队列队尾
		queue.enqueue(root);
		
		while(!queue.isEmpty()){
			GraphNode<T> r = queue.dequeue();
			for (GraphNode<T> node : r.neighborList) {
				if (!node.visited) {
					searchPathBFS.append("->");
					searchPathBFS.append(node.data.toString());
					node.visited = true;
					
					queue.enqueue(node);
				}
			}
		}
	}
	
}
