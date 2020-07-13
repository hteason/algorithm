package htc.leetcode.other;

import java.util.HashMap;
import java.util.Map;
/**
 * 961
 * @author HuangTingCheng
 *
 */
public class RepeatedNTimes {
	public static void main(String[] args) {
		System.out.println(repeatedNTimes(new int[] { 5, 1, 5, 2, 5, 3, 5, 4 }));
	}

	public static int repeatedNTimes(int[] A) {
		int times = A.length / 2;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (map.containsKey(A[i])) {
				int time = map.get(A[i]) + 1;
				if (time == times) {
					return A[i];
				} else {
					map.put(A[i], time);
				}
			} else {
				map.put(A[i], 1);
			}
		}
		return -1;
	}

	public static int repeatedNTimes2(int[] A) {
		int[] res = new int[10001];
		int len = A.length;
		int times = len / 2;
		for (int i = 0; i < len; i++) {
			if (times == res[A[i]] + 1) {
				return A[i];
			}
			res[A[i]]++;
		}
		return 0;
	}
	public static int repeatedNTimes3(int[] A) {
		int[] res = new int[10001];
		for (int i = 0; i < A.length; i++) {
			if (res[A[i]]!=0) {
				return A[i];
			}
			res[A[i]]++;
		}
		return 0;
	}
}
