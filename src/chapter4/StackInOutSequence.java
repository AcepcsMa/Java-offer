package chapter4;

import java.util.Stack;

/**
 * Chapter4 Problem22 栈的压入弹出序列
 */
public class StackInOutSequence {

	public static void main(String[] args) {
		int[] pushSequence = {1, 2, 3, 4, 5};
		int[] rightPopSequence = {4, 5, 3, 2, 1};
		int[] wrongPopSequence = {4, 3, 5, 1, 2};

		System.out.println(isValidPopSequence(pushSequence, rightPopSequence));
		System.out.println(isValidPopSequence(pushSequence, wrongPopSequence));
	}

	public static boolean isValidPopSequence(int[] pushSequence, int[] popSequence) {
		if(pushSequence == null || popSequence == null || pushSequence.length != popSequence.length) {
			return false;
		}

		int seqLen = popSequence.length;
		int pushIndex = 0;
		int popIndex = 0;
		Stack<Integer> stack = new Stack<>();
		while(popIndex < seqLen) {

			// 还未遇到需要pop的元素前, 就一直往辅佐栈里push
			while(pushIndex < seqLen && (stack.isEmpty() || stack.peek() != popSequence[popIndex])) {
				stack.push(pushSequence[pushIndex]);
				pushIndex++;
			}

			// 如果遇到了需要pop的元素, 就将其pop出
			if(stack.peek() == popSequence[popIndex]) {
				stack.pop();
				popIndex++;
			} else {
				// 如果栈顶元素不是当前需要pop的元素, 说明出栈序列不对
				return false;
			}
		}

		// 如果循环里pop序列中所有元素都成功pop出, 没有发生意外则返回true
		return true;
	}
}
