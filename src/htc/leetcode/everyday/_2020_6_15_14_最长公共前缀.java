package htc.leetcode.everyday;

public class _2020_6_15_14_最长公共前缀 {
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(
				new String[] { "flower", "flow", "foght" }));
		System.out.println(longestCommonPrefix(
				new String[] { "flower", "flow", "flight" }));
		System.out.println(
				longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
		System.out.println(
				longestCommonPrefix(new String[] { "a"}));
		System.out.println(
				longestCommonPrefix(new String[] { }));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length==0) {
			return "";
		}else if (strs.length==1) {
			return strs[0];
		}
		for (int i = 0, outLen = strs[0].length(); i < outLen; i++) {
			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length() || i >= strs[j-1].length() ||strs[j].charAt(i) != strs[j-1].charAt(i)) {
					return strs[j].substring(0,i);
				}
			}
		}
		return strs[0];
	}
}
