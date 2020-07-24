package htc.leetcode.everyday;

/**
 * AC
 * 其他实现思路：DP
 * https://leetcode-cn.com/problems/divisor-game/
 */
public class _2020_07_24_1025除数博弈 {
    public boolean divisorGame(int N) {
        return (N & 1) == 0;
    }
}
