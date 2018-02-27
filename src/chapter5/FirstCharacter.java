package chapter5;

import java.util.HashMap;
import java.util.Map;

/**
 * Chapter5 Problem35 第一个只出现一次的字符
 */
public class FirstCharacter {

	public static void main(String[] args) {
		String s = "abaccdeff";
		System.out.println(firstCharacter(s));
	}

	/**
	 * 用Hash表作出现次数的记录
	 * @param s 输入字符串
	 * @return 目标字符
	 */
	public static Character firstCharacter(String s) {
		if(s == null || s.length() == 0) {
			return null;
		}

		Map<Character, Integer> count = new HashMap<>();
		char[] charS = s.toCharArray();
		for(int i = 0;i < charS.length;i++) {
			count.put(charS[i], count.getOrDefault(charS[i], 0) + 1);
		}
		for(int i = 0;i < charS.length;i++) {
			if(count.get(charS[i]) == 1) {
				return charS[i];
			}
		}
		return null;
	}
}
