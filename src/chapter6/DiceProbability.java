package chapter6;

import java.util.HashMap;
import java.util.Map;

/**
 * Chapter6 Problem43 n个骰子的点数
 */
public class DiceProbability {

	public static void main(String[] args) {
		int n = 2;
		int maxNumber = 6;
		Map<Integer, Double> prob = diceProbability(n, maxNumber);
		for(Map.Entry<Integer, Double> entry : prob.entrySet()) {
			int val = entry.getKey();
			double probability = entry.getValue();
			System.out.println(String.format("Val=%d, Prob=%.4f", val, probability));
		}
	}

	/**
	 * 计算n个骰子投出各点数的概率
	 * @param n 骰子数
	 * @param maxNumber 每个骰子最大的点数
	 * @return 点数-概率map
	 */
	public static Map<Integer, Double> diceProbability(int n, int maxNumber) {
		Map<Integer, Double> prob = new HashMap<>();
		int[][] count = new int[2][maxNumber * n + 1];

		int flag = 0;
		for(int i = 1;i <= maxNumber;i++) {
			count[flag][i] = 1;
		}

		for(int i = 2;i <= n;i++) {
			for(int j = 0;j < i;j++) {
				count[1 - flag][j] = 0;
			}

			for(int j = i;j <= maxNumber * n;j++) {
				for(int k = 1;k <= j && k <= maxNumber;k++) {
					count[1 - flag][j] += count[flag][j - k];
				}
			}
			flag = 1 - flag;
		}

		int total = 1;
		for(int i = 0;i < n;i++) {
			total *= maxNumber;
		}

		for(int i = 1;i <= maxNumber * n;i++) {
			prob.put(i, (double)count[flag][i] / (double)total);
		}
		return prob;
	}
}
