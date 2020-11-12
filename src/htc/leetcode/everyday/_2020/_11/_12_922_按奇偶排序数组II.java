package htc.leetcode.everyday._2020._11;

/**
 * AC
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 */
public class _12_922_°´ÆæÅ¼ÅÅĞòÊı×éII {

    public int[] sortArrayByParityII(int[] A) {
        int o = 0;
        int j = 1;
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) == 0) {
                res[o] = A[i];
                o += 2;
            } else {
                res[j] = A[i];
                j += 2;
            }
        }
        return res;
    }
}
