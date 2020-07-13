package htc.leetcode.other;

import java.util.Arrays;
/**
 * 985	
查询后的偶数和
 * @author HuangTingCheng
 *
 */
public class SumEvenAfterQueries {
public static void main(String[] args) {
	System.out.println(
			Arrays.toString(sumEvenAfterQueries(
					new int[] {1,2,3,4},
					new int[][] {{1,0},{-3,1},{-4,0},{2,3}})));
}
	public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int[] res = new int[A.length];
		int sum = 0;
		for (int j = 0; j < A.length; j++) {
			sum += A[j] % 2 == 0 ? A[j] : 0;
		}
		for (int i = 0; i < A.length; i++) {
			int bak = A[queries[i][1]];
			A[queries[i][1]] += queries[i][0];
			if (bak % 2 == 0 && A[queries[i][1]] % 2 == 0) {
				sum += queries[i][0];
			}else if (bak % 2 != 0 && A[queries[i][1]] % 2 == 0){
				sum +=  A[queries[i][1]];
			}else  if (bak % 2 == 0 && A[queries[i][1]] % 2 != 0) {
				sum -= bak;
			}
			res[i] = sum;
		}
		return res;
	}
}
