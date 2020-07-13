package htc.leetcode.top_interview;
/*
 * status:AC
 * TODO 太慢了
 * https://leetcode-cn.com/problems/count-primes/
 */
public class _204_计数质数 {

	public static void main(String[] args) {
		System.out.println(countPrimes(10000));
	}

	/*
	 * 慢
	 */
	public static int countPrimes(int n) {
		int cnt = 0;
		int a[] = new int[n];
		for (int i = 2; i < n; i++) {
			if (a[i] == 0) {
				cnt++;
				a[i]=1;
				for (int j = i + i; j < n; j += i) {
					a[j] = 1;
				}
			}
		}
		return cnt;
	}
}
