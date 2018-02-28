package chapter6;

import java.util.Arrays;

/**
 * Chapter6 Problem40 找到数组中两个只出现了1次的数
 */
public class FindTwoSingleNumber {

	public static void main(String[] args) {
		int[] nums = {2, 4, 3, 6, 3, 2, 5, 5};
		System.out.println(Arrays.toString(findTwoSingleNumber(nums)));
	}

	/**
	 * 找到数组中两个只出现了1次的数
	 * @param nums 输入数组
	 * @return 2个只出现了1次的数
	 */
	public static int[] findTwoSingleNumber(int[] nums) {
		if(nums == null || nums.length == 0) {
			return null;
		}

		int mask = 0;
		for(int num : nums) {
			mask ^= num;
		}

		// 找到右边第一个1
		int indexOfLastOne = 0;
		while((mask & 1) == 0) {
			indexOfLastOne++;
			mask >>= 1;
		}

		int first = 0;
		int second = 0;
		for(int num : nums) {
			// 将数组里的数分成两类
			if(((num >> indexOfLastOne) & 1) == 1) {
				first ^= num;
			} else {
				second ^= num;
			}
		}
		return new int[]{first, second};
	}
}
