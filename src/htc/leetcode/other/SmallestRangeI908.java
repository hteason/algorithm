package htc.leetcode.other;

public class SmallestRangeI908 {
	public static void main(String[] args) {
		int unfinish;
		System.out.println(smallestRangeI(new int[] { 1, 3, 6 }, 3));
	}
	//TODO unfinish
	public static int smallestRangeI(int[] A, int K) {
		int len = A.length;
		if (len == 1) {
			return 0;
		}
		int leftMax = Integer.MIN_VALUE;
		int rightMin = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			leftMax = leftMax > A[i] - K ? leftMax : A[i] - K;
			rightMin = rightMin < A[i] + K ? rightMin : A[i] + K;
		}
		System.out.println(leftMax + " " + rightMin);
		return -9999;
	}
}
