package htc.leetcode.top_interview;

import java.util.Arrays;

/*
 * status:AC
 * TODO �Ż��ռ�44%
 * https://leetcode-cn.com/problems/plus-one
 */
public class _66_��һ {

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
				// ��λ��0�Ļ������˳��ˣ����治���
				break;
			}
		}
		// �������������н�λ(carryΪ1)����һ��λ���ټ�һ(carry)���൱�ڵ�-1������1��Ȼ����չ����Ų����һλ
		// ���ҿ϶�������λ�����������鳤��Ҳ��һ(carry������)
		digits[0] += carry;
		return Arrays.copyOf(digits, digits.length + carry);
	}

}
