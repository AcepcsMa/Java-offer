package chapter7;

import java.util.Arrays;

/**
 * Chapter7 Problem52 构建乘积数组
 */
public class ProductArray {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		int[] result = buildProductArray(nums);
		System.out.println(Arrays.toString(result));
	}

	/**
	 * 构建乘积数组
	 * @param nums 输入数组
	 * @return 乘积数组
	 */
	public static int[] buildProductArray(int[] nums) {
		if(nums == null || nums.length == 0) {
			return null;
		}

		int[] result = new int[nums.length];

		// 从result[0]开始斜着乘上去
		int temp = 1;
		for(int i = 0;i < result.length;i++) {
			result[i] = temp;
			temp *= nums[i];
		}

		// 从result[n-1]开始斜着乘下来
		temp = 1;
		for(int i = result.length - 1;i >= 0;i--) {
			result[i] *= temp;
			temp *= nums[i];
		}
		return result;
	}
}
