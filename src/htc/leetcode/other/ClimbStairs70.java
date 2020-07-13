package htc.leetcode.other;

/**
 * 70 ��¥��
 * 
 * ������������¥�ݡ���Ҫ n ������ܵ���¥����
 * 
 * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
 * 
 * ע�⣺���� n ��һ����������
 * 
 * ʾ�� 1��
 * 
 * ���룺 2 ����� 2 ���ͣ� �����ַ�����������¥���� 1. 1 �� + 1 �� 2. 2 �� ʾ�� 2��
 * 
 * ���룺 3 ����� 3 ���ͣ� �����ַ�����������¥���� 1. 1 �� + 1 �� + 1 �� 2. 1 �� + 2 �� 3. 2 �� + 1 ��
 * 
 * @author HuangTingCheng
 *
 */
public class ClimbStairs70 {
	public static void main(String[] args) {
		System.out.println(climbStairs(21));
	}

	public static int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
