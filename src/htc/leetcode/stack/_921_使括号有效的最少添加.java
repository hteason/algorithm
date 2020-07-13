package htc.leetcode.stack;

import java.util.Stack;
/*
 * AC
 * TODO 无栈实现
 * https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/
 */
public class _921_使括号有效的最少添加 {
	public static void main(String[] args) {
//		System.out.println(minAddToMakeValid("(()"));
//		System.out.println(minAddToMakeValid("())"));
//		System.out.println(minAddToMakeValid("((("));
//		System.out.println(minAddToMakeValid(")))"));
//		System.out.println(minAddToMakeValid("()"));
//		System.out.println(minAddToMakeValid("()))(("));
//		System.out.println(minAddToMakeValid("()()"));
		System.out.println(minAddToMakeValid("(()())(("));
	}

	public static int minAddToMakeValid(String S) {
		int count = 0;
		for (char c : S.toCharArray()) {

		}
		return count;
	}

	// 无栈实现：垃圾代码！
	@Deprecated
	public static int minAddToMakeValid_diu(String S) {
		int count = 0;
		char[] c = S.toCharArray();
		for (int i = 0, pre = i - 1; i < c.length; i++) {
			if (c[i] == '(') {
				count = count < 0 ? -count + 1 : count + 1;
				pre = i;
			} else if (c[i] == ')') {
				if (pre > -1 && c[pre] == '(') {
					pre--;
					count--;
				} else {
					count++;
				}
			}
		}
		return count;
	}

	// 栈实现，过慢
	public static int minAddToMakeValid_stack(String S) {
		Stack<Character> stack = new Stack<>();
		for (char c : S.toCharArray()) {
			if (stack.isEmpty() || c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
		}
		System.out.println(stack);
		return stack.size();
	}
}
