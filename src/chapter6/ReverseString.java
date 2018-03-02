package chapter6;

/**
 * Chapter6 Problem42 反转单词顺序
 */
public class ReverseString {

	public static void main(String[] args) {
		String s = "I am a student.";
		System.out.println(reverseString(s));

		String ss = "abcdefg";
		System.out.println(reversePartially(ss, 2));
	}

	/**
	 * 反转单词顺序
	 * @param s 输入字符串
	 * @return 反转后的字符串
	 */
	public static String reverseString(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}

		char[] charS = s.toCharArray();
		reverse(charS, 0, charS.length - 1);
		int head = 0;
		int tail = 1;
		while(tail < charS.length) {
			while(tail < charS.length && charS[tail] != ' ') {
				tail++;
			}
			reverse(charS, head, tail - 1);
			tail++;
			head = tail;
		}
		return new String(charS);
	}

	/**
	 * 左旋k个字符
	 * @param s 输入字符串
	 * @param k k个字符
	 * @return 旋转后的结果
	 */
	public static String reversePartially(String s, int k) {
		if(s == null || s.length() == 0) {
			return s;
		}

		char[] charS = s.toCharArray();
		reverse(charS, 0, charS.length - 1);

		k %= s.length();
		reverse(charS, 0, s.length() - k - 1);
		reverse(charS, s.length() - k, s.length() - 1);
		return new String(charS);
	}

	public static void reverse(char[] chars, int start, int end) {
		while(start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}
}
