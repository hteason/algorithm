package htc.leetcode.everyday._2021._01;

import java.util.Arrays;

/**
 * AC
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * @date 2021/1/8
 */
public class _08_189_旋转数组 {
    public static void main(String[] args) {
        _08_189_旋转数组 test = new _08_189_旋转数组();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        test.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    //暴力 慢
    public void rotate(int[] nums, int k) {
        for (k = k % nums.length; k > 0; k--) {
            int end = nums.length - 1;
            int tmp = nums[end];
            while (end > 0) {
                nums[end] = nums[end - 1];
                end--;
            }
            nums[0] = tmp;
        }
    }

}
