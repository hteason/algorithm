package htc.leetcode.everyday;
/*
 * AC
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class _2020_4_18_11_盛最多水的容器 {
	//暴力
	public int maxArea(int[] height) {
		int max = 0;
		for (int i = 0, len = height.length; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
			}
		}
		return max;
	}
}
