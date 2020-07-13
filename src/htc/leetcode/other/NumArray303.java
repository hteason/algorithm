package htc.leetcode.other;

public class NumArray303 {

	static int[] sum;
	static int[][] index;

	public static void main(String[] args) {
		int[] arr = new int[] { -8261, 2300, -1429, 6274, 9650, -3267, 1414, -8102, 6251, -5979, -5291, -4616, -4703 };
		index = new int[][] { { 0, 8 }, { 4, 5 }, { 9, 11 }, { 2, 11 }, { 0, 12 }, { 9, 12 }, { 2, 5 }, { 0, 9 },
				{ 5, 9 }, { 0, 1 }, { 12, 12 }, { 6, 7 }, { 5, 8 }, { 1, 1 }, { 6, 7 }, { 10, 11 }, { 11, 12 },
				{ 7, 8 }, { 4, 11 }, { 8, 9 }, { 4, 11 }, { 2, 9 }, { 2, 6 }, { 11, 12 }, { 5, 8 }, { 11, 11 },
				{ 1, 9 }, { 12, 12 }, { 10, 10 }, { 4, 7 }, { 12, 12 }, { 8, 10 }, { 7, 9 }, { 4, 7 }, { 0, 7 },
				{ 8, 9 }, { 10, 12 }, { 0, 9 }, { 10, 12 }, { 7, 12 }, { 9, 9 }, { 0, 12 }, { 1, 3 }, { 8, 8 },
				{ 7, 10 } };
		NumArray303 n = new NumArray303(arr);
		for (int i = 0; i < index.length; i++) {
			System.out.println(index[i][0] + "," + index[i][1] + " : " + n.sumRange(index[i][0], index[i][1]));
		}
	}

	public NumArray303(int[] nums) {
		if (nums != null && nums.length != 0) {
			sum = new int[nums.length];
			sum[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				sum[i] = sum[i - 1] + nums[i];
			}
//			dp = new int[nums.length][nums.length];
//			dp[0][0] = nums[0];
//			for (int i = 0; i < nums.length; i++) {
//				for (int j = i+1; j < nums.length; j++) {
//					if(j==nums.length-1&&i<nums.length) {
//						dp[i+1][i+1] = nums[i+1];
//					}
//					dp[i][j] = dp[i][j - 1] + nums[j];
//				}
//			}
		}
	}

	public int sumRange(int i, int j) {
		return i == 0 ? sum[j] - 0 : sum[j] - sum[i - 1];
	}

	// other 巧妙解决了beginNum=0的情况👍
//	private int[] sum;
//    public NumArray(int[] nums) {
//        sum=new int[nums.length+1];
//        sum[0]=0;
//        for(int i =1;i<sum.length;i++) {
//        	sum[i]=sum[i-1]+nums[i-1];
//        }
//    }
//    
//    public int sumRange(int i, int j) {
//        return sum[j+1]-sum[i];
//    }

}
