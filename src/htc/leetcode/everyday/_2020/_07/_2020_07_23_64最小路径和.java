package htc.leetcode.everyday._2020._07;

/**
 * AC
 * dp
 * 可优化思路:原地算法,操作grid原数组
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class _2020_07_23_64最小路径和 {
    public static void main(String[] args) {
        _2020_07_23_64最小路径和 test = new _2020_07_23_64最小路径和();
        System.out.println(test.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
        System.out.println(test.minPathSum(new int[][]{

        }));
        System.out.println(test.minPathSum(new int[][]{
                {}
        }));

    }

    /**
     * 整合版：dp
     */
    public int minPathSum(int[][] grid) {
        //可以不用判断
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 && j != 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                }
                if (j == 0 && i != 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }


    /**
     * 初版
     *
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        dp[1][1] = grid[0][0];

        for (int i = 1; i < dp.length; i++) {
            for (int j = (i == 1 ? 2 : 1); j < dp[i].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
