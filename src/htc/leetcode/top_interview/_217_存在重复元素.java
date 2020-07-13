package htc.leetcode.top_interview;

import java.util.HashSet;
import java.util.Set;

/*
 * status:AC
 * TODO �������Žⷨ
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class _217_�����ظ�Ԫ�� {

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
