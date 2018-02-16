package chapter2;

import java.util.Stack;

/**
 * 用两个栈实现的队列
 */
class MyQueue {
	private Stack<Integer> s1;
	private Stack<Integer> s2;

	public MyQueue() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	public boolean isEmpty() {
		return s1.isEmpty() && s2.isEmpty();
	}

	public void add(int val) {
		s1.push(val);
	}

	public int poll() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
}

/**
 * Chapter2 Problem7 用两个栈实现队列
 */
public class TwoStack {

	public static void main(String[] args) {

		int[] arr = {1, 2, 3, 4, 5};
		MyQueue queue = new MyQueue();
		for(int num : arr) {
			queue.add(num);
		}

		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
