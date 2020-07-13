package htc.leetcode.everyday;

/**
 * AC https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * 
 * @author 86150
 *
 */
public class _2020_6_9_������46_�����ַ�����ַ��� {
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
			//��λ��,ֻ������һ�ַ��뷨
			return 1;
		}
		char[] nums = String.valueOf(num).toCharArray();
		//dp[i]����ǰi�����ܹ��ж����ַ��뷽��
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int n = (nums[0] - '0') * 10 + (nums[1] - '0');
		//�����ʼֵ,�ڶ�λ���͵�һλ����ɵ����ֽ���(9,26)֮��,�����ַ���
		//����ɵ�����0~9�����25��ֻ����һ�ַ���
		dp[1] = n > 9 && n < 26 ? 2 : 1;

		for (int i = 2; i < nums.length; i++) {
			//���㵱ǰ����ǰһ������ɵ���ֵ��С,��1225���±�3��������ǰһ������ɵ�ֵΪ25
			n = (nums[i - 1] - '0') * 10 + (nums[i] - '0');
			if (n > 9 && n < 26) {
				//�����ֵ����(9,26)��Χ��,��ɷ���ķ�����Ϊǰ�������ķ����ܺ�
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				//�����ֵ����(9,26)��Χ�ڣ���ֻ����һ�ַ���,��ǰһ�����ܷ���ķ�����һ��
				dp[i] = dp[i - 1];
			}
		}
		return dp[nums.length - 1];
	}

	public static int translateNum1(int num) {
		if (num < 10) {
			//��λ��,ֻ������һ�ַ��뷨
			return 1;
		}
		char[] nums = String.valueOf(num).toCharArray();
		//�洢���ϸ����ķ�����
		int prepre = 1;
		int n = (nums[0] - '0') * 10 + (nums[1] - '0');
		//�洢�ϸ����ķ�����,�ڶ�λ���͵�һλ����ɵ����ֽ���(9,26)֮��,�����ַ���
		//����ɵ�����0~9�����25��ֻ����һ�ַ���
		int pre = n > 9 && n < 26 ? 2 : 1;

		for (int i = 2; i < nums.length; i++) {
			//���㵱ǰ����ǰһ������ɵ���ֵ��С,��1225���±�3��������ǰһ������ɵ�ֵΪ25
			n = (nums[i - 1] - '0') * 10 + (nums[i] - '0');
			if (n > 9 && n < 26) {
				//�����ֵ����(9,26)��Χ��,��ɷ���ķ�����Ϊǰ�������ķ����ܺ�
				int tmppre = pre;
				pre = pre + prepre;
				prepre = tmppre;
			}
			//���������ֵ����(9,26)��Χ�ڣ���ֻ����һ�ַ���,��ǰһ�����ܷ���ķ�����һ��
			//����Ҫ������һ���������ϸ���
			else {
				prepre  = pre;
			}
		}
		return pre;
	}
}
