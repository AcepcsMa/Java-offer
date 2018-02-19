package chapter3;

/**
 * Chapter3 Problem15 求链表中倒数第k个节点
 */
public class KthNodeToTail {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		ListNode head = makeList(arr);
		ListNode kthNode = findKthNodeToTail(head, 3);
		System.out.println(kthNode.val);
	}

	public static ListNode findKthNodeToTail(ListNode head, int k) {
		if(head == null || k < 1) {
			return null;
		}

		ListNode fast = head;
		for(int i = 0;i < k;i++) {
			if(fast != null) {
				fast = fast.next;
			} else {
				return null;
			}
		}

		ListNode slow = head;
		while(fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
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
}
