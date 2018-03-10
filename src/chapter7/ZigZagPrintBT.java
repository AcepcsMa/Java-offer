package chapter7;

import java.util.*;

/**
 * 之字形打印二叉树
 */
public class ZigZagPrintBT {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;

		List<List<Integer>> result = zigzagPrintBT(node1);
		for(List<Integer> level : result) {
			System.out.println(Arrays.toString(level.toArray(new Integer[0])));
		}
	}

	/**
	 * 之字形打印二叉树 (变种层次遍历)
	 * @param root 根节点
	 * @return 遍历结果
	 */
	public static List<List<Integer>> zigzagPrintBT(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean even = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> curLevel = new LinkedList<>();
			for(int i = 0;i < size;i++) {
				TreeNode cur = queue.poll();
				if(even == true) {
					curLevel.add(cur.val);
				} else {
					curLevel.add(0, cur.val);
				}
				if(cur.left != null) {
					queue.add(cur.left);
				}
				if(cur.right != null) {
					queue.add(cur.right);
				}
			}
			result.add(curLevel);
			even = !even;
		}
		return result;
	}
}
