package htc.leetcode.everyday._2020._11;

import java.util.*;

/**
 *  AC
 *  TreeMapͳ�ƣ�TreeMap<ƽ���ͣ���б��ƽ�����б�>
 *     ȡǰK����
 *  https://leetcode-cn.com/problems/k-closest-points-to-origin/
 */
public class _09_973_��ӽ�ԭ���K���� {
    public static void main(String[] args) {
        _09_973_��ӽ�ԭ���K���� test = new _09_973_��ӽ�ԭ���K����();
        System.out.println(Arrays.deepToString(test.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(Arrays.deepToString(test.kClosest(
                new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }


    public int[][] kClosest(int[][] points, int K) {
        if (points.length == 1) {
            return points;
        }
        Map<Integer, List<int[]>> res = new TreeMap<>();
        for (int[] point : points) {
            int ans = point[0] * point[0] + point[1] * point[1];
            List<int[]> cur = res.getOrDefault(ans, new ArrayList<>());
            cur.add(point);
            res.put(ans, cur);
        }
        int i = 0;
        int[][] ans = new int[K][2];
        for (List<int[]> list : res.values()) {
            for (int[] xy : list) {
                ans[i][0] = xy[0];
                ans[i][1] = xy[1];
                i++;
                if (i == K) {
                    return ans;
                }
            }
        }
        return ans;
    }
}
