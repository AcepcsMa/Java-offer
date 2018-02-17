package chapter2;

/**
 * Chapter2 Problem9.1 斐波那契数列
 */
public class Fibonacci {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(fib(n));
	}

	public static int fib(int n) {
		if (n <= 0) {
			throw new RuntimeException("N should be positive!");
		}
		if (n == 1 || n == 2) {
			return 1;
		}

		int[] fib = new int[n+1];
		fib[1] = 1;
		fib[2] = 1;
		for (int i = 3;i <= n;i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		return fib[n];
	}
}
