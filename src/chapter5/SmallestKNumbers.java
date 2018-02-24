package chapter5;

import java.util.*;

/**
 * Chapter5 Problem30 最小的K个数
 */
public class SmallestKNumbers {

	public static void main(String[] args) {
		// 基于quick select
		int[] nums1 = {4, 5, 1, 6, 2, 7, 3, 8};
		List<Integer> smallestK1 = smallestKNumbers1(nums1, 4);
		System.out.println(Arrays.toString(smallestK1.toArray(new Integer[0])));

		// 基于大顶堆
		int[] nums2 = {4, 5, 1, 6, 2, 7, 3, 8};
		List<Integer> smallestK2 = smallestKNumbers2(nums2, 4);
		System.out.println(Arrays.toString(smallestK2.toArray(new Integer[0])));
	}

	/**
	 * 基于quick select, 会对原数组进行修改
	 * @param nums 原始数组
	 * @param k kth
	 * @return smallest k列表
	 */
	public static List<Integer> smallestKNumbers1(int[] nums, int k) {
		List<Integer> result = new ArrayList<>(k);
		int index = quickSelect(nums, 0, nums.length-1, k);
		for(int i = 0;i <= index;i++) {
			result.add(nums[i]);
		}
		return result;
	}

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
			return i;
		} else if(len > k) {
			return quickSelect(nums, lower, i-1, k);
		} else {
			return quickSelect(nums, i+1, upper, k-len);
		}
	}

	/**
	 * 基于大顶堆
	 * @param nums 原始数组
	 * @param k kth
	 * @return smallest k列表
	 */
	public static List<Integer> smallestKNumbers2(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		for(int i = 0;i < k;i++) {
			pq.offer(nums[i]);
		}

		for(int i = k;i < nums.length;i++) {
			if(nums[i] <= pq.peek()) {
				pq.poll();
				pq.add(nums[i]);
			}
		}
		return new ArrayList<>(pq);
	}


	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
