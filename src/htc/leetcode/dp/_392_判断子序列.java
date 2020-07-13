package htc.leetcode.dp;
/*
 * AC
 * 用时
 * https://leetcode-cn.com/problems/is-subsequence/
 * 试试dp!!!
 */
public class _392_判断子序列 {
	public static void main(String[] args) {
		System.out.println(isSubsequence("abc", "ahbgdc"));
		System.out.println(isSubsequence("abc", "ahbgdc"));
		System.out.println(isSubsequence("", "ahbgdc"));
	}

	public static boolean isSubsequence(String s, String t) {
		if (s.length() == 0) {//空串一定是子串
			return true;
		}
        if( s.length() > t.length()){//子串大于原串一定false
            return false;
        }
		char[] ss = s.toCharArray();
		int j = 0;
		for (char tt : t.toCharArray()) {
			if (tt == ss[j]) {
				j++;
			}
			if (j == ss.length) {
				return true;
			}
		}
		return false;
	}
}
