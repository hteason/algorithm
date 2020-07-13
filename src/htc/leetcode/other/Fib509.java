package htc.leetcode.other;
/**
 * 斐波那契
 * @author HuangTingCheng
 *
 */
public class Fib509 {
	public static void main(String[] args) {
		System.out.println(fib(3000));
	}
	//备忘录解法
	static int[] a = new int[31];
	public static int fib(int N) {
		if(a[N]!=0) {
			return a[N];
		}
		if (N == 0 || N == 1) {
			return N;
		}
		return a[N] = fib(N - 1) + fib(N - 2);
	}
}
