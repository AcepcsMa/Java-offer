package chapter5;

import java.util.Arrays;

/**
 * Chapter5 Problem29 数组中出现次数超过一半的数字
 */
public class ModeNumber {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};

		// Moore's vote
		System.out.println(findMode(nums));

		// quick select
		System.out.println(quickSelect(nums, 0, nums.length-1, nums.length/2));
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * 摩尔投票法, 选出出现次数过半的数
	 * @param nums 原始数组
	 * @return 目标数
	 */
	public static int findMode(int[] nums) {
		int result = nums[0];
		int count = 0;
		for(int num : nums) {
			if(result == num) {
				count++;
			} else {
				if(count == 0) {
					result = num;
					count++;
				} else {
					count--;
				}
			}
		}
		return result;
	}

	/**
	 * quick select算法, 借鉴了快排中寻找pivot(一次排序)的思想
	 * @param nums 原始数组
	 * @param lower 起始index
	 * @param upper 结束index
	 * @param k kth
	 * @return 目标数
	 */
	public static int quickSelect(int[] nums, int lower, int upper, int k) {
		if(lower > upper) {
			return -1;
		}

		int i = lower;
		int j = upper;
		int key = nums[upper];
		while(i < j) {
			if(nums[i++] > key) {
				swap(nums, --i, --j);
			}
		}
		swap(nums, i, upper);

		int len = i + 1 - lower;
		if(len == k) {
			return nums[i];
		} else if(len > k) {
			// 去前面找
			return quickSelect(nums, lower, i-1, k);
		} else {
			// 去后面找
			return quickSelect(nums, i+1, upper, k-len);
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
