package chapter2;

/**
 * Chapter2 Problem10 二进制中1的个数
 */
public class CountOne {

	public static void main(String[] args) {
		int num = 15;
		System.out.println(countOne(num));
	}

	public static int countOne(int num) {
		int count = 0;
		for (int i = 0;i < 32;i++) {
			if ((num & 1) == 1) {
				count++;
			}
			num = num >> 1;
		}
		return count;
	}
}
