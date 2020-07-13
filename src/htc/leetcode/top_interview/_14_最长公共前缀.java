package htc.leetcode.top_interview;

import java.util.Arrays;
/*
 * status: AC
 * https://leetcode-cn.com/problems/longest-common-prefix
 */
public class _14_�����ǰ׺ {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
		System.out.println(longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		System.out.println(longestCommonPrefix(new String[] {}));
	}

	/*
	 * 	���⣺������[ ]���ѽ��
	 *  FIXME ʱ�մ��Ż�
	 */
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		char[] maxPre = strs[0].toCharArray();
		for (int i = 1; i < strs.length; i++) {
			char[] ss = strs[i].toCharArray();
			int minLen = maxPre.length < ss.length ? maxPre.length : ss.length;
			int j;
			for (j = 0; j < minLen; j++) {
				if (maxPre[j] != ss[j]) {
					if (j == 0) {
						return "";
					}
					break;
				}
			}
			maxPre = Arrays.copyOf(maxPre, j);
		}
		return String.valueOf(maxPre);
	}

}
