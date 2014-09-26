package org.buptdavid.datastructure.linkedlist;

import org.buptdavid.datastructure.Node;

/**
 * 给出一个值,将链表中左边数据都小于此值,右边的值都大于等于此值
 * 
 * @author weijielu
 * 
 */
public class SortWithValue {
	
	/**
	 * 较差的方法
	 * @param head
	 * @param x
	 * @return
	 */
	public static Node<Integer> sort(Node<Integer> head, int x) {
		if (head == null) {
			return null;
		}

		Node<Integer> beforeStart = null;
		Node<Integer> beforeEnd = null;
		Node<Integer> afterStart = null;
		Node<Integer> afterEnd = null;

		while (head != null) {
			Node<Integer> next = head.next;
			head.next = null;
			if (head.data < x) {
				if (beforeStart == null) {
					beforeStart = head;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = head;
					beforeEnd = head;
				}
			} else {
				if (afterStart == null) {
					afterStart = head;
					afterEnd = afterStart;
				} else {
					afterEnd.next = head;
					afterEnd = head;
				}
			}

			head = next;
		}

		if (beforeStart != null) {
			beforeEnd.next = afterStart;
			head = beforeStart;
		} else {
			head = afterStart;
		}

		return head;
	}

	/**
	 * 较优的方法
	 * @param node
	 * @param x
	 * @return
	 */
	public static Node<Integer> sortGood(Node<Integer> node, int x) {
		if (node == null) {
			return node;
		}

		Node<Integer> beforeStart = null;
		Node<Integer> afterStart = null;

		while (node != null) {
			Node<Integer> next = node.next;

			if (node.data < x) {
				node.next = beforeStart;
				beforeStart = node;
			} else {
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
		}

		Node<Integer> head = null;
		if (beforeStart == null) {
			head = afterStart;
		} else {
			head = beforeStart;
			while (beforeStart.next != null) {
				beforeStart = beforeStart.next;
			}
			beforeStart.next = afterStart;
		}

		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> node1 = new Node<Integer>(2);
		Node<Integer> node2 = new Node<Integer>(8);
		Node<Integer> node3 = new Node<Integer>(6);
		Node<Integer> node4 = new Node<Integer>(10);
		Node<Integer> node5 = new Node<Integer>(7);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		Node<Integer> head = node1;
		while (node1 != null) {
			System.out.print(node1.data + " ");
			node1 = node1.next;
		}

		System.out.println("\r\nSort....");
		node1 = sortGood(head, 6);

		while (node1 != null) {
			System.out.print(node1.data + " ");
			node1 = node1.next;
		}

	}

}
