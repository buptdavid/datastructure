package org.buptdavid.datastructure.graph;

import java.util.List;

import org.buptdavid.datastructure.queue.IQueue;
import org.buptdavid.datastructure.queue.Queue;

/**
 * 给出有向图的两个节点判断两者之间是否有一路径
 * @author weijielu
 * @see GraphNode
 * @see DirectedGraphPathCheck
 */
public class DirectedGraphPathCheck {

	/**
	 * 利用深度优先搜索进行路径判断p - q 之间是否有路径
	 * @param p
	 * @param q
	 * @return
	 */
	public static boolean pathCheckDFS(GraphNode<Integer> p, GraphNode<Integer> q){
		boolean isFound =false;
		
		p.restoreVisited();
		isFound |= pathOrderCheckDFS(p, q);
		
		q.restoreVisited();
		isFound |= pathOrderCheckDFS(q, p);
		
		return isFound;
	}
	
	/**
	 * 利用深度优先搜索进行路径判断 p -> q 是否有路径
	 * @return
	 */
	private static boolean pathOrderCheckDFS(GraphNode<Integer> p, GraphNode<Integer> q){
		if(p.equals(q)){
			return true;
		}
		
		boolean isFound = false;
		List<GraphNode<Integer>> pNeighborList = p.neighborList;
		for(int i = 0; i < pNeighborList.size(); i++){
			GraphNode<Integer> neighbor = pNeighborList.get(i);
			if(!neighbor.visited){
				neighbor.visited = true;
				if(neighbor.equals(q)){
					return true;
				}
				
				isFound = isFound || pathOrderCheckDFS(neighbor, q);
			}
		}
		
		return isFound;
	}
	
	/**
	 * 利用广度优先搜索进行路径判断 p - q 之间是否有路径
	 * @param p
	 * @param q
	 * @return
	 */
	public static boolean pathCheckBFS(GraphNode<Integer> p, GraphNode<Integer> q){
		boolean isFound =false;
		
		p.restoreVisited();
		isFound |= pathOrderCheckBFS(p, q);
		
		q.restoreVisited();
		isFound |= pathOrderCheckBFS(q, p);
		
		return isFound;
	}

	/**
	 * 利用广度优先搜索进行路径判断 p -> q 是否有路径
	 * @return
	 */
	private static boolean pathOrderCheckBFS(GraphNode<Integer> p, GraphNode<Integer> q){
		IQueue<GraphNode<Integer>> queue = new Queue<GraphNode<Integer>> ();
		
		if(!p.visited && p.equals(q)){
			return true;
		}
		
		p.visited = true;
		queue.enqueue(p);
		
		while(!queue.isEmpty()){
			List<GraphNode<Integer>> neighbors = queue.dequeue().neighborList;
			for(int i = 0; i < neighbors.size(); i++){
				GraphNode<Integer> neighbor = neighbors.get(i);
				
				if(!neighbor.visited && neighbor.equals(q)){
					return true;
				}
				neighbor.visited = true;
				queue.enqueue(neighbor);
			}
		}
		
		return false;
	}
}
