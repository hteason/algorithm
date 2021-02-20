package htc.leetcode.everyday._2021._02;

import java.util.HashMap;
import java.util.Map;

/**
 * AC
 * https://leetcode-cn.com/problems/degree-of-an-array/
 *
 * @date 2021/2/20
 */
public class _20_697_数组的度 {
    public static void main(String[] args) {
        _20_697_数组的度 test = new _20_697_数组的度();
        System.out.println(test.findShortestSubArray(new int[]{1}));
        System.out.println(test.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(test.findShortestSubArray(new int[]{1, 1, 2, 2, 3, 1, 4, 2}));
        System.out.println(test.findShortestSubArray(new int[]{1, 3, 2, 2, 3, 1}));
        System.out.println(test.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }

    /**
     * time   95.26%
     * memory 39.46%
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int[] index = map.get(num);
            if (index == null) {
                index = new int[3];
                index[1] = i;
                index[2] = i;
                map.put(num, index);
            } else {
                index[2] = i;
            }
            index[0]++;
        }
        int count = Integer.MIN_VALUE;
        int len = Integer.MAX_VALUE;
        for (int[] v : map.values()) {
            int cnt = v[0];
            if (cnt > count) {
                len = v[2] - v[1] + 1;
                count = cnt;
            } else if (cnt == count) {
                len = Math.min(len, v[2] - v[1] + 1);
                count = cnt;
            }
        }
        return len;
    }
}
