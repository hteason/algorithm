package htc.leetcode.top_interview;

/*
 * status:AC
 * TODO 时空优化
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class _28_实现strStr {

	public static void main(String[] args) {
		System.out.println(strStr("hello", ""));
		System.out.println(strStr("h", "ll"));
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaa", "bba"));
	}

	public static int strStr(String haystack, String needle) {
		if (needle == null || "".equals(needle)) {
			return 0;
		}
		if (haystack.length() < needle.length()) {
			return -1;
		}
		char[] hay = haystack.toCharArray();
		char[] need = needle.toCharArray();
		for (int i = 0; i < hay.length; i++) {
			if (need[0] == hay[i]) {

				if (hay.length - i < need.length) {
					return -1;
				}

				int begin = 0;
				while (begin < need.length && need[begin] == hay[begin + i]) {
					begin++;
				}
				if (begin == need.length) {
					return i;
				}
			}
		}

		return -1;
	}
}
