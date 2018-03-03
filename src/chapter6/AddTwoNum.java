package chapter6;

/**
 * Chapter6 Problem47 不用加减乘除实现两数相加
 */
public class AddTwoNum {

	public static void main(String[] args) {
		int a = 5;
		int b = 17;
		System.out.println(addTwoNum(a, b));
	}

	/**
	 * 不用加减乘除实现加法
	 * @param a a
	 * @param b b
	 * @return 计算结果
	 */
	public static int addTwoNum(int a, int b) {

		if(a == 0) {
			return b;
		}
		if(b == 0) {
			return a;
		}

		while(b != 0) {
			int carry = (a & b) << 1;	// 计算进位
			a = a ^ b;	// 做无进位的加法
			b = carry;	// 将进位留待下一循环使用
		}
		return a;
	}
}
