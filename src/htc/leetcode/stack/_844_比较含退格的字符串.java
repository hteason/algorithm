package htc.leetcode.stack;
/*
 * AC
 * https://leetcode-cn.com/problems/backspace-string-compare
 */
public class _844_比较含退格的字符串 {
	public static void main(String[] args) {
		System.out.println(backspaceCompare("ab#c", "ad#c"));
		System.out.println(backspaceCompare("a##c", "#a#c"));
		System.out.println(backspaceCompare("a#c", "b"));
	}

	// 98%,75%
	public static boolean backspaceCompare(String S, String T) {
		char[] s = S.toCharArray();// 用于处理S退格后的字符数组
		char[] t = T.toCharArray();// 用于处理T退格后的字符数组
		int ai = 0;
		int bi = 0;

		char[] a = new char[s.length];
		char[] b = new char[t.length];
		// 在遍历最小串时一起遍历最大串
		int minLen = t.length < s.length ? t.length : s.length;
		for (int i = 0; i < minLen; i++) {
			ai = handle(s, i, a, ai);
			bi = handle(t, i, b, bi);
//			if (s[i] != '#') {
//				a[ai++] = s[i];
//			} else {
//				ai = ai - 1 == -1 ? 0 : ai - 1;
//			}
//			if (t[i] != '#') {
//				b[bi++] = t[i];
//			} else {
//				bi = bi - 1 == -1 ? 0 : bi - 1;
//			}
		}
		// 遍历完最小串，遍历最大串剩下的字串，因为最小串已经遍历结束，不会进入循环
		while (minLen < s.length) {
			ai = handle(s, minLen, a, ai);
			minLen++;
		}

		while (minLen < t.length) {
			bi = handle(t, minLen, b, bi);
			minLen++;
		}
		if (ai != bi) {
			return false;
		}
		for (int i = 0; i < ai; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	private static int handle(char[] origin, int orgIndex, char[] dest, int destIndex) {
		if (origin[orgIndex] != '#') {
			dest[destIndex++] = origin[orgIndex];
		} else {
			destIndex = destIndex - 1 == -1 ? 0 : destIndex - 1;
		}
		return destIndex;
	}
}
