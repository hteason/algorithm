package htc.leetcode.everyday._2020._12;

/**
 * AC
 * https://leetcode-cn.com/problems/count-primes/
 *
 * @date 2020/12/3
 */
public class _03_204_计数质数 {
    public static void main(String[] args) {
        _03_204_计数质数 test = new _03_204_计数质数();
        System.out.println(test.countPrimes(10));
        System.out.println(test.countPrimes(100));
        System.out.println(test.countPrimes(5000000));
        System.out.println(test.countPrimes(0));
        System.out.println(test.countPrimes(1));
    }

    /**
     * 筛法求素数
     */
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] p = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!p[i]) {
                count++;
                for (int j = 2, k = i * j; k < n; j++, k = i * j) {
                    if (!p[k]) {
                        p[k] = true;
                    }
                }
            }
        }
        return count;
    }
}
