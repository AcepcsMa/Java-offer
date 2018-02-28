package chapter6;

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}

/**
 * Chapter6 Problem39 二叉树的深度
 */
public class DepthOfBT {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		root.left = node2;
		root.right = node3;
		node2.left = node4;

		System.out.println(depth(root));
	}

	/**
	 * 递归求二叉树的深度
	 * @param root 根节点
	 * @return 树深
	 */
	public static int depth(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int left = depth(root.left);
		int right = depth(root.right);
		return 1 + Math.max(left, right);
	}
}
