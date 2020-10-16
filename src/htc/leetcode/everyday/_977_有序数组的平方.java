package htc.leetcode.everyday;

import java.util.Arrays;

/**
 * AC
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class _977_有序数组的平方 {
    public static void main(String[] args) {
        _977_有序数组的平方 test = new _977_有序数组的平方();
        System.out.println(Arrays.toString(test.sortedSquares(new int[]{-4,-1,0,3,10})));
        System.out.println(Arrays.toString(test.sortedSquares(new int[]{-7,-3,2,3,11})));
        System.out.println(Arrays.toString(test.sortedSquares(new int[]{-3,-2,1,3})));
    }
    /**
     * 双指针解法：
     * 每次对比两头数的绝对值，绝对值大的数求平方后从头到尾存入结果数组，直到两数相遇
     * ps:如只需将左指针的数求绝对值即可
     */
    public int[] sortedSquares(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int[] ans = new int[A.length];
        int index = right;
        while (left <= right) {
            int L = A[left];
            int R = A[right];
            if (L < 0) {
                L = -L;
            }
            if (L > R) {
                ans[index--] = L * L;
                left++;
            } else {
                ans[index--] = R * R;
                right--;
            }
        }
        return ans;
    }
}
