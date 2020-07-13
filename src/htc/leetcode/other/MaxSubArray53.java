package htc.leetcode.other;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6
 * 
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 * @author HuangTingCheng
 *
 */
public class MaxSubArray53 {
	public static void main(String[] args) {
		int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray1(nums));
		int todo;
	}

	public static int maxSubArray(int[] nums) {
		int[][] dp = new int[nums.length][nums.length];
		for (int i = 0; i < dp.length; i++) {
			dp[0][i] = nums[i];
		}
		for (int i = 0; i < dp.length - 1; i++) {
			for (int j = 1; j < dp.length; j++) {
				dp[i + 1][j] = Math.max(dp[i][j - 1], nums[j] + dp[i][j - 1]);
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		return 999999999;
	}

	// other
	public static int maxSubArray1(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int ans = dp[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}
}
