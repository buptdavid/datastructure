package org.buptdavid.datastructure.linkedlist;

import org.buptdavid.datastructure.Node;

/**
 * 删除链表中重复的元素
 * 
 * @author weijielu
 * 
 */
public class DeleteDups {

	public static void delete(Node<Integer> head) {
		if (head == null)
			return;

		Node<Integer> current = head;
		while (current != null) {
			Node<Integer> runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}

			current = current.next;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> node1 = new Node<Integer>(2);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		Node<Integer> head = node1;
		while (node1 != null) {
			System.out.print(node1.data + " ");
			node1 = node1.next;
		}

		System.out.println("\r\nDelete dups");
		delete(head);

		node1 = head;
		while (node1 != null) {
			System.out.print(node1.data + " ");
			node1 = node1.next;
		}
	}

}
