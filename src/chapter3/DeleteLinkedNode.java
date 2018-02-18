package chapter3;

class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}

/**
 * Chapter3 Problem13 O(1)时间删除链表节点
 */
public class DeleteLinkedNode {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		ListNode head = makeList(arr);
		delete(head);
		printList(head);
	}

	public static void delete(ListNode node) {
		if(node == null) {
			return;
		}
		node.val = node.next.val;
		node.next = node.next.next;
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
