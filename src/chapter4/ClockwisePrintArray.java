package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Chapter4 Problem20 顺时针打印二维矩阵
 */
public class ClockwisePrintArray {

	public static void main(String[] args) {
		int[][] arr = {
			{1, 2, 3, 4},
			{5, 6 ,7 ,8},
			{9, 10, 11, 12},
			{13, 14, 15, 16}
		};

		System.out.println(Arrays.toString(clockwisePrintArray(arr).toArray(new Integer[0])));
	}

	/**
	 * 顺时针打印二维矩阵
	 * @param arr 二维矩阵
	 * @return 打印结果列表
	 */
	public static List<Integer> clockwisePrintArray(int[][] arr) {
		List<Integer> result = new ArrayList<>();
		if(arr == null || arr.length == 0) {
			return result;
		}

		int startRow = 0;
		int endRow = arr.length - 1;
		int startCol = 0;
		int endCol = arr[0].length - 1;

		while(startRow <= endRow && startCol <= endCol) {
			for(int i = startCol;i <= endCol;i++) {
				result.add(arr[startRow][i]);
			}
			startRow++;	// 从左到右遍历完首行, 准备往下遍历

			for(int i = startRow;i <= endRow;i++) {
				result.add(arr[i][endCol]);
			}
			endCol--; // 从上到下遍历完末列，准备向左遍历

			if(startRow <= endRow) {
				for(int i = endCol;i >= startCol;i--) {
					result.add(arr[endRow][i]);
				}
			}
			endRow--; // 从右到左遍历完末行，准备向上遍历

			if(startCol <= endCol) {
				for(int i = endRow;i >= startRow;i--) {
					result.add(arr[i][startCol]);
				}
			}
			startCol++; // 遍历完首列, 准备遍历内圈的矩阵
		}
		return result;
	}
}
