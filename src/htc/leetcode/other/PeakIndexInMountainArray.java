package htc.leetcode.other;

/**
 * 852. ɽ������ķ嶥���� ���ǰѷ����������Ե����� A ����ɽ����
 * 
 * A.length >= 3 ���� 0 < i < A.length - 1 ʹ��A[0] < A[1] < ... A[i-1] < A[i] >
 * A[i+1] > ... > A[A.length - 1] ����һ��ȷ��Ϊɽ�������飬�����κ����� A[0] < A[1] < ... A[i-1] <
 * A[i] > A[i+1] > ... > A[A.length - 1] �� i ��ֵ��
 * 
 * 
 * 
 * ʾ�� 1��
 * 
 * ���룺[0,1,0] �����1 ʾ�� 2��
 * 
 * ���룺[0,2,1,0] �����1
 * 
 * @author HuangTingCheng
 *
 */
public class PeakIndexInMountainArray {

	public static void main(String[] args) {
		System.out.println(peakIndexInMountainArray3(new int[] { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 }));
	}

	public static int peakIndexInMountainArray(int[] A) {
		int max = 0;
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];
				index = i;
			}
		}
		return index;
	}

	public static int peakIndexInMountainArray2(int[] A) {
		for (int i = 1; i < A.length - 1; i++) {
			if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
				return i;
			}
		}
		throw new RuntimeException();
	}

	// other ���ֲ���
	public static int peakIndexInMountainArray3(int[] A) {
		int l = 0, r = A.length - 1;
		while (l < r) {
			int m = (l + r) / 2;
			if (A[m - 1] < A[m] && A[m] > A[m + 1]) {
				return m;
			} else if (A[m - 1] < A[m]) {
				l = m;
			} else if (A[m] > A[m + 1]) {
				r = m;
			}
		}
		throw new RuntimeException();
	}
}
