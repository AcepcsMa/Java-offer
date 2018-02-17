package chapter2;

import java.util.Arrays;

/**
 * Chapter2 Problem9.2 - Problem9.3 跳台阶
 */
public class JumpStairs {

	public static void main(String[] args) {
		int n = 10;

		// 普通版跳台阶
		System.out.println(jumpStairs1(n));

		// 进阶版跳台阶
		System.out.println(jumpStairs2(4));
	}

	/**
	 * 跳台阶, 每次可跳1级或2级
	 * @param n 台阶数
	 * @return 方案数
	 */
	public static int jumpStairs1(int n) {
		if (n <= 0) {
			throw new RuntimeException("N should be positive!");
		}

		int[] count = new int[n+1];
		count[1] = 1;
		count[2] = 2;
		for (int i = 3;i <= n;i++) {
			count[i] = count[i-1] + count[i-2];
		}
		return count[n];
	}

	/**
	 * 进阶版跳台阶, 每次可跳1-n级
	 * @param n 阶级数
	 * @return 方案数
	 */
	public static int jumpStairs2(int n) {
		if (n <= 0) {
			throw new RuntimeException("N should be positive!");
		}

		int[] count = new int[n+1];
		Arrays.fill(count, 1);
		for (int i = 1;i <= n;i++) {
			for (int j = 1;j < i;j++) {
				count[i] += count[j];
			}
		}
		return count[n];
	}
}
