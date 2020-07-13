package htc.leetcode.other;

public class _137SingleNumberII {
	//Î´Íê³É
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 2,2,3,2 }));
		System.out.println("----------");
		System.out.println(singleNumber(new int[] {0,1,0,1,0,1,99}));
		}
	
    public static int singleNumber(int[] nums) {
    	for (int i = 0,len = nums.length; i < len; i++) {
    		if(i==len-1) {
    			nums[0]+=nums[i];
    		}else {
        		nums[0] = nums[i]-nums[0];    			
    		}
			System.out.println(nums[0]);
		}
    	return nums[nums.length-1];
    }
}
