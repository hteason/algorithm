package htc.leetcode.top_interview;

import java.util.Arrays;

public class _88_合并两个有序数组 {

	public static void main(String[] args) {
		int[] nums1 = { 10, 20, 30, 0, 0, 0 };
		int[] nums2 = { 2, 5, 60 };

		merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
		System.out.println(Arrays.toString(nums1));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int s1 = 0;
		int s2 = 0;
		int minIndex;
		while (s1 < m) {
			if (nums1[s1] <= nums2[s2]) {
				s1++;
			} else {
				int t = nums1[s1];
				nums1[s1] = nums2[s2];
				nums2[s2] = t;
				if (s2 < n && nums2[s2] > nums2[s2 + 1]) {
					s2++;
					minIndex=s2;
				}else {
					minIndex = s2-1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			nums1[s1++] = nums2[s2++ % n];
		}
	}

}
