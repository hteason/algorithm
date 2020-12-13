package htc.leetcode.everyday._2020._12;

import java.util.HashSet;
import java.util.Set;

/**
 * AC
 * https://leetcode-cn.com/problems/contains-duplicate/
 *
 * @date 2020/12/13
 */
public class _13_217_´æÔÚÖØ¸´ÔªËØ {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;

    }
}
