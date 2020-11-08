package htc.leetcode.everyday._2020._06;

import java.util.Arrays;
/**
 * AC
 * @author 86150
 *
 */
public class _2020_6_14_1300_转变数组后最接近目标值的数组和 {
	public static void main(String[] args) {
		System.out.println(findBestValue(new int[] { 9, 3 }, 10));
		System.out.println(findBestValue(new int[] { 4, 9, 3 }, 10));
		System.out.println(findBestValue(new int[] { 4, 9, 1, 3 }, 10));
		System.out.println(findBestValue(new int[] { 4, 2, 1, 3 }, 10));
		System.out.println(findBestValue(new int[] { 2, 3, 5 }, 10));
		System.out.println(findBestValue(
				new int[] { 60864, 25176, 27249, 21296, 11360 }, 56803));
		System.out.println(findBestValue(
				new int[] { 60864, 25176, 27249, 21296, 20204 }, 56803));
		System.out.println(findBestValue(
				new int[] { 48772, 52931, 14253, 32289, 75263 }, 40876));
	}

	public static int findBestValue(int[] arr, int target) {
		int len = arr.length;
		Arrays.sort(arr);
		int preSum = 0;
		int preTotal = 0;
		for (int i = 0; i < len; i++) {
			int curSum = preTotal + arr[i] * (len - i);
			if (curSum == target) {
				return arr[i];
			} else if (curSum > target) {
				if (curSum - target == target - preSum) {
					return arr[i - 1];
				} else {
					//后面的差值比前面的大，找到最合适的
					int taillen = (len - i);
					int a = (target - preTotal) / taillen;
					int b = (target - preTotal) / taillen + 1;
					int a1 = a * taillen + preTotal - target;
					int b1 = b * taillen + preTotal - target;
					int abs = Math.abs(target - preSum);
					int res = i == 0 ? 0 : arr[i - 1];

					if (Math.abs(a1) < abs) {
						res = a;
						abs = Math.abs(a1);
					}
					if (Math.abs(b1) < abs) {
						res = b;
					}
					return res;

				}
			} else {
				preSum = curSum;
				preTotal += arr[i];
			}
		}
		return arr[len - 1];
	}
}
