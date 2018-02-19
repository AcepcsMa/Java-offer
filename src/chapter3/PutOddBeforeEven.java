package chapter3;

import java.util.Arrays;

/**
 * Chapter3 Problem14 将数组中的所有奇数放置在所有偶数前
 */
public class PutOddBeforeEven {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		putOddBeforeEven(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void putOddBeforeEven(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return;
		}

		int head = 0;
		int tail = arr.length - 1;
		while(head < tail) {
			while(head < tail && arr[head] % 2 != 0) {
				head++;
			}
			while(head < tail && arr[tail] % 2 == 0) {
				tail--;
			}
			swap(arr, head, tail);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
