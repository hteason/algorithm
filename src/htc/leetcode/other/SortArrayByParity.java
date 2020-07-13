package htc.leetcode.other;

import java.util.Arrays;

/**
 * 905
 * 
 * 输入：[3,1,2,4] 输出：[2,4,3,1] 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * 
 * 
 * @author HuangTingCheng
 *
 */
public class SortArrayByParity {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				sortArrayByParity2(new int[] { 3, 1, 2, 4 })
				));
	}

	public static int[] sortArrayByParity(int[] A) {
		int l = 0;
		int r = A.length - 1;
		int[] res = new int[r + 1];
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				res[l++] = A[i];
			} else {
				res[r--] = A[i];
			}
		}
		return res;
	}

	public static int[] sortArrayByParity2(int[] A) {
		int l = 0;
		int r = A.length - 1;
		while (l < r) {
			if (A[l] % 2 == 1 && A[r] %2 == 0) {
				int tmp = A[l];
				A[l] = A[r];
				A[r] = tmp;
			} else if(A[l] % 2 == 0){
				l++;
			}else {
				r--;
			}
		}
		return A;
	}
}
