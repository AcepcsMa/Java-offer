package chapter7;

/**
 * Chapter7 Problem55 字符流中第一个只出现一次的字符
 */
public class FirstNonDuplicateChar {

	public static void main(String[] args) {
		String s = "google";
		System.out.println(firstNonDuplicateChar(s));
	}

	public static char firstNonDuplicateChar(String s) {
		if(s == null || s.length() == 0) {
			throw new RuntimeException();
		}

		int[] count = new int[256];
		char[] charS = s.toCharArray();
		for(char ch : charS) {
			count[ch]++;
		}

		for(char ch : charS) {
			if(count[ch] == 1) {
				return ch;
			}
		}
		throw new RuntimeException();
	}
}
