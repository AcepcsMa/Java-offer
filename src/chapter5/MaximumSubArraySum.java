package chapter5;

/**
 * Chapter5 Problem31 连续子数组的最大和
 */
public class MaximumSubArraySum {

	public static void main(String[] args) {
		int[] nums = {1, -2, 3, 10, -4, 7, 2, -5};
		System.out.println(maximumSubArraySum(nums));
	}

	/**
	 * 连续子数组的最大和
	 * @param nums 原始数组
	 * @return 最大和
	 */
	public static int maximumSubArraySum(int[] nums) {
		int sum = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0;i < nums.length;i++) {
			if(sum + nums[i] > nums[i]) {
				sum += nums[i];
			} else {
				sum = nums[i];
			}
			max = Math.max(max, sum);
		}
		return max;
	}
}
