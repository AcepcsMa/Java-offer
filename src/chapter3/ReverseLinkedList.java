package chapter3;

/**
 * Chapter3 Problem16 反转单链表
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		ListNode head = makeList(arr);
		ListNode newHead = reverseLinkedList(head);
		printList(newHead);
	}

	public static ListNode reverseLinkedList(ListNode head) {
		ListNode newHead = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
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

	public static void printList(ListNode head) {
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
