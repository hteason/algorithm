package htc.leetcode.everyday._2020;

import java.util.Arrays;

/**
 * AC
 * https://leetcode-cn.com/problems/largest-perimeter-triangle/
 *
 * @date 2020/11/29
 */
public class _11_29_976_�����ε�����ܳ� {
    public static void main(String[] args) {
        _11_29_976_�����ε�����ܳ� test = new _11_29_976_�����ε�����ܳ�();
        System.out.println(test.largestPerimeter(new int[]{2, 1, 2}));
        System.out.println(test.largestPerimeter(new int[]{1, 2, 1}));
        System.out.println(test.largestPerimeter(new int[]{3, 2, 3, 4}));
        System.out.println(test.largestPerimeter(new int[]{3, 2, 3, 4, 2, 6, 1, 0, 33, 4}));
    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i - 1] + A[i - 2] > A[i]) {
                return A[i - 1] + A[i - 2] + A[i];
            }
        }
        return 0;
    }
}
