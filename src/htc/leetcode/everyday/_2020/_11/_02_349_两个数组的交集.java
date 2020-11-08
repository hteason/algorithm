package htc.leetcode.everyday._2020._11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * AC
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class _02_349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
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
