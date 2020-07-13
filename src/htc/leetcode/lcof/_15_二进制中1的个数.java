package htc.leetcode.lcof;

/*
 * AC
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 */
public class _15_��������1�ĸ��� {
	public static void main(String[] args) {
		System.out.println(hammingWeight(Integer.valueOf("00000000000000000000000000001011", 2)));
		System.out.println(hammingWeight(Integer.valueOf("00000000000000000000000010000000", 2)));
//		System.out.println(hammingWeight(Integer.valueOf("11111111111111111111111111111101", 2)));
		System.out.println(hammingWeight(Integer.valueOf("00000000000000000000000000001000", 2)));
	}

	public static int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			// ������������һλ��1�Ļ�count+1��������0��+0(�൱�ڲ���)
			count += (n & 1);
			n = n >>> 1;
		}
		return count;
	}
}
