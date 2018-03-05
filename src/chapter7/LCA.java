package chapter7;

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}

/**
 * Chapter7 Problem50 二叉树中两节点的公共祖先
 */
public class LCA {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		root.left = node2;
		root.right = node3;
		node3.left = node4;

		System.out.println(LCA2(root, node2, node4).val);

		TreeNode node10 = new TreeNode(10);
		TreeNode node5 = new TreeNode(5);
		TreeNode node12 = new TreeNode(12);
		TreeNode node14 = new TreeNode(14);
		node10.left = node5;
		node10.right = node12;
		node12.right = node14;

		System.out.println(LCA1(node10, node5, node14).val);
	}

	/**
	 * 假如树为二叉搜索树, 可利用其性质
	 * @param root 根节点
	 * @param p p
	 * @param q q
	 * @return LCA of p & q
	 */
	public static TreeNode LCA1(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == null || q == null) {
			return null;
		}

		if(root.val > p.val && root.val > q.val) {
			return LCA1(root.left, p, q);
		}
		if(root.val < p.val && root.val < q.val) {
			return LCA1(root.right, p, q);
		}
		return root;
	}

	/**
	 * 普通二叉树
	 * @param root 根节点
	 * @param p p
	 * @param q q
	 * @return LCA of p & q
	 */
	public static TreeNode LCA2(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) {
			return root;
		}

		TreeNode left = LCA2(root.left, p, q);
		TreeNode right = LCA2(root.right, p, q);
		if(left == null && right == null) {
			return null;
		}
		if(left == null) {
			return right;
		}
		if(right == null) {
			return left;
		}
		return root;
	}
}
