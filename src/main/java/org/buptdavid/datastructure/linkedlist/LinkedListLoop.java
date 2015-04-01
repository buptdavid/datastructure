package org.buptdavid.datastructure.linkedlist;

import org.buptdavid.datastructure.Node;

/**
 * 1. 判断一个链表是否存在环儿<br>
 * 2. 如果有环儿计算环儿的长度<br>
 * 3. 找出环儿的连接点<br>
 * @author weijielu
 * @see LinkedListLoopTest
 */
public class LinkedListLoop {
	
	/**
	 * 判断一个链表是否存在环儿
	 * @param header
	 * @return 是否存在环儿
	 */
	public static boolean isExistLoop(Node header){
		// 定义两个指针fast和slow,fast移动步长为2，slow移动步长为1
		Node fast = header;
		Node slow = header;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			
			//如果相遇则存在环儿，跳出
			if(fast == slow){
				break;
			}
		}
		
		// 根据跳出循环的条件return
		if(fast == null || fast.next == null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 计算有环儿链表的环儿长度<br>
	 * fast, slow从碰撞点出发再次碰撞就是环儿的长度
	 * @param header
	 * @return 返回环儿的长度
	 */
	public static int loopLength(Node header){
		// 如果不存在环儿，返回0
		if(!isExistLoop(header)){
			return 0;
		}
		
		Node fast = header;
		Node slow = header;
		int length = 0;
		boolean begin = false;
		boolean again = false;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			
			// 超过两圈后停止计数，跳出循环
			if(fast == slow && again == true){
				break;
			}
			
			// 超过一圈后开始计数
			if(fast == slow && again == false){
				begin = true;
				again = true;
			}
			
			if(begin == true){
				++length;
			}
		}
		
		return length;
	}
	
	/**
	 * 找出环儿的连接点<br>
	 * 碰撞点到连接点的距离=头指针到连接点的距离<br>
	 * 因此，分别从碰撞点、头指针开始走，相遇的那个点就是连接点<br>
	 * @param header
	 * @return 环儿连接点
	 */
	public static Node findLoopEntrance(Node header){
		Node fast = header;
		Node slow = header;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				break;
			}
		}
		
		if(fast == null || fast.next == null){
			return null;
		}
		
		slow = header;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}

}
