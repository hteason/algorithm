package htc.leetcode.everyday._2020._11;

import java.util.Arrays;

/**
 * AC
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class _19_283_“∆∂Ø¡„ {
    public static void main(String[] args) {
        _19_283_“∆∂Ø¡„ test = new _19_283_“∆∂Ø¡„();
        int[] arr = new int[]{0, 1, 0, 3, 12};
        test.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{0, 1, 0, 3, 12, 1, 4, 0, 3, 5};
        test.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 3, 12, 1, 4, 0, 3, 5};
        test.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int k = i + 1; k < nums.length; k++) {
                    if (nums[k] != 0) {
                        int tmp = nums[i];
                        nums[i] = nums[k];
                        nums[k] = tmp;
                        break;
                    }
                }
            }
        }
    }
}
