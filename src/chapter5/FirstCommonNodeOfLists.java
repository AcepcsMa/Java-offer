package chapter5;

class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}

/**
 * Chapter5 Problem37 两个链表的第一个公共节点
 */
public class FirstCommonNodeOfLists {

	public static void main(String[] args) {

		/*
		1 -> 3 -> 5 -> null
		2 -> 4 -> 5 -> null
		 */
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode nodeA = new ListNode(3);
		ListNode nodeB = new ListNode(4);
		ListNode nodeC = new ListNode(5);
		head1.next = nodeA;
		head2.next = nodeB;
		nodeA.next = nodeC;
		nodeB.next = nodeC;

		System.out.println(firstCommonNode(head1, head2).val);
	}

	/**
	 * 两链表的第一个公共节点
	 * @param list1 链表1
	 * @param list2 链表2
	 * @return 公共节点
	 */
	public static ListNode firstCommonNode(ListNode list1, ListNode list2) {
		if(list1 == null || list2 == null) {
			return null;
		}

		ListNode iter1 = list1;
		ListNode iter2 = list2;
		while(iter1 != iter2) {
			iter1 = iter1 == null ? list2 : iter1.next;
			iter2 = iter2 == null ? list1 : iter2.next;
		}
		return iter1;
	}
}
