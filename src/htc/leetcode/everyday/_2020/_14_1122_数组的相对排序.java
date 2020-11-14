package htc.leetcode.everyday._2020;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * AC
 * https://leetcode-cn.com/problems/relative-sort-array/
 */
public class _14_1122_数组的相对排序 {
    public static void main(String[] args) {
        _14_1122_数组的相对排序 test = new _14_1122_数组的相对排序();
        System.out.println(Arrays.toString(test.relativeSortArray(
                new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6,7,19}
        )));

    }

    /**
     * TreeMap统计
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            return arr1;
        }
        int[] ans = new int[arr1.length];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int a1 : arr1) {
            map.put(a1, map.getOrDefault(a1, 0) + 1);
        }
        int i = 0;
        for (int a2 : arr2) {
            int count = map.get(a2);
            while (count-- > 0) {
                ans[i++] = a2;
            }
            map.remove(a2);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int count = e.getValue();
            int a = e.getKey();
            for (int j = 0; j < count; j++) {
                ans[i++] = a;
            }
        }
        return ans;
    }
}
