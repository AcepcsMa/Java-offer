package chapter5;

/**
 * Chapter5 Problem34 丑数
 */
public class UglyNumber {

	public static void main(String[] args) {
		int n = 1500;
		System.out.println(uglyNumber(n));
	}

	/**
	 * 空间换时间, 构造丑数数组
	 * @param n nth
	 * @return 第n个丑数
	 */
	public static int uglyNumber(int n) {
		if(n <= 0) {
			return -1;
		}

		int[] uglyNums = new int[n];
		uglyNums[0] = 1;
		int index2 = 0, index3 = 0, index5 = 0;

		for(int i = 1;i < n;i++) {
			uglyNums[i] = Math.min(Math.min(uglyNums[index2] * 2, uglyNums[index3] * 3), uglyNums[index5] * 5);
			if(uglyNums[i] == uglyNums[index2] * 2) {
				index2++;
			} else if(uglyNums[i] == uglyNums[index3] * 3) {
				index3++;
			} else {
				index5++;
			}
		}
		return uglyNums[n-1];
	}
}
