package htc.leetcode.everyday;

/**
 * AC
 * 注意纯递增和纯递减的情况
 * https://leetcode-cn.com/problems/valid-mountain-array/
 *
 * @author huangtingcheng
 * @date 2020/11/3
 */
public class _941_有效的山脉数组 {

    public static void main(String[] args) {
        _941_有效的山脉数组 test = new _941_有效的山脉数组();
        System.out.println(test.validMountainArray(new int[]{2, 1}));
        System.out.println(test.validMountainArray(new int[]{3, 5, 5}));
        System.out.println(test.validMountainArray(new int[]{0, 3, 2, 1}));
        System.out.println(test.validMountainArray(new int[]{0, 2, 3, 4, 5, 2, 1, 0}));
        System.out.println(test.validMountainArray(new int[]{0, 2, 3, 3, 5, 2, 1, 0}));
        System.out.println(test.validMountainArray(new int[]{0, 2, 3, 4, 5, 2, 2, 1, 0}));
        System.out.println(test.validMountainArray(new int[]{5, 2, 1, 0}));
    }

    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        int cur = A[0];
        boolean down = false;
        for (int i = 1; i < A.length; i++) {
            if (!down) {
                if (cur < A[i]) {
                    cur = A[i];
                } else if (cur == A[i]) {
                    return false;
                } else {
                    if (i == 1) {
                        return false;
                    }
                    cur = A[i];
                    down = true;
                }
            } else {
                if (cur <= A[i]) {
                    return false;
                } else {
                    cur = A[i];
                }
            }
        }
        return down;
    }
}
