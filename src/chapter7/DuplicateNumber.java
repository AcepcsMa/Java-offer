package chapter7;

/**
 * Chapter7 Problem51 找出任意一个重复的数字
 */
public class DuplicateNumber {

	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 0, 2, 5, 3};
		System.out.println(findDuplicateNumber(nums));
	}

	/**
	 * 假定i应该被放置在nums[i]处, 遇到i == nums[i]时说明有重复
	 * @param nums 输入数组
	 * @return
	 */
	public static int findDuplicateNumber(int[] nums) {
		if(nums == null || nums.length == 0) {
			return -1;
		}

		for(int i = 0;i < nums.length;i++) {
			int cur = nums[i];
			if(cur < 0 || cur >= nums.length) {
				return -1;
			}
			if(i != cur && cur == nums[cur]) {
				return cur;
			} else {
				swap(nums, i, cur);
			}
		}
		return -1;
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
