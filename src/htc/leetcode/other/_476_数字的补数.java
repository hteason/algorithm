package htc.leetcode.other;
/*
 * AC
 * https://leetcode-cn.com/problems/number-complement
 */
public class _476_Êý×ÖµÄ²¹Êý {

	public static void main(String[] args) {
		System.out.println(findComplement(23532453));
		System.out.println(findComplement(1));
	}

	public static int findComplement(int num) {
		int answer = 0;
		int[] map = { 1, 0 };
		long pow2 = 1;
		while (num != 0) {
			answer += map[num % 2] * pow2;
			pow2 = pow2 * 2;
			num /= 2;
		}
		return answer;
	}
}
