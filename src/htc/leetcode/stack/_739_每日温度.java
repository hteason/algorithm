package htc.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;
/*
 * AC
 * 单调栈
 * https://leetcode-cn.com/problems/daily-temperatures
 */
public class _739_每日温度 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(dailyTemperatures(73, 74, 75, 71, 69, 72, 76, 73)));
	}

	// 单调栈
	public static int[] dailyTemperatures(int... T) {
		int[] res = new int[T.length];
		Stack<Integer> stack = new Stack<>();
		// 存储下标，知道下标后即可访问数组数据,方便计算距离差
		for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				res[stack.peek()] = i - stack.peek();
				stack.pop();
			}
			stack.push(i);
		}

		return res;
	}
}
