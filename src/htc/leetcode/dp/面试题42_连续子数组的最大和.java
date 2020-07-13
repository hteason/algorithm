package htc.leetcode.dp;

/*
 * AC
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class 面试题42_连续子数组的最大和 {
	public int maxSubArray(int[] nums) {
		//贪心
		int preMax = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			preMax = Math.max(nums[i], preMax + nums[i]);
			max = Math.max(preMax, max);
		}
		return max;
	}

	public int maxSubArray_dp(int[] nums) {
		//dp
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] > 0) {
				nums[i] += nums[i - 1];
			}
			max = Math.max(nums[i], max);
		}
		return max;
	}
}
