package htc.leetcode.other;

import java.util.Arrays;
/*
 * AC
 * https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero
 */
public class _1304_和为零的N个唯一整数 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sumZero(9)));
		System.out.println(Arrays.toString(sumZero(6)));
		System.out.println(Arrays.toString(sumZero(5)));
		System.out.println(Arrays.toString(sumZero(3)));
		System.out.println(Arrays.toString(sumZero(2)));
	}

	public static int[] sumZero(int n) {
		int[] ans = new int[n];
		for (int i = 0; i < n >> 1; i++) {
			ans[i] = (n >> 1) - i;
			ans[n - i - 1] = i - (n >> 1);
		}
		return ans;
	}
}
