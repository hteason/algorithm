package htc.leetcode.other;

import java.util.Arrays;

/**
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。

水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。

反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

 * 832 输入: [[1,1,0],[1,0,1],[0,0,0]] 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 
 * @author HuangTingCheng
 *
 */
public class FlipAndInvertImage {
	public static void main(String[] args) {
		int[][] res = flipAndInvertImage2(new int[][] { 
			{ 1, 1, 0 }, 
			{ 1, 0, 1 },
			{ 0, 0, 0 } });
		// [1,0,0]
		// [0,1,0]
		// [1,1,1]

		for (int i = 0; i < res.length; i++) {
			System.out.println(Arrays.toString(res[i]));;
		}
	}

	public static int[][] flipAndInvertImage(int[][] A) {
		int[][] res = new int[A.length][A.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = A[i].length - 1; j >= 0; j--) {
				if (A[i][j] == 0) {
					res[i][A[i].length - 1 - j] = 1;
				} else {
					res[i][A[i].length - 1 - j] = 0;
				}
			}
		}
		return res;
	}

	public static int[][] flipAndInvertImage2(int[][] A) {
		int[][] res = new int[A.length][A.length];
		for (int i = 0; i < A.length; i++) {
			String str =new StringBuilder(Arrays.toString(A[i]))
					.reverse().toString();
			str = str.replace("[", "").replace("]", "")
			.replace("1", "2").replace("0", "1")
			.replace("2", "0").replace(",", "");
			String[] ss = str.split(" ");
			for (int k = 0; k<ss.length;k++) {
				res[i][k] = Byte.parseByte(ss[k]);
			} 
		}
		return res;
	}
}
