package htc.leetcode.other;

import java.util.Arrays;

public class _283_MoveZeroes {

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 0, 3, 12 };
		moveZeroes(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void moveZeroes(int[] nums) {
		for (int i = 0; i < nums.length;i++ ) {
			if (nums[i] == 0) {
				int j = i + 1;
				while (j < nums.length && nums[j] == 0) {
					j++;
				}
				if (j >= nums.length) {
					return;
				}
				nums[i] = nums[j];
				nums[j] = 0;
			}
		}
	}
}
