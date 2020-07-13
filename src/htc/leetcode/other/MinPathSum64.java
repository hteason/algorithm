package htc.leetcode.other;

public class MinPathSum64 {
	public static void main(String[] args) {
		System.out.println(new int[][] { 
			{ 1, 3, 1 }, 
			{ 1, 5, 1 },
			{ 4, 2, 1 } });
	}
	

	public static int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0) {
			return 0;
		}
		int[][] dp = new int[grid.length][grid.length];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				
			}
		}
		
		return 99999;
	}
}
