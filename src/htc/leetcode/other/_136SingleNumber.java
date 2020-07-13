package htc.leetcode.other;

public class _136SingleNumber {

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 2, 2, 1 }));
		System.out.println(singleNumber(new int[] {4,1,2,1,2 }));
	}
	//异或实现：位值相同为0，不同为1

	public static int singleNumber(int[] nums) {
		for (int i = 0, len = nums.length; i < len-1; i++) {
			nums[i+1] =nums[i]^nums[i+1];
		}
		return nums[nums.length-1];
	}
}
