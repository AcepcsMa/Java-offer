package chapter3;

/**
 * Chapter3 Problem17 合并两个已排序的链表
 */
public class MergeSortedLinkedList {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 6, 8};
		int[] arr2 = {2, 4, 5, 9, 10};
		ListNode l1 = makeList(arr1);
		ListNode l2 = makeList(arr2);
		ListNode head = merge(l1, l2);
		printList(head);
	}

	public static ListNode merge(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode cur = head;

		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}

		while(l1 != null) {
			cur.next = l1;
			l1 = l1.next;
			cur = cur.next;
		}
		while(l2 != null) {
			cur.next = l2;
			l2 = l2.next;
			cur = cur.next;
		}
		return head.next;
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
