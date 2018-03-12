package chapter7;

import java.util.*;

/**
 * 滑动窗口的最大值
 */
public class MaxInSlidingWindow {

	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		List<Integer> result = maxInSlidingWindow(nums, 3);
		System.out.println(Arrays.toString(result.toArray(new Integer[0])));
	}

	/**
	 * 寻找各个滑动窗口的最大值
	 * @param nums 输入数组
	 * @param k 窗口大小
	 * @return 最大值列表
	 */
	public static List<Integer> maxInSlidingWindow(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
		if(nums == null || nums.length == 0 || k <= 0) {
			return result;
		}

		Deque<Integer> queue = new LinkedList<>();
		for(int i = 0;i < nums.length;i++) {
			if(i - k >= 0 && queue.peekFirst() == i - k) {
				queue.removeFirst();
			}

			while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
				queue.removeLast();
			}

			queue.addLast(i);
			if(i + 1 - k >= 0) {
				result.add(nums[queue.peekFirst()]);
			}
		}
		return result;
	}
}
