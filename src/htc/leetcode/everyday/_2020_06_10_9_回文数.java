package htc.leetcode.everyday;
/**
 * AC
 *
 */
public class _2020_06_10_9_»ØÎÄÊı {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		if (x < 10) {
			return true;
		}
		int z = 0;
		for (int y = x; y != 0; y /= 10) {
			z = y % 10 + z * 10;
		}
		return x == z;
	}
}
