package chapter7;

class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}

/**
 * Chapter7 Problem56 链表中环的入口
 */
public class LinkedCycleEntry {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;

		System.out.println(findEntry(head).val);
	}

	/**
	 * 有环链表中的环入口
	 * @param head 链表头
	 * @return 环入口
	 */
	public static ListNode findEntry(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast) {
				fast = head;
				while(slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}
}
