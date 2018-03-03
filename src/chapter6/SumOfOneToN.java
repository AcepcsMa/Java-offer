package chapter6;

/**
 * Chapter6 Problem46 1-n的和
 */
public class SumOfOneToN {

	public static void main(String[] args) {
		int n = 100;
		System.out.println(sumOfOneToN(n));
	}

	/**
	 * 递归
	 * @param n n
	 * @return 结果
	 */
	public static int sumOfOneToN(int n) {
		if(n <= 1) {
			return n;
		}
		return sumOfOneToN(n - 1) + n;
	}
}
