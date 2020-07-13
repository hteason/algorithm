package htc.leetcode.other;

import java.util.Arrays;

public class SortedSquares {
	public static void main(String[] args) {
		
	}
	public static int[] sortedSquares(int[] A) {
		for (int i = 0; i < A.length; i++) {
			A[i] *= A[i];
		}
		Arrays.sort(A);
		return A;
	}
}
