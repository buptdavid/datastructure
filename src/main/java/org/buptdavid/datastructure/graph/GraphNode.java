package org.buptdavid.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 图的节点
 * @author weijielu
 */
public class GraphNode<T> {
	T data;
	List<GraphNode<T>> neighborList;
	boolean visited;
	
	public GraphNode(T data){
		this.data = data;
		neighborList = new ArrayList<GraphNode<T>>();
		visited = false;
	}
}
