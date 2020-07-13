package htc.leetcode.other;

/**
 * ����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 * 
 * ʾ��:
 * 
 * ����: [-2,1,-3,4,-1,2,1,-5,4], ���: 6
 * 
 * ����: ���������� [4,-1,2,1] �ĺ����Ϊ 6�� ����:
 * 
 * ������Ѿ�ʵ�ָ��Ӷ�Ϊ O(n) �Ľⷨ������ʹ�ø�Ϊ����ķ��η���⡣
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
