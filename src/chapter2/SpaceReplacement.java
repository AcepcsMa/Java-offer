package chapter2;

/**
 * Chapter2 Problem4 替换空格
 * @author Marco Ma
 */
public class SpaceReplacement {

	public static void main(String[] args) {
		String original = "We are happy";
		System.out.println(replaceSpace(original));
	}

	public static String replaceSpace(String original) {
		StringBuilder builder = new StringBuilder();
		char[] arr = original.toCharArray();
		for(char ch : arr) {
			if(ch != ' ') {
				builder.append(ch);
			} else {
				builder.append("%20");
			}
		}
		return builder.toString();
	}
}
