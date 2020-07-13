package htc.leetcode.other;

import java.util.Arrays;

public class ArrayPairSum561 {
	public static void main(String[] args) {
		System.out.println(arrayPairSum(new int[]{1,4,3,2}));
	}
    public static int arrayPairSum(int[] nums) {
    	int len = nums.length;
    	Arrays.sort(nums);
    	int res = 0;
        for (int i = 0; i < len; i+=2) {
			res += nums[i];
		}
    	return res;
    }
}
