package chapter3;

/**
 * Chapter3 Problem12 打印从1开始到最大的n位的数字
 */
public class PrintOneToN {

	public static void main(String[] args) {
		printOneToNthDigits(8);
	}

	public static void printOneToNthDigits(int n) {
		int[] num = new int[n];
		while(addOne(num) == 0) {
			printArray(num);
		}
	}

	public static int addOne(int[] arr) {

		int carry = 1;
		int index = arr.length - 1;
		while(carry > 0 && index >= 0) {
			arr[index] += carry;
			carry = arr[index] / 10;
			arr[index] %= 10;
			index--;
		}
		return carry;
	}

	public static void printArray(int[] arr) {
		int i = 0;
		while(arr[i] == 0) {
			i++;
		}

		while(i < arr.length) {
			System.out.print(arr[i]);
			i++;
		}
		System.out.println();
	}
}
