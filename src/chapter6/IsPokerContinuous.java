package chapter6;

import java.util.Arrays;

/**
 * Chapter6 Problem44 判断扑克牌是否顺子
 */
public class IsPokerContinuous {

	public static void main(String[] args) {

		//1, 2, 3, 4, 5
		int[] pokers1 = {1, 2, 3, 4, 5};
		System.out.println(isPokerContinuous(pokers1));

		// 2, 3, 4, 5, 6
		int[] pokers2 = {4, 2, 5, 6, 0};
		System.out.println(isPokerContinuous(pokers2));

		// 4, 5, 6, 7, 8
		int[] pokers3 = {4, 6, 7, 0, 0};
		System.out.println(isPokerContinuous(pokers3));

		// error
		int[] pokers4 = {0, 0, 1, 2, 0};
		System.out.println(isPokerContinuous(pokers4));
	}

	/**
	 * 检查是否顺子
	 * @param pokers
	 * @return
	 */
	public static boolean isPokerContinuous(int[] pokers) {

		// 牌数不合法
		if(pokers == null || pokers.length < 5) {
			return false;
		}

		Arrays.sort(pokers);
		int numZero = 0;
		for(int i = 0;i < pokers.length && pokers[i] == 0;i++) {
			numZero++;
		}

		// 0的张数不合法
		if(numZero > 2) {
			return false;
		}

		int gap = 0;
		for(int i = Math.max(1, numZero);i < pokers.length;i++) {
			if(pokers[i] == pokers[i-1]) {
				// 有对子, 不可能为顺子
				return false;
			}
			gap += pokers[i-1] == 0 ? 0 : (pokers[i] - pokers[i-1] - 1);
		}
		return !(gap > numZero);
	}
}
