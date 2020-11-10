package htc.leetcode.everyday._2020._11;

import java.util.Arrays;

/**
 * AC
 * 较优算法，代码还可优化
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class _10_31_下一个排列 {
    public static void main(String[] args) {
        _10_31_下一个排列 test = new _10_31_下一个排列();
        int[] nums = new int[]{1, 2, 3};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{3, 2, 1};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 1, 5};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 3, 2};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 4, 5, 3};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 3, 5, 4};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{5, 4, 7, 5, 3, 2};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 2, 7, 5, 4, 3, 2, 2, 1};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{4, 2, 0, 2, 3, 2, 0};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                //往i后找比i-1大的最小的数
                int j = i;
                if (j == len - 1 && nums[j] > nums[i - 1]) {
                    j = len - 1;
                } else {
                    while (j < len - 1) {
                        if (nums[j] > nums[i - 1] && nums[j + 1] <= nums[i - 1]) {
                            break;
                        }
                        j++;
                    }
                }
                swap(nums, j, i - 1);
                //i后升序排列
                for (int k = i; k < len; k++) {
                    for (int m = k + 1; m < len; m++) {
                        swap(nums, k, m);
                    }
                }
                return;
            }
            if (i == 1) {
                for (int j = 0; j < len / 2; j++) {
                    swap(nums, j, len - j - 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
