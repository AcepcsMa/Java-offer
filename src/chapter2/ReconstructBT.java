package chapter2;

import java.util.*;

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

/**
 * Chapter2 Problem6 利用中序结果&先序结果重构二叉树
 */
public class ReconstructBT {

	public static void main(String[] args) {

		int[] arr = {1, 2, 3, 4, 5};
		TreeNode root = makeTree(arr);

		List<Integer> inOrder = new ArrayList<>();
		inOrder(root, inOrder);
		Integer[] inOrderResult = inOrder.toArray(new Integer[0]);
		System.out.println("In-Order:" + Arrays.toString(inOrderResult));

		List<Integer> preOrder = new ArrayList<>();
		preOrder(root, preOrder);
		Integer[] preOrderResult = preOrder.toArray(new Integer[0]);
		System.out.println("Pre-Order:" + Arrays.toString(preOrderResult));

		TreeNode newRoot = reconstruct(inOrderResult, preOrderResult);
		displayTree(newRoot);

	}

	/**
	 * Reconstruct的接口
	 * @param inOrder 中序序列
	 * @param preOrder 先序序列
	 * @return 根节点
	 */
	public static TreeNode reconstruct(Integer[] inOrder, Integer[] preOrder) {
		return construct(inOrder, preOrder,
				  0, inOrder.length-1,
				 0, preOrder.length-1);
	}

	/**
	 * 真正执行reconstruct的方法
	 * @param inOrder 中序序列
	 * @param preOrder 先序序列
	 * @param inStart 中序序列起始index
	 * @param inEnd 中序序列结束index
	 * @param preStart 先序序列起始index
	 * @param preEnd 先序序列结束index
	 * @return 根节点
	 */
	public static TreeNode construct(Integer[] inOrder, Integer[] preOrder,
									 int inStart, int inEnd,
									 int preStart, int preEnd) {
		if (inStart > inEnd || preStart > preEnd) {
			return null;
		}

		int curVal = preOrder[preStart];
		TreeNode curNode = new TreeNode(curVal);

		int index = inStart;
		while (inOrder[index] != curVal && index <= inEnd) {
			index++;
		}

		if (index <= inEnd) {
			int leftCount = index - inStart;
			int rightCount = inEnd - index;

			curNode.left = construct(inOrder, preOrder, inStart, index-1, preStart+1, preStart+leftCount);
			curNode.right = construct(inOrder, preOrder, index+1, inEnd, preStart+leftCount+1, preEnd);
			return curNode;
		}
		return null;
	}

	public static TreeNode makeTree(int[] arr) {
		TreeNode node1 = new TreeNode(arr[0]);
		TreeNode node2 = new TreeNode(arr[1]);
		TreeNode node3 = new TreeNode(arr[2]);
		TreeNode node4 = new TreeNode(arr[3]);
		TreeNode node5 = new TreeNode(arr[4]);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		return node1;
	}

	public static void inOrder(TreeNode root, List<Integer> result) {
		if (root != null) {
			inOrder(root.left, result);
			result.add(root.val);
			inOrder(root.right, result);
		}
	}

	public static void preOrder(TreeNode root, List<Integer> result) {
		if (root != null) {
			result.add(root.val);
			preOrder(root.left, result);
			preOrder(root.right, result);
		}
	}

	/**
	 * 层次遍历打印树
	 * @param root 根节点
	 */
	public static void displayTree(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> curLevel = new ArrayList<>();
			for (int i = 0;i < size;i++) {
				TreeNode cur = queue.poll();
				curLevel.add(cur.val);
				if (cur.left != null) {
					queue.add(cur.left);
				}
				if (cur.right != null) {
					queue.add(cur.right);
				}
			}
			result.add(curLevel);
		}

		for(List<Integer> level : result) {
			System.out.println(Arrays.toString(level.toArray(new Integer[0])));
		}
	}
}
