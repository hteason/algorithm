package htc.leetcode.dp;

public class _198_¥Úº“ΩŸ…· {
	public static void main(String[] args) {
		System.out.println(rob(new int[] {}));
		System.out.println(rob(new int[] {2}));
		System.out.println(rob(new int[] {2,1}));
		System.out.println(rob(new int[] {2,1,1,2}));
		System.out.println(rob(new int[] {2,7,9,3,1}));
	}
    public static int rob(int[] nums) {
    	if (nums.length==0) {
			return 0;
		}if (nums.length==1) {
			return nums[0];
		}

		 nums[1]= Math.max(nums[0], nums[1]);
		
    	for (int i = 2; i < nums.length; i++) {
			nums[i] = Math.max(nums[i-2]+nums[i], nums[i-1]);
		}
    	return nums[nums.length-1];
    }
}
