package chapter4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Chapter4 Problem23 从上到下打印二叉树 (层次遍历）
 */
public class LevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		TreeNode node6 = new TreeNode(6);
		TreeNode node10 = new TreeNode(10);
		TreeNode node5 = new TreeNode(5);
		TreeNode node7 = new TreeNode(7);
		TreeNode node9 = new TreeNode(9);
		TreeNode node11 = new TreeNode(11);
		root.left = node6;
		root.right = node10;
		node6.left = node5;
		node6.right = node7;
		node10.left = node9;
		node10.right = node11;

		levelOrderTraversal(root);
	}

	/**
	 * 层次遍历 (利用queue实现)
	 * @param root 根节点
	 */
	public static void levelOrderTraversal(TreeNode root) {
		if(root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			System.out.print(String.format("%d ", cur.val));
			if(cur.left != null) {
				queue.add(cur.left);
			}
			if(cur.right != null) {
				queue.add(cur.right);
			}
		}
	}
}
