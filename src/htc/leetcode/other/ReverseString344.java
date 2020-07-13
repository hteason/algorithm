package htc.leetcode.other;

import java.util.Arrays;

public class ReverseString344 {

	public static void main(String[] args) {
		char[] arr = new char[] { 'H','a','n','n','a','h'};
		reverseString(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void reverseString(char[] s) {
		int len = s.length;
		for (int i = 0; i < len / 2; i++) {
			int dis = s[len - i - 1] - s[i];
			s[i] = (char) (s[i] + dis);
			s[len - i - 1] = (char) (s[i] - dis);
		}
	}
}
