package htc.leetcode.other;

import java.util.Arrays;
/*
 * AC
 * https://leetcode-cn.com/problems/decompress-run-length-encoded-list
 */
public class _1313_Ω‚—πÀı±‡¬Î¡–±Ì {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(decompressRLElist(2, 2, 3, 4)));
		System.out.println(Arrays.toString(decompressRLElist(100, 3, 100, 5, 100, 3, 100, 5, 100, 3, 100, 5, 100, 3,
				100, 5, 100, 3, 100, 5, 100, 3, 100, 5, 100, 3, 100, 5, 100, 3, 100, 5, 100, 3, 100, 5, 100, 3, 100, 5,
				100, 3, 100, 5, 100, 3, 100, 5, 100, 3, 100, 5, 100, 3, 100, 5, 100, 3, 100, 5, 100, 3, 100, 5, 100, 3,
				100, 5, 100, 3, 100, 5, 100, 3, 100, 5, 100, 3, 100, 5, 100, 3, 100, 5, 100, 3, 100, 5, 100, 3, 100, 5,
				100, 3, 100, 5, 100, 3, 100, 5)));
	}

	public static int[] decompressRLElist(int... nums) {
		int[] ans = new int[5000];
		int toIndex = 0;
		for (int i = 0, fromIndex = 0; i < nums.length; i += 2) {
			toIndex = fromIndex + nums[i];
			while (fromIndex < toIndex) {
				ans[fromIndex++] = nums[i + 1];
			}
		}
		return Arrays.copyOf(ans, toIndex);
	}
}
