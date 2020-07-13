package htc.leetcode.dp;
/**
 * δAC
 * @author 86150
 *
 */
public class _746_ʹ����С������¥�� {
	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] { 0,1,1,1 }));
		System.out.println(minCostClimbingStairs(new int[] { 10, 15, 20 }));
		System.out.println(minCostClimbingStairs(
				new int[] { 11, 11, 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
	}

	/*
	 * �����һ��λ����ǰ������cost[i-1] = min(cost[i-1],cost[i-2])+cost[i];
	 */
	public static int minCostClimbingStairs(int[] cost) {
		if (cost.length == 2) {
			return Math.min(cost[0], cost[1]);
		} else if (cost.length == 3) {
			return Math.min(cost[0] + cost[2], cost[1]);
		}
		int len = cost.length;
		cost[len - 1] = Math.min(cost[len - 1], cost[len - 2]);
		int i;
		for (i = len - 1; i > 1; i--) {
			if (cost[i - 2] <= cost[i - 1]) {
				cost[i - 2] = cost[i] + cost[i - 2];
				i--;
			} else {
				cost[i - 1] = cost[i] + cost[i - 1];
			}
		}
		return cost[i];
	}
}
