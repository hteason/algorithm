package htc.leetcode.other;

/**
 * 852. 山脉数组的峰顶索引 我们把符合下列属性的数组 A 称作山脉：
 * 
 * A.length >= 3 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] >
 * A[i+1] > ... > A[A.length - 1] 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] <
 * A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[0,1,0] 输出：1 示例 2：
 * 
 * 输入：[0,2,1,0] 输出：1
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

	// other 二分查找
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
