package htc.leetcode.top_interview;

/* 
 * status:AC
 * FIXME:�ռ�89%���Ż�
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class _26_ɾ�����������е��ظ��� {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int len = removeDuplicates(nums);
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int len = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[len++] = nums[i];
			}
		}
		return len;
	}
}
