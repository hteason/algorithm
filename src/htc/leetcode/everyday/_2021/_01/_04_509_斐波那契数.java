package htc.leetcode.everyday._2021._01;

/**
 * AC
 * https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @date 2021/1/4
 */
public class _04_509_ì³²¨ÄÇÆõÊý {
    static int[] a = new int[31];

    public int fib(int N) {
        if (a[N] != 0) {
            return a[N];
        }
        if (N == 0 || N == 1) {
            return N;
        }
        return a[N] = fib(N - 1) + fib(N - 2);
    }
}
