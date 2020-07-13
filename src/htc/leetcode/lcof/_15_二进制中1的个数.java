package htc.leetcode.lcof;

/*
 * AC
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 */
public class _15_二进制中1的个数 {
	public static void main(String[] args) {
		System.out.println(hammingWeight(Integer.valueOf("00000000000000000000000000001011", 2)));
		System.out.println(hammingWeight(Integer.valueOf("00000000000000000000000010000000", 2)));
//		System.out.println(hammingWeight(Integer.valueOf("11111111111111111111111111111101", 2)));
		System.out.println(hammingWeight(Integer.valueOf("00000000000000000000000000001000", 2)));
	}

	public static int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			// 如果二进制最后一位是1的话count+1，否则是0则+0(相当于不加)
			count += (n & 1);
			n = n >>> 1;
		}
		return count;
	}
}
