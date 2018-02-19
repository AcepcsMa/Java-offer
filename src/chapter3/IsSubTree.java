package chapter3;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}

/**
 * Chapter3 Problem18 判断一棵树是否为另一棵树的子树
 */
public class IsSubTree {

	public static void main(String[] args) {
		TreeNode rootA1 = new TreeNode(1);
		TreeNode rootA2 = new TreeNode(2);
		TreeNode rootA3 = new TreeNode(3);
		TreeNode rootA4 = new TreeNode(4);
		rootA1.left = rootA2;
		rootA1.right = rootA3;
		rootA2.left = rootA4;

		TreeNode rootB2 = new TreeNode(2);
		TreeNode rootB4 = new TreeNode(4);
		rootB2.left = rootB4;

		System.out.println(isSubTree(rootA1, rootB2));

	}

	/**
	 * 判断root2是否为root1的子树
	 * @param root1 树1
	 * @param root2 树2
	 * @return true/false
	 */
	public static boolean isSubTree(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 == null || root2 == null) {
			return false;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root1);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if(cur.val == root2.val && isSameTree(cur, root2)) {
				// 遇到根节点val相同, 且isSameTree的即返回true
				return true;
			}
			if(cur.left != null) {
				queue.add(cur.left);
			}
			if(cur.right != null) {
				queue.add(cur.right);
			}
		}
		return false;
	}

	/**
	 * 判断2棵树是否相同
	 * @param root1 树1
	 * @param root2 树2
	 * @return true/false
	 */
	public static boolean isSameTree(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 == null || root2 == null) {
			return false;
		}
		if(root1.val == root2.val) {
			return isSameTree(root1.left, root2.left) && isSameTree(root2.right, root2.right);
		}
		return false;
	}

}
