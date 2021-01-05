package htc.leetcode.everyday._2021._01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AC
 * https://leetcode-cn.com/problems/positions-of-large-groups/submissions/
 *
 * @date 2021/1/5
 */
public class _05_830_较大分组的位置 {
    public static void main(String[] args) {
        _05_830_较大分组的位置 test = new _05_830_较大分组的位置();
        System.out.println(test.largeGroupPositions("abbxxxxzzy"));
        System.out.println(test.largeGroupPositions("abc"));
        System.out.println(test.largeGroupPositions("ac"));
        System.out.println(test.largeGroupPositions("abbbbc"));
        System.out.println(test.largeGroupPositions("abcdddeeeeaabbbcd"));
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            int j = i;
            while (j < ss.length - 1 && ss[j] == ss[j + 1]) {
                j++;
            }
            if (j - i > 1) {
                ans.add(Arrays.asList(i, j));
            }
            i = j;
        }
        return ans;
    }
}
