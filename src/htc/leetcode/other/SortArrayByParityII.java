package htc.leetcode.other;

import java.util.Arrays;

/**
 * 922. ����ż�������� II
 * 
 * ����һ���Ǹ��������� A�� A ��һ��������������һ��������ż����
 * 
 * ��������������Ա㵱 A[i] Ϊ����ʱ��i Ҳ���������� A[i] Ϊż��ʱ�� i Ҳ��ż����
 * 
 * ����Է����κ���������������������Ϊ�𰸡�
 * 
 * ���룺[4,2,5,7] �����[4,5,2,7] ���ͣ�[4,7,2,5]��[2,5,4,7]��[2,7,4,5] Ҳ�ᱻ���ܡ�
 * 
 * @author HuangTingCheng
 *
 */
public class SortArrayByParityII {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortArrayByParityII2(new int[] { 4, 3, 3, 2, 5, 7 })));

	}

	public static int[] sortArrayByParityII(int[] A) {
		int o = 0;
		int j = 1;
		int[] res = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				res[o] = A[i];
				o += 2;
			} else {
				res[j] = A[i];
				j += 2;
			}
		}
		return res;
	}

	// other
	public static int[] sortArrayByParityII2(int[] A) {
		int j = 1;
		for (int i = 0; i < A.length - 1; i = i + 2) {
			if ((A[i] & 1) != 0) {
				while ((A[j] & 1) != 0) {
					j = j + 2;
				}
				int tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		return A;
	}
}
