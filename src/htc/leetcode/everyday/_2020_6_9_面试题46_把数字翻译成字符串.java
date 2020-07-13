package htc.leetcode.everyday;

/**
 * AC https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * 
 * @author 86150
 *
 */
public class _2020_6_9_面试题46_把数字翻译成字符串 {
	public static void main(String[] args) {
		System.out.println(translateNum(506));
		System.out.println(translateNum(18580));
		System.out.println(translateNum(26));
		System.out.println(translateNum(12));
		System.out.println(translateNum(4321));
		System.out.println(translateNum(12258));
		System.out.println(translateNum(18822));
		System.out.println("----------");
		System.out.println(translateNum1(506));
		System.out.println(translateNum1(18580));
		System.out.println(translateNum1(26));
		System.out.println(translateNum1(12));
		System.out.println(translateNum1(4321));
		System.out.println(translateNum1(12258));
		System.out.println(translateNum1(18822));
	}

	public static int translateNum(int num) {
		if (num < 10) {
			//个位数,只可能有一种翻译法
			return 1;
		}
		char[] nums = String.valueOf(num).toCharArray();
		//dp[i]代表前i个数总共有多少种翻译方法
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int n = (nums[0] - '0') * 10 + (nums[1] - '0');
		//计算初始值,第二位数和第一位数组成的数字介于(9,26)之间,有两种翻译
		//若组成的数是0~9或大于25则只能有一种翻译
		dp[1] = n > 9 && n < 26 ? 2 : 1;

		for (int i = 2; i < nums.length; i++) {
			//计算当前数和前一个数组成的数值大小,如1225的下标3的数和它前一个数组成的值为25
			n = (nums[i - 1] - '0') * 10 + (nums[i] - '0');
			if (n > 9 && n < 26) {
				//组成数值处于(9,26)范围内,则可翻译的方法数为前两个数的翻译总和
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				//组成数值不在(9,26)范围内，则只能算一种翻译,和前一个数能翻译的方法数一样
				dp[i] = dp[i - 1];
			}
		}
		return dp[nums.length - 1];
	}

	public static int translateNum1(int num) {
		if (num < 10) {
			//个位数,只可能有一种翻译法
			return 1;
		}
		char[] nums = String.valueOf(num).toCharArray();
		//存储上上个数的翻译数
		int prepre = 1;
		int n = (nums[0] - '0') * 10 + (nums[1] - '0');
		//存储上个数的翻译数,第二位数和第一位数组成的数字介于(9,26)之间,有两种翻译
		//若组成的数是0~9或大于25则只能有一种翻译
		int pre = n > 9 && n < 26 ? 2 : 1;

		for (int i = 2; i < nums.length; i++) {
			//计算当前数和前一个数组成的数值大小,如1225的下标3的数和它前一个数组成的值为25
			n = (nums[i - 1] - '0') * 10 + (nums[i] - '0');
			if (n > 9 && n < 26) {
				//组成数值处于(9,26)范围内,则可翻译的方法数为前两个数的翻译总和
				int tmppre = pre;
				pre = pre + prepre;
				prepre = tmppre;
			}
			//否则组成数值不在(9,26)范围内，则只能算一种翻译,和前一个数能翻译的方法数一样
			//不需要更新上一个数和上上个数
			else {
				prepre  = pre;
			}
		}
		return pre;
	}
}
