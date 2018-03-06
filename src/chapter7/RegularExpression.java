package chapter7;

/**
 * Chapter7 Problem53 正则表达式
 */
public class RegularExpression {

	public static void main(String[] args) {
		String s = "aab";
		String p = "c*a*b";
		System.out.println(regexMatch(s, p));
	}

	/**
	 * 正则表达式匹配
	 * @param s 目标字符串
	 * @param p 正则表达式
	 * @return true/false
	 */
	public static boolean regexMatch(String s, String p) {
		if(s == null || p == null) {
			return false;
		}

		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;

		// 特殊case, 目标串为空串
		for(int j = 2;j <= p.length();j++) {
			dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
		}

		for(int i = 1;i <= s.length();i++) {
			for(int j = 1;j <= p.length();j++) {

				// 直接匹配当前字符
				if(p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				}

				// 匹配前一字符0次或多次
				if(p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
