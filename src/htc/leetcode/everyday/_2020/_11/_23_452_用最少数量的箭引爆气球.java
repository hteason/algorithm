package htc.leetcode.everyday._2020._11;

import java.util.Arrays;

/**
 * AC
 * ����+�ϲ�����
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
 * @date 2020/11/23
 */
public class _23_452_�����������ļ��������� {
    public static void main(String[] args) {
        _23_452_�����������ļ��������� test = new _23_452_�����������ļ���������();
        System.out.println(test.findMinArrowShots(new int[][]{
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        }));
        System.out.println(test.findMinArrowShots(new int[][]{
                {1, 2}, {3, 4}, {5, 6}, {7, 8}
        }));
        System.out.println(test.findMinArrowShots(new int[][]{
                {1, 2}, {0, 4}, {1, 3}
        }));
        System.out.println(test.findMinArrowShots(new int[][]{
                {-2147483646, -2147483645}, {2147483646, 2147483647}
        }));
    }

    /**
     * 1. ���±�0����������
     * 2. ������1��ʼ����,��ǰһ�����н���ʱ�ϲ��������䲢���뵱ǰ����
     * 3. ��ǰ�����ǰһ����������û�н���ʱ������һ
     */
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (p1, p2) -> p1[0] > p2[0] ? 1 : -1);
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            int[] p1 = points[i - 1];
            int[] p2 = points[i];
            if (p2[0] <= p1[1]) {
                points[i][0] = Math.max(p2[0], p1[0]);
                points[i][1] = Math.min(p2[1], p1[1]);
            } else {
                count++;
            }
        }
        return count;
    }
}
