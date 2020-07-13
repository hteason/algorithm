package htc.leetcode.other;
/*
 * AC
 * https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer
 */
public class _1281_整数的各位积和之差 {
	public static void main(String[] args) {
		System.out.println(subtractProductAndSum(234));
		System.out.println(subtractProductAndSum(4421));
		System.out.println(subtractProductAndSum(523523));
	}

	public static int subtractProductAndSum(int n) {
		int multi = 1;
		int sum = 0;
		while (n > 0) {
			multi *= n % 10;
			sum += n % 10;
			n /= 10;
		}
		return multi - sum;
	}
}
