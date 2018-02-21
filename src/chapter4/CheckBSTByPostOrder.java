package chapter4;

/**
 * Chapter4 Problem24 通过后序遍历结果判断一棵树是否为BST
 */
public class CheckBSTByPostOrder {

	public static void main(String[] args) {
		int[] correctPostOrder = {5, 7, 6, 9, 11, 10, 8};
		int[] wrongPostOrder = {7, 4, 6, 5};
		System.out.print(isBST(correctPostOrder, 0, correctPostOrder.length-1));
		System.out.print(isBST(wrongPostOrder, 0, wrongPostOrder.length-1));
	}

	/**
	 * 根据后序遍历结果判断树是否为BST
	 * @param postOrder 后序遍历结果
	 * @param start 后序遍历结果的起始index
	 * @param end 后序遍历结果的结束index
	 * @return true/false
	 */
	public static boolean isBST(int[] postOrder, int start, int end) {
		// 异常情况
		if(postOrder == null || postOrder.length == 0) {
			return false;
		}

		// 当只有1个元素时, 直接返回true
		if(start == end) {
			return true;
		}

		// 先从头开始找小于root的（左子树）
		int rootVal = postOrder[end];
		int smallerIndex = start;
		while(smallerIndex < end && postOrder[smallerIndex] < rootVal) {
			smallerIndex++;
		}

		// 从左子树后面开始找大于root的（右子树）
		int biggerIndex = smallerIndex;
		while(biggerIndex < end && postOrder[biggerIndex] >= rootVal) {
			biggerIndex++;
		}

		// 序列有问题, 直接返回false
		if(smallerIndex == start || biggerIndex < end) {
			return false;
		}

		// divide & conquer, 再到左右子树分别检查
		return isBST(postOrder, start, smallerIndex-1) && isBST(postOrder, smallerIndex, end-1);
	}
}
