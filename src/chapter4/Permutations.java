package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Chapter4 Problem28 字符串的排列
 */
public class Permutations {

	public static void main(String[] args) {

		String s = "baca";
		List<String> result = permutations(s);
		System.out.println(Arrays.toString(result.toArray(new String[0])));
	}

	public static List<String> permutations(String s) {
		List<String> result = new ArrayList<>();

		// 为了去重
		char[] alphabet = s.toCharArray();
		Arrays.sort(alphabet);

		boolean[] used = new boolean[alphabet.length];

		dfs(result, new StringBuilder(), alphabet, used);
		return result;
	}

	/**
	 * dfs求所有解
	 * @param result 结果列表
	 * @param path 当前路径的字符串
	 * @param alphabet 字母表
	 * @param used 使用记录 (记录i号位上的字母是否被使用过)
	 */
	public static void dfs(List<String> result, StringBuilder path, char[] alphabet, boolean[] used) {
		if(path.length() == alphabet.length) {
			result.add(path.toString());
		} else {
			for(int i = 0;i < alphabet.length;i++) {

				// 去重!!! 如果当前字母和上一个字母重复, 且上一个字母还没被用过, 肯定出现重复!!!
				if(used[i] || (i > 0 && alphabet[i] == alphabet[i-1] && !used[i-1])) {
					continue;
				}
				path.append(alphabet[i]);
				used[i] = true;
				dfs(result, path, alphabet, used);
				path.deleteCharAt(path.length()-1);
				used[i] = false;
			}
		}
	}
}
