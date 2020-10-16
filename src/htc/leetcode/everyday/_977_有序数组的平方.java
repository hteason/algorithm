package htc.leetcode.everyday;

import java.util.Arrays;

/**
 * AC
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class _977_���������ƽ�� {
    public static void main(String[] args) {
        _977_���������ƽ�� test = new _977_���������ƽ��();
        System.out.println(Arrays.toString(test.sortedSquares(new int[]{-4,-1,0,3,10})));
        System.out.println(Arrays.toString(test.sortedSquares(new int[]{-7,-3,2,3,11})));
        System.out.println(Arrays.toString(test.sortedSquares(new int[]{-3,-2,1,3})));
    }
    /**
     * ˫ָ��ⷨ��
     * ÿ�ζԱ���ͷ���ľ���ֵ������ֵ�������ƽ�����ͷ��β���������飬ֱ����������
     * ps:��ֻ�轫��ָ����������ֵ����
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
