package chapter5;

/**
 * Chapter5 Problem36 数组中的逆序对的个数
 */
public class CountInversePair {

	public static void main(String[] args) {
		int[] nums = {7, 5, 6, 4};
		System.out.println(countInversePair(nums));
//		System.out.println(inversePairs(nums));

	}

	public static int countInversePair(int[] nums) {
		int[] space = new int[nums.length];
		return mergeSort(nums, space, 0, nums.length-1);
	}

	public static int mergeSort(int[] nums, int[] space, int lower, int upper) {
		if(lower >= upper) {
			return 0;
		}

		int mid = (lower + upper) / 2;
		int left = mergeSort(nums, space, lower, mid);
		int right = mergeSort(nums, space, mid+1, upper);
		int merge = merge(nums, space, lower, mid, upper);
		return left + right + merge;
	}

	public static int merge(int[] nums, int[] space, int lower, int mid, int upper) {
		int i = mid;
		int j = upper;
		int index = 0;
		int count = 0;

		while(i >= lower && j >= mid+1) {
			if(nums[i] > nums[j]) {
				space[upper-index++] = nums[i--];
				count += j - mid;
			} else {
				space[upper-index++] = nums[j--];
			}
		}
		while(i >= lower) {
			space[upper-index++] = nums[i--];
		}
		while(j >= mid+1) {
			space[upper-index++] = nums[j--];
		}
		for(int k = 0;k < index;k++) {
			nums[lower+k] = space[lower+k];
		}
		return count;
	}
}
