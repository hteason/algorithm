package htc.leetcode.everyday._2020._11;

import java.util.*;

/**
 * AC
 * TreeMap统计，可优化
 * https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 */
public class _17_1030_距离顺序排列矩阵单元格 {
    public static void main(String[] args) {
        _17_1030_距离顺序排列矩阵单元格 test = new _17_1030_距离顺序排列矩阵单元格();
        System.out.println(Arrays.deepToString(test.allCellsDistOrder(1, 2, 0, 0)));
        System.out.println(Arrays.deepToString(test.allCellsDistOrder(2, 2, 0, 1)));
        System.out.println(Arrays.deepToString(test.allCellsDistOrder(2, 3, 1, 2)));
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int r = r0 - i;
                int c = c0 - j;
                c = c < 0 ? -c : c;
                r = r < 0 ? -r : r;
                int dis = c + r;
                List<int[]> list = map.getOrDefault(dis, new ArrayList<>());
                list.add(new int[]{i, j});
                map.put(c + r, list);
            }
        }
        int[][] ans = new int[R * C][2];
        int index = 0;
        for (List<int[]> list : map.values()) {
            for (int[] ints : list) {
                ans[index++] = ints;
            }
        }
        return ans;
    }
}
