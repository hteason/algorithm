package htc.leetcode.other;

public class ReverseWords557 {

	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
		;
	}

	public static String reverseWords(String s) {
		String[] ss = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0, len = ss.length; i < len; i++) {
			String str = ss[i];
			String sub = new StringBuilder(str).reverse().toString();
			sb.append(sub);
			if(i!=len-1) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}
