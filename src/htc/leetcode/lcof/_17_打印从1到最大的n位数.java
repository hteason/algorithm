package htc.leetcode.lcof;

import java.util.Arrays;

/*
 * AC
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class _17_打印从1到最大的n位数 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(printNumbers(1)));
		System.out.println(Arrays.toString(printNumbers(2)));
		System.out.println(Arrays.toString(printNumbers(3)));
		System.out.println(Arrays.toString(printNumbers(4)));
//		System.out.println(Arrays.toString(printNumbers(5)));
//		System.out.println(Arrays.toString(printNumbers(6)));
//		System.out.println(Arrays.toString(printNumbers(7)));
//		System.out.println(Arrays.toString(printNumbers(8)));
	}

	public static int[] printNumbers(int n) {
		// 因为n为正整数，所以最小为10
		int[] map = { 10, 100, 1000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000,
				Integer.MAX_VALUE };
		int[] ans = new int[map[n - 1] - 1];
		for (int i = 1; i <= ans.length; i++) {
			ans[i - 1] = i;
		}
		return ans;
	}

	public static int[] printNumbers2(int n) {
		// 因为n为正整数，所以最小为10
		int[] map = { 9, 99, 999, 9_999, 99_999, 999_999, 9_999_999, 99_999_999, 999_999_999, Integer.MAX_VALUE };
		int[] ans = new int[map[n - 1]];
		for (int i = 1; i <= ans.length; i++) {
			ans[i - 1] = i;
		}
		return ans;
	}
}
