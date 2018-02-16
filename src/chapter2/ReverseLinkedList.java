package chapter2;

import java.util.LinkedList;
import java.util.List;

class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}

/**
 * Chapter2 Problem5 反转打印链表
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		ListNode head = makeList(arr);

		// 不允许修改原链表结构
		reversePrint1(head);

		// 允许修改原链表结构
		reversePrint2(head);
	}

	public static ListNode makeList(int[] arr) {
		ListNode head = new ListNode(-1);
		ListNode cur = head;
		for(int num : arr) {
			cur.next = new ListNode(num);
			cur = cur.next;
		}
		return head.next;
	}

	/**
	 * 不允许修改原链表结构, 利用头插入(add to head)实现反转打印
	 * @param head 链表头
	 */
	public static void reversePrint1(ListNode head) {
		List<Integer> result = new LinkedList<>();
		while(head != null) {
			result.add(0, head.val);
			head = head.next;
		}

		for(int num : result) {
			System.out.println(num);
		}
	}

	/**
	 * 允许修改原链表结构, 先实现reverse再打印
	 * @param head 链表头
	 */
	public static void reversePrint2(ListNode head) {
		ListNode newHead = reverse(head);
		while(newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}

	/**
	 * 反转链表
	 * @param head 链表头
	 * @return 反转后的链表头
	 */
	public static ListNode reverse(ListNode head) {
		ListNode newHead = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
}
