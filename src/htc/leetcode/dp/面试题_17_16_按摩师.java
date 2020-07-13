package htc.leetcode.dp;

public class 面试题_17_16_按摩师 {
	public static void main(String[] args) {
		System.out.println(massage(new int[] { }));
		System.out.println(massage(new int[] { 1, 2, 3, 1 }));
		System.out.println(massage(new int[] { 2, 7, 9, 3, 1 }));
		System.out.println(massage(new int[] { 2, 1, 4, 5, 3, 1, 1, 3 }));
		System.out.println(
				massage(new int[] { 2, 1, 4, 5, 3, 11, 1, 3, 2, 3, 5, 7 }));
		System.out.println(massage(new int[] { 2, 1, 4, 5, 3, 11 }));
	}

	public static int massage(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		for (int i = 2; i < nums.length; i++) {
			nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
			nums[i - 1] = Math.max(nums[i - 1], nums[i - 2]);
		}
		return nums[nums.length - 1];
	}
}
