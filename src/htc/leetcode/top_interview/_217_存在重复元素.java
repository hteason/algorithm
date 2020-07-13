package htc.leetcode.top_interview;

import java.util.HashSet;
import java.util.Set;

/*
 * status:AC
 * TODO 看懂最优解法
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class _217_存在重复元素 {

	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[]{1,2,3,1}));
	}
	
    public static boolean containsDuplicate(int[] nums) {
    	Set<Integer> set = new HashSet<>(nums.length);
        for (int num:nums) {
			if (!set.add(num)) {
				return true;
			}
		}
    	return false;
    }
}
