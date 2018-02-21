package chapter4;

import java.util.Stack;

/**
 * Chapter4 Problem21 最小栈的实现
 */
public class MinStack {

	// 维护两个栈, s1为正常栈, s2为存储最小数的栈
	private Stack<Integer> s1;
	private Stack<Integer> s2;

	public MinStack() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	public int min() {
		return s2.peek();
	}

	public void push(int val) {
		s1.push(val);
		if(s2.isEmpty() || s2.peek() >= val) {
			// s2的栈顶元素为已插入序列中的最小值
			s2.push(val);
		}
	}

	public int pop() {
		int val = s1.pop();
		if(val == s2.peek()) {
			s2.pop();
		}
		return val;
	}

	public boolean isEmpty() {
		return s1.isEmpty() && s2.isEmpty();
	}

	public static void main(String[] args) {
		int[] arr = {7,3,1,8,5,4,2};
		MinStack stack = new MinStack();
		for(int num : arr) {
			stack.push(num);
		}

		System.out.println(stack.min());
	}
}
