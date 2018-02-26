package chapter5;

/**
 * Chapter5 Problem32 求1-n中数字1出现的次数
 */
public class CountOfOne {

	public static void main(String[] args) {
		int n = 534;
		System.out.println(countOfOne(n));
	}

	/**
	 * 求数字1在1-n中出现的次数
	 * @param n n
	 * @return 出现1的次数
	 */
	public static int countOfOne(int n) {
		if(n <= 0) {
			return 0;
		}
		int count = 0;
		int round = n;
		int base = 1;
		while(round > 0) {
			int cur = round % 10;
			round /= 10;
			count += round * base;
			if(cur == 1) {
				int former = n % base;
				count += former + 1;
			} else if(cur > 1) {
				count += base;
			}
			base *= 10;
		}
		return count;
	}
}
