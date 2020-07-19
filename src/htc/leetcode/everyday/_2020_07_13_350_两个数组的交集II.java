package htc.leetcode.everyday;

import java.util.*;

/**
 * AC
 */
public class _2020_07_13_350_两个数组的交集II {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(intersect(new int[]{}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{})));
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 5})));
        System.out.println(Arrays.toString(intersect(new int[]{0, 0}, new int[]{1, 0, 0})));
    }

    /**
     * v1.0
     */
    public static int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> map1 = new HashMap<>(nums1.length);
        for (int n1 : nums2) {
            map1.put(n1, map1.getOrDefault(n1, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(nums2.length);
        for (int n2 : nums1) {
            int n2Count = map1.getOrDefault(n2, 0);
            if (n2Count != 0) {
                list.add(n2);
                map1.put(n2, n2Count - 1);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0, len = res.length; i < len; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * v1.1 空间优化
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> map1 = new HashMap<>(nums1.length);
        for (int n1 : nums2) {
            map1.put(n1, map1.getOrDefault(n1, 0) + 1);
        }

        int[] res = new int[nums1.length];
        int count = 0;
        for (int n2 : nums1) {
            int n2Count = map1.getOrDefault(n2, 0);
            if (n2Count != 0) {
                res[count++] = n2;
                map1.put(n2, n2Count - 1);
            }
        }
        return Arrays.copyOfRange(res, 0, count);
    }
}
