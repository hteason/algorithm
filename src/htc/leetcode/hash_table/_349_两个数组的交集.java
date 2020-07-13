package htc.leetcode.hash_table;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _349_两个数组的交集 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
		System.out.println(Arrays.toString(intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) {
			return new int[] {};
		}
		Set<Integer> set1 = new HashSet<>();
		for (int n1 : nums1) {
			set1.add(n1);
		}

		Set<Integer> set2 = new HashSet<>();
		for (int n2 : nums2) {
			set2.add(n2);
		}

		int[] ans = new int[nums1.length < nums2.length ? nums1.length : nums2.length];
		int i = 0;
		for (Integer s1 : set1) {
			if (set2.contains(s1)) {
				ans[i++] = s1;
			}
		}
		return Arrays.copyOf(ans, i);
	}
}
