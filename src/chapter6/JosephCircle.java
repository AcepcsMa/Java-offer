package chapter6;

/**
 * Chapter6 Problem45 约瑟夫环
 */
public class JosephCircle {

	public static void main(String[] args) {
		int n = 5;
		int m = 3;
		System.out.println(josephCircle1(n, m));
		System.out.println(josephCircle2(n, m));
	}

	/**
	 * 递归
	 * @param n n
	 * @param m m
	 * @return 最终剩下的数
	 */
	public static int josephCircle1(int n, int m) {
		if(n < 1) {
			throw new RuntimeException();
		}
		if(n == 1) {
			return 0;
		} else {
			return (josephCircle1(n-1, m) + m) % n;
		}
	}

	/**
	 * 循环
	 * @param n n
	 * @param m m
	 * @return 最终剩下的数
	 */
	public static int josephCircle2(int n, int m) {
		if(n < 1) {
			throw new RuntimeException();
		}

		if(n == 1) {
			return 0;
		}

		int result = 0;
		for(int i = 2;i <= n;i++) {
			result = (result + m) % i;
		}
		return result;
	}
}
