package htc.leetcode.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum2(new int[]{6,2, 7, 11, 15}, 9)));;
	}
	
	public static int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])) {
				return new int[] {map.get(target-nums[i]),i};
			}
			map.put(nums[i],i);
		}
		return new int[] {-1,-1};
	}
	
    public static int[] twoSum(int[] nums, int target) {
        int count = nums.length;
        int index[] = new int[100];
        int icount = 0;
        for(int i = 0 ; i < count; i++){
            for(int j = i ; j < count;j++){
                if(nums[i]+nums[j] == target){
                	index[icount++] = i;
                	index[icount++] = j;
                }
            }
        }
        int[] ret = Arrays.copyOf(index, icount);
        return ret;
    }
}