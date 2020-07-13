package htc.leetcode.dp;
/*
 * AC
 * https://leetcode-cn.com/problems/three-steps-problem-lcci/
 */
public class 面试题_08_01_三步问题 {
	public static void main(String[] args) {
		System.out.println(waysToStep(1000000));
	}
    public static int waysToStep(int n) {
        long[] dp = new long[n+2];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for(int i = 3; i < n; i++){
            dp[i] = (dp[i-3]+dp[i-2]+dp[i-1])%1000000007;
        }
        return (int)dp[n-1];
    }
}
