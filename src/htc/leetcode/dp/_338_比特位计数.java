package htc.leetcode.dp;

import java.util.Arrays;
/*
 * 卒
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class _338_比特位计数 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(countBits(2)));
		System.out.println(Arrays.toString(countBits(5)));
		System.out.println(Arrays.toString(countBits(16)));
		System.out.println(Arrays.toString(countBits(32)));
	}

	public static int[] countBits(int num) {
		if (num == 0) {
			return new int[] { 0 };
		}
		int[] dp = new int[num + 1];
		dp[0] = 0;
		int mod = 0;
		int pow = 4;
		int[] add = { 0, 1, 1, 2 };//位值求余
		for (int i = 1; i < dp.length; i++) {
			if (i % 4 == 0) {
				mod++;
			}
			if (pow == i) {
				mod = 1;
				pow <<= 1;//乘2
			}
			dp[i] = mod + add[i % 4];
		}

		return dp;
	}
}
