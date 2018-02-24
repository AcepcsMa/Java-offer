package chapter4;

class ComplexListNode {
	public int val;
	public ComplexListNode sibling;
	public ComplexListNode next;

	public ComplexListNode(int val) {
		this.val = val;
	}
}

/**
 * Chapter4 Problem26 克隆复杂链表
 */
public class CopyComplexLinkedList {

	public static void main(String[] args) {
		ComplexListNode head = new ComplexListNode(1);
		ComplexListNode node2 = new ComplexListNode(2);
		ComplexListNode node3 = new ComplexListNode(3);
		ComplexListNode node4 = new ComplexListNode(4);
		ComplexListNode node5 = new ComplexListNode(5);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		head.sibling = node3;
		node2.sibling = node5;
		node4.sibling = node2;

		ComplexListNode copy = cloneComplextLinkedList(head);
		printList(copy);
	}

	public static ComplexListNode cloneComplextLinkedList(ComplexListNode head) {
		cloneAndConnect(head);
		return reconstruct(head);
	}

	/**
	 * 克隆节点, 并链接sibling
	 * @param head
	 */
	public static void cloneAndConnect(ComplexListNode head) {
		ComplexListNode cur = head;
		while(cur != null) {
			ComplexListNode next = cur.next;
			ComplexListNode newNode = new ComplexListNode(cur.val);
			cur.next = newNode;
			newNode.next = next;
			cur = next;
		}

		cur = head;
		while(cur != null) {
			ComplexListNode newNode = cur.next;
			if(cur.sibling != null) {
				newNode.sibling = cur.sibling.next;
			}
			cur = newNode.next;
		}
	}

	/**
	 * 将克隆后的大链表拆分为原链表和克隆链表
	 * @param head 克隆后的大链表 (中间结果)
	 * @return 克隆链表
	 */
	public static ComplexListNode reconstruct(ComplexListNode head) {
		ComplexListNode newHead = new ComplexListNode(-1);
		ComplexListNode cur = newHead;

		while(head != null) {
			ComplexListNode newNode = head.next;
			head.next = newNode.next;
			cur.next = newNode;
			cur = cur.next;
			head = head.next;
		}
		return newHead.next;
	}

	public static void printList(ComplexListNode head) {
		while(head != null) {
			System.out.println(head.val);
			if(head.sibling != null) {
				System.out.println(String.format("%d's sibling is %d", head.val, head.sibling.val));
			}
			head = head.next;
		}
	}
}
