package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Chapter6 Problem41 和为s的两个数字
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {1, 2, 4, 7, 11, 15};
		System.out.println(Arrays.toString(twoSum(nums, 15)));

		List<List<Integer>> result = continuousSequence(15);
		for(List<Integer> temp : result) {
			System.out.println(Arrays.toString(temp.toArray(new Integer[0])));
		}
	}

	/**
	 * 和为s的两个数字
	 * @param nums 输入数组
	 * @param target 目标数
	 * @return 目标数字
	 */
	public static int[] twoSum(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return null;
		}

		int head = 0;
		int tail = nums.length - 1;
		while(head < tail) {
			if(nums[head] + nums[tail] == target) {
				return new int[]{nums[head], nums[tail]};
			} else if(nums[head] + nums[tail] < target) {
				head++;
			} else {
				tail--;
			}
		}
		return null;
	}

	/**
	 * 和为s的连续序列
	 * @param target 目标数
	 * @return 所有和为s的连续序列
	 */
	public static List<List<Integer>> continuousSequence(int target) {
		List<List<Integer>> result = new ArrayList<>();

		int head = 1;
		int tail = 2;
		int middle = (1 + target) / 2;
		int curSum = head + tail;
		while(head < middle) {
			if(curSum == target) {
				result.add(range(head, tail));
				curSum -= head;
				head++;
			} else if(curSum < target) {
				tail++;
				curSum += tail;
			} else {
				curSum -= head;
				head++;
			}
		}
		return result;
	}

	public static List<Integer> range(int start, int end) {
		List<Integer> result = new ArrayList<>(end + 1 - start);
		for(int i = start;i <= end;i++) {
			result.add(i);
		}
		return result;
	}
}
