package chapter7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 检查二叉树是否镜像对称
 */
public class IsSymmetric {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;

		System.out.println(isSymmetric(node1));
	}

	public static boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(root);

		while(!queue.isEmpty()) {
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			if(left == null && right == null) {
				continue;
			}
			if(left == null || right == null) {
				return false;
			}
			if(left.val != right.val) {
				return false;
			}
			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);
		}
		return true;
	}
}
