package htc.leetcode.top_interview;

import java.util.Stack;

/*
 * status:AC
 * TODO 待优化时空 99.23% - 85.26%
 * https://leetcode-cn.com/problems/valid-parentheses
 */
public class _20_有效的括号 {

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("[()]"));
		System.out.println(isValid("["));
		System.out.println(isValid("]"));
	}

	public static boolean isValid(String s) {
		char[] cs = s.toCharArray();

		Stack<Character> stack = new Stack<>();
		for (char c : cs) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '[') {
				stack.push(']');
			} else if (c == '{') {
				stack.push('}');
			} else if (!stack.isEmpty()) {
				if (stack.pop() != c) {
					return false;
				}
			} else {
				return false;
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}
}
