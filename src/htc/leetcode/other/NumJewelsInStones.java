package htc.leetcode.other;

public class NumJewelsInStones {
	public static void main(String[] args) {
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));;
	}
	public static int numJewelsInStones(String J, String S) {
		char[] j = J.toCharArray();
		char[] s = S.toCharArray();
		int count = 0;
		for (int i = 0; i < j.length; i++) {
			for (int k = i; k < s.length; k++) {
				if(j[i] == s[k]) {
					count++;
				}
			}
		}
		return count;
	}
}
