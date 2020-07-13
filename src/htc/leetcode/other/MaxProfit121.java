package htc.leetcode.other;

public class MaxProfit121 {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit(new int[] { 7,6,4,3,1 }));
		System.out.println(maxProfit(new int[] { 3,3 }));
		System.out.println(maxProfit(new int[] { 2,1,4 }));
		int todo;
	}
//
//	public static int maxProfit(int[] prices) {
//		int left = 0;
//		int right = prices.length - 1;
//		
//		int maxNum = Integer.MIN_VALUE;
//		int minNum = Integer.MAX_VALUE;
//		
//		while (left < right) {
//			if(prices[left] <= minNum) {
//				minNum = prices[left];
//			}
//			left++;
//
//			if(prices[right] >= maxNum) {
//				maxNum = prices[right];
//			}
//			right--;
//		}
//		if(maxNum == Integer.MIN_VALUE || minNum==Integer.MAX_VALUE) {
//			return 0;
//		}
//		return maxNum-minNum;
//	}

	// todo 深入理解
	public static int maxProfit(int[] prices) {
        if(prices==null||prices.length == 0){
            return 0;
        }
		int max = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i] - min);
		}
		return max;
	}
}
