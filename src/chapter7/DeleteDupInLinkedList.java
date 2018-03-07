package chapter7;

/**
 * 删除链表中重复的节点
 */
public class DeleteDupInLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node33 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node44 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		head.next = node2;
		node2.next = node3;
		node3.next = node33;
		node33.next = node4;
		node4.next = node44;
		node44.next = node5;

		ListNode newHead = deleteDupInLinkedList(head);
		while(newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}

	/**
	 * 删除链表中重复的节点
	 * @param head 链表头
	 * @return 新链表头
	 */
	public static ListNode deleteDupInLinkedList(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = head;

		while(cur != null) {
			while(cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
			}

			if(prev.next == cur) {
				prev = prev.next;
			} else {
				prev.next = cur.next;
			}
			cur = cur.next;
		}

		return dummy.next;
	}
}
