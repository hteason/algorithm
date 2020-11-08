package htc.leetcode.everyday._2020._06;

import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 *
 */
public class _2020_6_6_128_最长连续序列 {
	public static void main(String[] args) {
		System.out.println(
				longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
		System.out.println(longestConsecutive(new int[] { 6, 5, 2, 3, 4, 1 }));
		System.out
				.println(longestConsecutive(new int[] { 6, 5, 2, 3, 4, 8, 7 }));
		System.out.println(longestConsecutive(new int[] {}));
	}

	public static int longestConsecutive(int[] nums) {
		Set<Integer> set = new TreeSet<>();
		for (int n : nums) {
			set.add(n);
		}
		int max = Integer.MIN_VALUE;
		int len = 0;
		for (int n : set) {
			if (set.contains(n - 1)) {
				len++;
			} else {
				max = len > max ? len : max;
				len = 1;
			}
		}
		return len > max ? len : max;
	}
}
