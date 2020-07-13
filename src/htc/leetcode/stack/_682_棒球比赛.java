package htc.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/*
 * AC
 * �ڴ����Ľϴ� TODO ������ջ��������ģ��
 * https://leetcode-cn.com/problems/baseball-game
 */
public class _682_������� {
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
				// ǰһ����Ч
				res -= deque.pop();
				break;

			case "D":
				// ǰһ�ּӱ�
				pre = deque.peek();
				deque.push(pre * 2);
				res += pre * 2;
				break;

			case "+":
				// ����Ϊǰ�����ܺ�
				pre = deque.pop();
				int prepre = deque.peek();
				deque.push(pre);
				deque.push(pre + prepre);
				res += pre + prepre;
				break;

			default:
				// ��ֵ
				deque.push(Integer.valueOf(s));
				res += Integer.valueOf(s);
				break;
			}
			/*
			 * if ("C".equals(s)) { // ǰһ����Ч res -= deque.pop(); } else if ("D".equals(s)) {
			 * // ǰһ�ּӱ� int pre = deque.peek(); deque.push(pre * 2); res += pre * 2; } else
			 * if ("+".equals(s)) { // ����Ϊǰ�����ܺ� int pre = deque.pop(); int prepre =
			 * deque.peek(); deque.push(pre); deque.push(pre + prepre); res += pre + prepre;
			 * } else { // ��ֵ deque.push(Integer.valueOf(s)); res += Integer.valueOf(s); }
			 */
		}

		return res;
	}
}
