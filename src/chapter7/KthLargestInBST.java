package chapter7;

import java.util.Stack;

/**
 * 二叉搜索树中第k大的节点
 */
public class KthLargestInBST {

	public static void main(String[] args) {
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		node5.left = node3;
		node5.right = node6;
		node3.right = node4;

		System.out.println(kthLargestInBST(node5, 1).val);
	}

	/**
	 * BST中第k大的节点
	 * @param root 根节点
	 * @param k k
	 * @return 第k大的节点
	 */
	public static TreeNode kthLargestInBST(TreeNode root, int k) {
		if(root == null) {
			return null;
		}

		// 反过来的中序遍历
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(!stack.isEmpty() || cur != null) {
			while(cur != null) {
				stack.push(cur);
				cur = cur.right;
			}
			cur = stack.pop();
			if(--k == 0) {
				return cur;
			}
			cur = cur.left;
		}
		return null;
	}
}
