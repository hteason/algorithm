package htc.leetcode.everyday._2021._01;

import java.util.ArrayList;
import java.util.List;

/**
 * AC
 * https://leetcode-cn.com/problems/summary-ranges/
 *
 * @date 2021/1/10
 */
public class _10_228_汇总区间 {
    public static void main(String[] args) {
        _10_228_汇总区间 test = new _10_228_汇总区间();
        System.out.println(test.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(test.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(test.summaryRanges(new int[]{}));
        System.out.println(test.summaryRanges(new int[]{-1}));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int begin = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            ans.add(begin != nums[i] ? begin + "->" + nums[i] : String.valueOf(begin));
        }
        return ans;
    }
}
