package htc.leetcode.other;

import java.util.Arrays;

/**
 * ����һ�������ƾ��� A����������ˮƽ��תͼ��Ȼ��תͼ�񲢷��ؽ����

ˮƽ��תͼƬ���ǽ�ͼƬ��ÿһ�ж����з�ת�����������磬ˮƽ��ת [1, 1, 0] �Ľ���� [0, 1, 1]��

��תͼƬ����˼��ͼƬ�е� 0 ȫ���� 1 �滻�� 1 ȫ���� 0 �滻�����磬��ת [0, 1, 1] �Ľ���� [1, 0, 0]��

 * 832 ����: [[1,1,0],[1,0,1],[0,0,0]] ���: [[1,0,0],[0,1,0],[1,1,1]]
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
