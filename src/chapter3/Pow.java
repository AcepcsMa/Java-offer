package chapter3;

/**
 * Chapter3 Problem11 数值的整数次方
 */
public class Pow {

	public static void main(String[] args) {
		int num = 3;
		int n = -2;
		System.out.println(pow(num, n));
	}

	public static double pow(int num, int n) {
		double result = 1;
		long absN = Math.abs((long)n);

		while(absN != 0) {
			if((absN & 1) == 1) {
				result *= num;
			}
			absN = absN >> 1;
			num *= num;
		}

		return n < 0 ? 1 / result : result;
	}
}
