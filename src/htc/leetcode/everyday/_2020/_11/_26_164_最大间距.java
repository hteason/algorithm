package htc.leetcode.everyday._2020._11;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @date 2020/11/26
 */
public class _26_164_最大间距 {
    public static void main(String[] args) {
        _26_164_最大间距 test = new _26_164_最大间距();
        System.out.println(test.maximumGap(new int[]{3, 6, 9, 1}));
        System.out.println(test.maximumGap(new int[]{10}));
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Iterator<Integer> iterator = set.iterator();
        int max = 0;
        Integer pre = iterator.next();
        while (iterator.hasNext()) {
            Integer cur = iterator.next();
            int ans = cur - pre;
            pre = cur;
            max = ans > max ? ans : max;
        }
        return max;
    }
}
