package htc.leetcode.other;
/*
 * AC
 * https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits
 */
public class _1295_统计位数为偶数的数字 {
	public static void main(String[] args) {
		System.out.println(findNumbers(12, 345, 2, 6, 7896));
		System.out.println(findNumbers(555, 901, 482, 1771));
	}

	public static int findNumbers(int... nums) {
		int ans = 0;
		int count = 0;
		for (int n : nums) {
			while (n > 0) {
				n /= 10;
				count++;
			}
			if ((count & 1) == 0) {
				ans++;
			}
			count = 0;
		}

		return ans;
	}
}
