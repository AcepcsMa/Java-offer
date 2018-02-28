package chapter6;

/**
 * Chapter6 Problem38 数字在排序数组中出现的次数
 */
public class CountOfNumInSortedArr {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 3, 3, 3, 4, 5};
		System.out.println(countOfNum(nums, 3));
	}

	public static int countOfNum(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		// 找到目标数在数组中第一次出现的下标, 最后一次出现的下标, 然后相减得到长度
		int firstIndex = binarySearch(nums, -1, 0, nums.length-1, target, true);
		int lastIndex = binarySearch(nums, -1, 0, nums.length-1, target, false);
		return lastIndex + 1 - firstIndex;
	}

	/**
	 * 改良版binary search
	 * @param nums 输入数组
	 * @param result 目标index
	 * @param lower 起始index
	 * @param upper 结束index
	 * @param target 目标数
	 * @param findFirst 是否查找第一次出现的目标
	 * @return 目标数的index
	 */
	public static int binarySearch(int[] nums, int result, int lower, int upper, int target, boolean findFirst) {
		if(lower > upper) {
			return result;
		}

		int mid = (lower + upper) / 2;
		if(nums[mid] == target) {
			result = mid;
		}

		if(nums[mid] < target || (nums[mid] == target && !findFirst)) {
			return binarySearch(nums, result, mid+1, upper, target, findFirst);
		} else {
			return binarySearch(nums, result, lower, mid-1, target, findFirst);
		}
	}
}
