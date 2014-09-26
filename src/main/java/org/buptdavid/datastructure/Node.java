package org.buptdavid.datastructure;

/**
 * 链表的节点
 * @author weijielu
 */
public class Node<T> {
    public Node<T> next;
    public T data;
    
    public Node(T _data){
        data = _data;
    }
}
