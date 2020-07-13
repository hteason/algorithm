package htc.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;
/*
 * AC
 * ����ջ
 * https://leetcode-cn.com/problems/daily-temperatures
 */
public class _739_ÿ���¶� {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(dailyTemperatures(73, 74, 75, 71, 69, 72, 76, 73)));
	}

	// ����ջ
	public static int[] dailyTemperatures(int... T) {
		int[] res = new int[T.length];
		Stack<Integer> stack = new Stack<>();
		// �洢�±֪꣬���±�󼴿ɷ�����������,�����������
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
