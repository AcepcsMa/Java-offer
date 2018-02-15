package chapter1;

/**
 * Chapter2 Problem3 二维数组中查找目标元素
 * @author Marco Ma
 */
public class SearchInArray {

	public static void main(String[] args) {
		int[][] arr = {	{1, 2, 8, 9},
						{2, 4, 9, 12},
						{4, 7, 10, 13},
						{6, 8, 11, 15} };

		int target = 14;
		System.out.println(search2dArray(arr, target));
	}

	public static boolean search2dArray(int[][] arr, int target) {
		if (arr == null || arr.length == 0 || arr[0].length == 0) {
			return false;
		}

		int row = arr.length;
		int col = arr[0].length;
		int i = row - 1, j = 0;
		while (i >= 0 && j < col) {
			if (arr[i][j] == target) {
				return true;
			} else if (arr[i][j] > target) {
				i--;
			} else {
				j++;
			}
		}
		return false;
	}
}
