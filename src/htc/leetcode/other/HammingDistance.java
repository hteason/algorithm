package htc.leetcode.other;

/**
 * 461. 汉明距离 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 
 * 注意： 0 ≤ x, y < 231.
 * 
 * 示例:
 * 
 * 输入: x = 1, y = 4
 * 
 * 输出: 2
 * 
 * 解释: 1 (0 0 0 1) 4 (0 1 0 0) ↑ ↑
 * 
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class HammingDistance {

	public static void main(String[] args) {
		System.out.println(hammingDistance3(3, 4));
		// 011
		// 100
	}

	// 逐位对照
	public static int hammingDistance(int x, int y) {
		int count = 0;
		int bak = x > y ? x : y;
		for (int i = 0; bak != 0; i++) {
			if ((x & (1 << i)) != (y & (1 << i))) {
				count++;
			}
			bak &= ~(1 << i);
		}
		return count;
	}

	// 异或，统计1的个数
	public static int hammingDistance2(int x, int y) {
		int count = 0;
		int bak = x ^ y;
		while( bak != 0) {
			bak &= (bak - 1);
			count++;
		}
		return count;
	}
	// 调用Integer类库
	public static int hammingDistance3(int x, int y) {
		return Integer.bitCount(x^y);
	}
}
