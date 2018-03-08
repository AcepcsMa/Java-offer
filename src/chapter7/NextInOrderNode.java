package chapter7;

class BTNode {
	public int val;
	public BTNode parent;
	public BTNode left;
	public BTNode right;
	public BTNode(int val) {
		this.val = val;
	}
}

/**
 * 二叉树中序遍历的下一个节点
 */
public class NextInOrderNode {

	public static void main(String[] args) {
		BTNode node1 = new BTNode(1);
		BTNode node2 = new BTNode(2);
		BTNode node3 = new BTNode(3);
		BTNode node4 = new BTNode(4);
		BTNode node5 = new BTNode(5);
		node1.left = node2;
		node2.parent = node1;
		node1.right = node3;
		node3.parent = node1;
		node2.left = node4;
		node4.parent = node2;
		node2.right = node5;
		node5.parent = node2;

		System.out.println(nextInOrderNode(node1).val);
	}

	public static BTNode nextInOrderNode(BTNode node) {
		if(node == null) {
			return null;
		}

		if(node.right != null) {
			node = node.right;
			while(node.left != null) {
				node = node.left;
			}
			return node;
		} else {
			if(node == node.parent.left) {
				return node.parent;
			} else {
				while(node.parent != null && node.parent.right == node) {
					node = node.parent;
				}
				return node.parent;
			}
		}
	}
}
