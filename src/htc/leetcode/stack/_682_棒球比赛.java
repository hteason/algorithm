package htc.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/*
 * AC
 * 内存消耗较大 TODO 不借助栈，纯数组模拟
 * https://leetcode-cn.com/problems/baseball-game
 */
public class _682_棒球比赛 {
	public static void main(String[] args) {
		System.out.println(calPoints(new String[] { "5", "2", "C", "D", "+" }));
		System.out.println(calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }));
	}

	public static int calPoints(String[] ops) {
		if (ops.length == 1) {
			return Integer.valueOf(ops[0]);
		}

		int res = 0;
		int pre;
		Deque<Integer> deque = new LinkedList<Integer>();
		for (String s : ops) {
			switch (s) {
			case "C":
				// 前一轮无效
				res -= deque.pop();
				break;

			case "D":
				// 前一轮加倍
				pre = deque.peek();
				deque.push(pre * 2);
				res += pre * 2;
				break;

			case "+":
				// 本轮为前两轮总和
				pre = deque.pop();
				int prepre = deque.peek();
				deque.push(pre);
				deque.push(pre + prepre);
				res += pre + prepre;
				break;

			default:
				// 数值
				deque.push(Integer.valueOf(s));
				res += Integer.valueOf(s);
				break;
			}
			/*
			 * if ("C".equals(s)) { // 前一轮无效 res -= deque.pop(); } else if ("D".equals(s)) {
			 * // 前一轮加倍 int pre = deque.peek(); deque.push(pre * 2); res += pre * 2; } else
			 * if ("+".equals(s)) { // 本轮为前两轮总和 int pre = deque.pop(); int prepre =
			 * deque.peek(); deque.push(pre); deque.push(pre + prepre); res += pre + prepre;
			 * } else { // 数值 deque.push(Integer.valueOf(s)); res += Integer.valueOf(s); }
			 */
		}

		return res;
	}
}
