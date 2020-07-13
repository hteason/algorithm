package htc.leetcode.other;

import java.util.Stack;

public class _1221SplitAStringInBalancedStrings {

	public static void main(String[] args) {
		System.out.println(new _1221SplitAStringInBalancedStrings().balancedStringSplit2("RLRRLLRLRL"));
		System.out.println(new _1221SplitAStringInBalancedStrings().balancedStringSplit2("RLLLLRRRLR"));
		System.out.println(new _1221SplitAStringInBalancedStrings().balancedStringSplit2("LLLLRRRR"));
	}

	/*
	 * R转-1
	 * L转1
	 * 若前n项和为0，则计数+1
	 */
	public int balancedStringSplit2(String s) {
		int count = 0;
		int ret = 0;
		for (int i = 0, len = s.length(); i < len; i++) {
			int num = s.charAt(i) == 'R' ? -1 : 1;
			ret += num;
			if (ret == 0) {
				count++;
			}
		}
		return count;
	}

	public int balancedStringSplit(String s) {
		int count = 0;
		int RCount = 0;
		int LCount = 0;
		for (int i = 0, len = s.length(); i < len;) {
			if (s.charAt(i) == 'R') {
				RCount++;
				if (i > 0 && s.charAt(i - 1) == 'L') {

				} else {
					i++;
				}
			} else if (s.charAt(i) == 'L') {
				LCount++;

				i += RCount;
				if (i > len) {
					break;
				}
				RCount = 0;
			}
		}
		return count;
	}
}
