package htc.leetcode.dp;
/*
 * AC
 * ��ʱ
 * https://leetcode-cn.com/problems/is-subsequence/
 * ����dp!!!
 */
public class _392_�ж������� {
	public static void main(String[] args) {
		System.out.println(isSubsequence("abc", "ahbgdc"));
		System.out.println(isSubsequence("abc", "ahbgdc"));
		System.out.println(isSubsequence("", "ahbgdc"));
	}

	public static boolean isSubsequence(String s, String t) {
		if (s.length() == 0) {//�մ�һ�����Ӵ�
			return true;
		}
        if( s.length() > t.length()){//�Ӵ�����ԭ��һ��false
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
