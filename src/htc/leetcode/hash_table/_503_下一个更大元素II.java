package htc.leetcode.hash_table;

import java.util.Arrays;

/**
 * 暴力AC
 * TODO 可优化解法：单调栈
 * 题目：https://leetcode-cn.com/problems/next-greater-element-ii/
 */
public class _503_下一个更大元素II {
    public static void main(String[] args) {
        _503_下一个更大元素II test = new _503_下一个更大元素II();
        System.out.println(Arrays.toString(test.nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(test.nextGreaterElements(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(test.nextGreaterElements(new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100})));
    }

    /**
     * 暴力过的
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0, len = nums.length; i < len; i++) {
            int nextMax = -1;
            //遍历到末尾后求模,继续从头开始遍历
            for (int j = i + 1; j % len != i; j++) {
                if (nums[j % len] > nums[i]) {
                    nextMax = nums[j % len];
                    break;
                }
            }
            res[i] = nextMax;
        }
        return res;
    }
}
