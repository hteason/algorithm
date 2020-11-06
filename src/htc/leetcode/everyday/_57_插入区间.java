package htc.leetcode.everyday;

import java.util.Arrays;

/**
 * FIXME NOT AC
 * @author huangtingcheng
 * @date 2020/11/4
 */
public class _57_插入区间 {
    public static void main(String[] args) {
        _57_插入区间 test = new _57_插入区间();
        int[][] ans1 = test.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        for (int[] ans : ans1) {
            System.out.println(Arrays.toString(ans));
        }

        ans1 = test.insert(new int[][]{{3, 4}}, new int[]{1, 2});
        for (int[] ans : ans1) {
            System.out.println(Arrays.toString(ans));
        }

        ans1 = test.insert(new int[][]{{3, 4}}, new int[]{1, 3});
        for (int[] ans : ans1) {
            System.out.println(Arrays.toString(ans));
        }

        ans1 = test.insert(new int[][]{{3, 4}}, new int[]{4, 5});
        for (int[] ans : ans1) {
            System.out.println(Arrays.toString(ans));
        }

        ans1 = test.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        for (int[] ans : ans1) {
            System.out.println(Arrays.toString(ans));
        }

        ans1 = test.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 7});
        for (int[] ans : ans1) {
            System.out.println(Arrays.toString(ans));
        }

        ans1 = test.insert(new int[][]{{1, 3}, {5, 7}, {8, 10}, {12, 16}}, new int[]{2, 6});
        for (int[] ans : ans1) {
            System.out.println(Arrays.toString(ans));
        }

        ans1 = test.insert(new int[][]{{1, 5}}, new int[]{2, 3});
        for (int[] ans : ans1) {
            System.out.println(Arrays.toString(ans));
        }

        ans1 = test.insert(new int[][]{{1, 5}}, new int[]{6, 8});
        for (int[] ans : ans1) {
            System.out.println(Arrays.toString(ans));
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }

        int left = newInterval[0];
        int right = newInterval[1];

        if (left<intervals[0][0] && right > intervals[intervals.length-1][1]){
            return new int[][]{{newInterval[0], newInterval[1]}};
        }

        int beginIndex = 0;
        int endIndex = 0;

        int len0 = intervals.length;
        if (intervals[0][0] >= right) {
            int[][] ans0;
            int begin = 0;
            if (intervals[0][0] > right) {
                ans0 = new int[len0 + 1][2];
                ans0[0][0] = left;
                ans0[0][1] = right;
            } else {
                begin = 1;
                ans0 = new int[len0][2];
                ans0[0][0] = left;
                ans0[0][1] = intervals[0][1];
            }
            for (int i = begin; i < intervals.length; i++) {
                ans0[i + 1][0] = intervals[i][0];
                ans0[i + 1][1] = intervals[i][1];
            }
            return ans0;
        }

        if (intervals[intervals.length - 1][1] <= left) {
            int[][] ans0;
            int end = 0;
            if (intervals[len0 - 1][1] == left) {
                ans0 = new int[len0][2];
            } else {
                end = 1;
                ans0 = new int[len0 + 1][2];
            }
            for (int i = 0; i < intervals.length; i++) {
                ans0[i][0] = intervals[i][0];
                ans0[i][1] = intervals[i][1];
            }
            int aa = len0 - end - 1;
            if (intervals[len0-1][1] == left) {
                ans0[len0-1][1] = right;
            }else {
                ans0[len0][0] = left;
                ans0[len0][1] = right;
            }
            return ans0;
        }

        for (int i = 0; i < intervals.length; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            if (left >= a && left <= b) {
                beginIndex = i;
            }
            if (right >= a && right <= b) {
                endIndex = i;
            }
        }

        int len = intervals.length - (endIndex - beginIndex);
        int[][] ans = new int[len][2];
        int i = 0;
        for (; i < beginIndex; i++) {
            ans[i][0] = intervals[i][0];
            ans[i][1] = intervals[i][1];
        }

        ans[i][0] = Math.min(intervals[beginIndex][0], left);
        ans[i][1] = Math.max(intervals[endIndex][1] ,right);

        i++;

        for ( int j = endIndex + 1; j < intervals.length; i++, j++) {
            ans[i][0] = intervals[j][0];
            ans[i][1] = intervals[j][1];
        }
        return ans;
    }
}
