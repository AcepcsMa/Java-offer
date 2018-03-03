package chapter7;

/**
 * Chapter7 Problem49 字符串转换为整数
 */
public class StrToInt {

	public static void main(String[] args) {
		String s = ".-12345";
		System.out.println(strToInt(s));
	}

	/**
	 * 字符串转换整数
	 * @param s 输入字符串
	 * @return 结果整数
	 */
	public static int strToInt(String s) {
		if(s == null || s.length() == 0) {
			throw new RuntimeException();
		}

		char[] charS = s.toCharArray();
		boolean isPositive = true;
		int index = 0;

		// 跳过头部空格
		while(index < charS.length && charS[index] == ' ') {
			index++;
		}

		// 判断正负数
		if(charS[index] == '+') {
			isPositive = true;
			index++;
		} else if(charS[index] == '-') {
			isPositive = false;
			index++;
		} else if(!Character.isDigit(charS[index])) {
			throw new RuntimeException("Invalid Format");
		}

		int sum = 0;
		while(index < charS.length) {
			char cur = charS[index];

			// 遇到非数字直接抛异常
			if(!Character.isDigit(cur)) {
				throw new RuntimeException("Invalid Format");
			}
			// 遇到Int溢出直接抛异常
			if(sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && cur - '0' > Integer.MAX_VALUE % 10)) {
				throw new RuntimeException("Integer Overflow");
			}
			sum = sum * 10 + (cur - '0');
			index++;
		}

		return isPositive ? sum : -sum;
	}
}
