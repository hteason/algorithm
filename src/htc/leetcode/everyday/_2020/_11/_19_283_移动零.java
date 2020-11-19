package htc.leetcode.everyday._2020._11;

import java.util.Arrays;

/**
 * AC
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class _19_283_移动零 {
    public static void main(String[] args) {
        _19_283_移动零 test = new _19_283_移动零();
        int[] arr = new int[]{0, 1, 0, 3, 12};
        test.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{0, 1, 0, 3, 12, 1, 4, 0, 3, 5};
        test.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 3, 12, 1, 4, 0, 3, 5};
        test.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{12, 4, 5, 0, 5, 7, 0, 7, 87, 4, 67, 9, 0, 45, 6, 900, 0, 0, 0, 0, 2};
        test.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 存在重复遍历,8ms
     */
    public void moveZeroes0(int[] nums) {
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

    /**
     * 优化1
     * 减少遍历次数,1ms
     */
    public void moveZeroes1(int[] nums) {
        for (int i = 0, firstZero = -1; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (firstZero == -1) {
                    firstZero = i;
                }
                while (++i < nums.length) {
                    if (nums[i] != 0) {
                        nums[firstZero] = nums[i];
                        nums[i] = 0;
                        firstZero++;
                        i--;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 优化2
     * 减少遍历次数和判断第一个0的次数,0ms,击败100%
     */
    public void moveZeroes(int[] nums) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                break;
            }
        }
        int firstZero = i;
        for (; i < nums.length; i++) {
            if (nums[i++] == 0) {
                while (i < nums.length) {
                    if (nums[i] != 0) {
                        nums[firstZero] = nums[i];
                        nums[i] = 0;
                        firstZero++;
                        i--;
                        break;
                    }
                    i++;
                }
            }
        }
    }
}
