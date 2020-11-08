package htc.leetcode.everyday._2020._07;

/**
 * AC
 * 其他实现思路：DP
 * https://leetcode-cn.com/problems/divisor-game/
 */
public class _2020_07_24_1025除数博弈 {
    //智力做法
    public boolean divisorGame(int N) {
        return (N & 1) == 0;
    }

    //DP
    public boolean divisorGameDP(int N) {
        boolean[] f = new boolean[N + 5];

        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= N; ++i) {
            for (int j = 1; j < i; ++j) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[N];
    }


}
