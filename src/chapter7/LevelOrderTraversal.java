package chapter7;

import java.util.*;

/**
 * 按层打印二叉树 (层次遍历)
 */
public class LevelOrderTraversal {

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

		List<List<Integer>> result = levelOrderTraversal(node1);
		for(List<Integer> level : result) {
			System.out.println(Arrays.toString(level.toArray(new Integer[0])));
		}
	}

	public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int curLevelSize = queue.size();
			List<Integer> curLevel = new ArrayList<>();
			for(int i = 0;i < curLevelSize;i++) {
				TreeNode cur = queue.poll();
				curLevel.add(cur.val);
				if(cur.left != null) {
					queue.add(cur.left);
				}
				if(cur.right != null) {
					queue.add(cur.right);
				}
			}
			result.add(curLevel);
		}
		return result;
	}
}
