package htc.leetcode.everyday._2021._01;

/**
 * AC
 * https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
 *
 * @date 2021/1/17
 */
public class _17_1232_缀点成线 {
    public static void main(String[] args) {
        _17_1232_缀点成线 test = new _17_1232_缀点成线();
        System.out.println(test.checkStraightLine(new int[][]
                {{1, 2}, {2, 3}}
        ));
        System.out.println(test.checkStraightLine(new int[][]
                {{1, 2}, {2, 4}}
        ));
        System.out.println(test.checkStraightLine(new int[][]
                {{1, 2}, {2, 3}, {3, 5}}
        ));
        System.out.println(test.checkStraightLine(new int[][]
                {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}
        ));
        System.out.println(test.checkStraightLine(new int[][]
                {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}
        ));
        System.out.println(test.checkStraightLine(new int[][]
                {{0, 0}, {0, 1}, {0, -1}}
        ));
    }

    /**
     * 前两点求斜率和方程,然后每个点代入公式,公式成立则在同一线上
     */
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }
        int[] cur = coordinates[0];
        int[] next = coordinates[1];
        int x = next[0] - cur[0];
        int y = next[1] - cur[1];
        for (int i = 1; i < coordinates.length - 1; i++) {
            cur = coordinates[i];
            next = coordinates[i + 1];
            if (y * (next[0] - cur[0]) != x * (next[1] - cur[1])) {
                return false;
            }
        }
        return true;
    }
}
