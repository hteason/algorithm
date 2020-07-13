package htc.leetcode.top_interview;

import java.util.Arrays;

/*
 * status:AC
 * 时间100% 空间59%(无法优化)
 * https://leetcode-cn.com/problems/rotate-image/
 */
public class _48_旋转图像 {

	public static void main(String[] args) {
		rotate2(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		rotate2(new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } });
		print(new int[][] {});
	}

	/*
	 * 初始解法。
	 * 先交换对角位置的值，再镜像交换
	 */
	public static void rotate(int[][] matrix) {

		for (int i = 0, iLen = matrix.length - 1; i <= iLen; i++) {
			int[] js = matrix[i];
			for (int j = i + 1, jLen = js.length - 1; j <= jLen; j++) {
				matrix[i][j] ^= matrix[j][i];
				matrix[j][i] ^= matrix[i][j];
				matrix[i][j] ^= matrix[j][i];
			}
		}

		for (int i = 0, iLen = matrix.length - 1; i <= iLen; i++) {
			int[] js = matrix[i];
			for (int j = 0, jLen = js.length; j < jLen / 2; j++) {
				matrix[i][j] ^= matrix[i][jLen - j - 1];
				matrix[i][jLen - j - 1] ^= matrix[i][j];
				matrix[i][j] ^= matrix[i][jLen - j - 1];
			}
		}
	}

	/*
	 * 优化解法。 自外而内旋转，一次外循环为一层，一次内循环为交换对应位置的值，每次交换四个值，第一个值由临时变量保存，最好画图更清晰
	 */
	public static void rotate2(int[][] matrix) {
		for (int i = 0, len = matrix.length; i < len / 2; i++) {
			for (int j = i; j < len - i - 1; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[len - j - 1][i];
				matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
				matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
				matrix[j][len - i - 1] = tmp;
			}
		}
	}

	private static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println();
	}
}
