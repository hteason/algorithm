package htc.leetcode.greed;

public class _1221_·Ö¸îÆ½ºâ×Ö·û´® {
	public static void main(String[] args) {
		System.out.println(balancedStringSplit("RLRRLLRLRL"));
		System.out.println(balancedStringSplit("RLLLLRRRLR"));
		System.out.println(balancedStringSplit("LLLLRRRR"));
		System.out.println(balancedStringSplit("L"));
	}

	public static int balancedStringSplit(String s) {
		if (s.length() == 1) {
			return 0;
		}
		int count = 0;
		int ans = 0;
		for (char ch : s.toCharArray()) {
			if (ch == 'L') {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				ans++;
			}
		}

		return ans;
	}
}
