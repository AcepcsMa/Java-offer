package chapter4;


import java.util.Stack;

/**
 * Chapter4 Problem27 二叉搜索树转化为双向链表
 */
public class ConvertBSTToLinkedList {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		root.left = node1;
		root.right = node3;

		TreeNode head = convert(root);
		print(head);

	}

	/**
	 * 利用中序遍历, 将BST转化为双向链表
	 * @param root
	 * @return
	 */
	public static TreeNode convert(TreeNode root) {

		// go far left, 最小的节点为新链表的头
		TreeNode head = root;
		while(head.left != null) {
			head = head.left;
		}

		TreeNode prev = null;
		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<>();
		while(cur != null || !stack.isEmpty()) {
			while(cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

			cur = stack.pop();
			cur.left = prev;
			if(prev != null) {
				prev.right = cur;
			}
			prev = cur;
			cur = cur.right;
		}
		return head;
	}

	public static void print(TreeNode head) {
		while(head != null) {
			System.out.println(head.val);
			if(head.left != null) {
				System.out.println(String.format("%d's left is %d", head.val, head.left.val));
			} else {
				System.out.println(String.format("%d's left is null", head.val));
			}
			head = head.right;
		}
	}
}
