package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Chapter4 Problem25 二叉树中和为某一值的路径
 */
public class PathSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode node5 = new TreeNode(5);
		TreeNode node12 = new TreeNode(12);
		TreeNode node4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		root.left = node5;
		root.right = node12;
		node5.left = node4;
		node5.right = node7;

		List<List<Integer>> result = pathSum(root, 22);
		for(List<Integer> path : result) {
			System.out.println(Arrays.toString(path.toArray(new Integer[0])));
		}
	}

	public static List<List<Integer>> pathSum(TreeNode root, int target) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(result, new ArrayList<>(), root, target);
		return result;
	}

	/**
	 * DFS找"全部解"
	 * @param result 结果列表
	 * @param path 当前路径
	 * @param cur 当前访问节点
	 * @param sum 当前路径余值
	 */
	public static void dfs(List<List<Integer>> result, List<Integer> path, TreeNode cur, int sum) {
		if(cur == null) {
			return;
		}

		sum -= cur.val;
		path.add(cur.val);
		if(cur.left == null && cur.right == null && sum == 0) {
			// 当到达叶子节点且剩余值为0时, 将当前路径加入结果
			result.add(new ArrayList<>(path));
		}

		// DFS分别进入左子树和右子树
		dfs(result, path, cur.left, sum);
		dfs(result, path, cur.right, sum);

		// 回溯时删除当前访问节点记录
		path.remove(path.size() - 1);
	}
}
