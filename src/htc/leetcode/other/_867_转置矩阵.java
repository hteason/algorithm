package htc.leetcode.other;

public class _867_×ªÖÃ¾ØÕó {

	public static void main(String[] args) {
		System.out.println(transpose(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
		System.out.println(transpose(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));
	}

	public static int[][] transpose(int[][] A) {
		int[][] ans = new int[A[0].length][A.length];
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				ans[i][j] = A[j][i];
			}
		}
		return ans;
	}
}
