package chapter5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Chapter5 Problem33 把数组排成最小的数
 */
public class SmallestNumber {

	public static void main(String[] args) {
		int[] nums = {3, 32, 321};
		System.out.println(smallestNumber(nums));
	}

	public static String smallestNumber(int[] nums) {
		if(nums == null || nums.length == 0) {
			return "";
		}

		String[] strs = new String[nums.length];
		for(int i = 0;i < nums.length;i++) {
			strs[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1 + o2).compareTo(o2 + o1);
			}
		});

		if(strs[0].charAt(0) == '0') {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		for(String num : strs) {
			sb.append(num);
		}
		return sb.toString();
	}
}
