package chapter2;

/**
 * Chapter2 Problem8 旋转数组中的最小数
 */
public class MinElemInRotatedArr {

	public static void main(String[] args) {
		int[] arr = {2,3,4,1,1};
		System.out.println(findMin(arr));
	}

	public static int findMin(int[] arr) {
		int lower = 0;
		int upper = arr.length - 1;
		int mid = -1;

		while (lower <= upper) {
			mid = lower + (upper - lower) / 2;
			if (arr[mid] > arr[upper]) {
				lower = mid + 1;
			} else if (arr[mid] < arr[upper]) {
				upper = mid;
			} else {
				// 如果arr[mid] == arr[upper], 无法确定取左边区间or右边区间
				upper--;
			}
		}
		return arr[lower];
	}
}
