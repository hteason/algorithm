package htc.leetcode.top_interview;

import java.util.Arrays;

/*
 * status:AC
 * TODO 优化空间44%
 * https://leetcode-cn.com/problems/plus-one
 */
public class _66_加一 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 3 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 9, 9, 9 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 8, 8, 9 })));
	}

	public static int[] plusOne(int[] digits) {
		int carry = 1;

		for (int i = digits.length - 1; i >= 0; i--) {
			int add = digits[i] + carry;
			digits[i] = add % 10;
			carry = add / 10;
			if (carry == 0) {
				// 进位是0的话可以退出了，后面不会变
				break;
			}
		}
		// 如果计算完后仍有进位(carry为1)，第一个位置再加一(carry)，相当于第-1个数加1，然后扩展并后挪数组一位
		// 并且肯定会提升位数，则新数组长度也加一(carry个长度)
		digits[0] += carry;
		return Arrays.copyOf(digits, digits.length + carry);
	}

}
