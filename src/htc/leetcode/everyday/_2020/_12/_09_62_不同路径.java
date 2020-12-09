package htc.leetcode.everyday._2020._12;

/**
 * AC
 * dp解法,太大数自测不过,但能过用例,应该是系统问题
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * @date 2020/12/9
 */
public class _09_62_不同路径 {
    public static void main(String[] args) {
        _09_62_不同路径 test = new _09_62_不同路径();
        System.out.println(test.uniquePaths(3, 7));
        System.out.println(test.uniquePaths(3, 2));
        System.out.println(test.uniquePaths(7, 3));
        System.out.println(test.uniquePaths(3, 3));
        System.out.println(test.uniquePaths(1, 3));
        System.out.println(test.uniquePaths(23, 52));
    }

    //dp
    public int uniquePaths(int m, int n) {
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = i == 0 || j == 0 ? 1 : a[i - 1][j] + a[i][j - 1];
            }
        }
        return a[m - 1][n - 1];
    }
}
