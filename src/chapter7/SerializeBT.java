package chapter7;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeBT {

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

		String s = serializeBT(node1);
		TreeNode root = deserializeBT(s);
		inOrder(root);
	}

	/**
	 * 序列化二叉树
	 * @param root 根节点
	 * @return 序列化字符串
	 */
	public static String serializeBT(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		preOrder(root, sb);
		return sb.toString();
	}

	/**
	 * 先序遍历
	 * @param cur 当前节点
	 * @param sb 遍历序列
	 */
	public static void preOrder(TreeNode cur, StringBuilder sb) {
		if(cur == null) {
			sb.append("#").append(",");
		} else {
			sb.append(cur.val).append(",");
			preOrder(cur.left, sb);
			preOrder(cur.right, sb);
		}
	}

	/**
	 * 反序列化二叉树
	 * @param s 序列
	 * @return 二叉树根节点
	 */
	public static TreeNode deserializeBT(String s) {
		String[] nodes = s.split(",");
		Queue<String> queue = new LinkedList<>();
		for(String node : nodes) {
			queue.add(node);
		}
		return construct(queue);
	}

	/**
	 * 利用先序思想构造二叉树
	 * @param queue 序列
	 * @return 当前树节点
	 */
	public static TreeNode construct(Queue<String> queue) {
		if(queue.isEmpty()) {
			return null;
		}
		String cur = queue.poll();
		if(cur.equals("#")) {
			return null;
		} else {
			TreeNode curNode = new TreeNode(Integer.parseInt(cur));
			curNode.left = construct(queue);
			curNode.right = construct(queue);
			return curNode;
		}
	}

	public static void inOrder(TreeNode cur) {
		if(cur != null) {
			inOrder(cur.left);
			System.out.println(cur.val);
			inOrder(cur.right);
		}
	}
}
