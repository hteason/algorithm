package htc.leetcode.other;
/**
 * 476. 数字的补数
给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。

注意:

给定的整数保证在32位带符号整数的范围内。
你可以假定二进制数不包含前导零位。
示例 1:

输入: 5
输出: 2
解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
示例 2:

输入: 1
输出: 0
解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
 * @author HuangTingCheng
 *
 */
public class FindComplement {
	public static void main(String[] args) {
		System.out.println(findComplement3(5));// 
	}

	public static int findComplement(int num) {
		int tmp = num;
		for (int i = 0; tmp != 0; i++) {
			num = num ^ (1 << i);
			tmp &= (tmp - 1);
		}
		return num;
	}

	// TODO unfinished
	public static int findComplement2(int num) {
		int tmp = num;
		for (int i = 0; tmp != 0; i++) {
			num = (num & (1 << i)) == 1 ? num & (~(1 << i)) : num | (1 << i);
			tmp &= ~(1 << i);
		}
		return num;
	}

	// other 右移temp统计位数，位数变量c每位都设为1，再与num异或 
	//	101^111 -> 010
	public static int findComplement3(int num) {
		int temp = num, c = 0;
		while (temp > 0) {
			temp >>= 1;
			c = (c << 1) + 1;
		}
		return num ^ c;
	}
}
