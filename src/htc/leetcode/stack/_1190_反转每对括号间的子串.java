package htc.leetcode.stack;

import java.util.Stack;

public class _1190_反转每对括号间的子串 {
	public static void main(String[] args) {
//		System.out.println(reverseParentheses("(abcd)"));
//		System.out.println();
//		System.out.println(reverseParentheses("(u(love)i)"));
//		System.out.println();
//		System.out.println(reverseParentheses("(ed(et(oc))el)"));
//		System.out.println();
//		System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
	}

	public static String reverseParentheses(String s) {
		StringBuilder sb = new StringBuilder(s);

		Stack<Integer> stack = new Stack<>();
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '(') {
				stack.push(i);
			} else if (cs[i] == ')') {
				StringBuilder substring = new StringBuilder(s.substring(stack.peek() + 1, i));
//				System.out.println(substring.reverse());
//				sb.append(substring);
//				s.replace(substring, substring.reverse());
//				System.out.println(s);
//				sb.deleteCharAt(i);
//				sb.deleteCharAt(stack.peek());
			}
		}
		return sb.toString();
	}
}
