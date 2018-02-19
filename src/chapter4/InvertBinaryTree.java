package chapter4;

import java.util.*;

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}

/**
 * Chapter4 Problem19 二叉树镜像（反转二叉树）
 */
public class InvertBinaryTree {

	public static void main(String[] args) {
		TreeNode rootA1 = new TreeNode(1);
		TreeNode rootA2 = new TreeNode(2);
		TreeNode rootA3 = new TreeNode(3);
		TreeNode rootA4 = new TreeNode(4);
		TreeNode rootA5 = new TreeNode(5);
		rootA1.left = rootA2;
		rootA1.right = rootA3;
		rootA2.left = rootA4;
		rootA2.right = rootA5;
		levelOrderTraversal(rootA1);

		// 递归反转
		TreeNode newRoot1 = invertBinaryTree1(rootA1);
		levelOrderTraversal(newRoot1);

		// 非递归反转
		TreeNode newRoot2 = invertBinaryTree2(newRoot1);
		levelOrderTraversal(newRoot2);
	}

	/**
	 * 反转二叉树（递归）
	 * @param root 根节点
	 * @return 反转后的根节点
	 */
	public static TreeNode invertBinaryTree1(TreeNode root) {
		if(root == null) {
			return null;
		}

		TreeNode left = invertBinaryTree1(root.left);
		TreeNode right = invertBinaryTree1(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

	/**
	 * 反转二叉树（非递归）, 层次遍历
	 * @param root 根节点
	 * @return 反转后的根节点
	 */
	public static TreeNode invertBinaryTree2(TreeNode root) {
		if(root == null) {
			return null;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			TreeNode temp = cur.left;
			cur.left = cur.right;
			cur.right = temp;
			if(cur.left != null) {
				queue.add(cur.left);
			}
			if(cur.right != null) {
				queue.add(cur.right);
			}
		}
		return root;
	}

	public static void levelOrderTraversal(TreeNode root) {
		if(root == null) {
			return;
		}
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			for(int i = 0;i < size;i++) {
				TreeNode cur = queue.poll();
				level.add(cur.val);
				if(cur.left != null) {
					queue.add(cur.left);
				}
				if(cur.right != null) {
					queue.add(cur.right);
				}
			}
			result.add(level);
		}

		for(List<Integer> level : result) {
			System.out.println(Arrays.toString(level.toArray(new Integer[0])));
		}
		System.out.println();
	}
}
