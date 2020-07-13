package htc.leetcode.stack;

import java.util.Stack;
/*
 * AC
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii
 */
public class _1209_删除字符串中的所有相邻重复项_II {
	public static void main(String[] args) {
		System.out.println(removeDuplicates("abcd", 2));
		System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
		System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
	}

	public static String removeDuplicates(String s, int k) {
		char[] ss = s.toCharArray();
		int index = 0;
		char[] chStack = new char[ss.length];
		int[] numStack = new int[ss.length];
		for (char ch : ss) {
			// 栈为空或者ch和栈顶元素不相同，入栈，并初始化连续出现数量为1
			if (index == 0 || chStack[index - 1] != ch) {
				chStack[index] = ch;
				numStack[index++] = 1;
			} else if (chStack[index - 1] == ch) {
				// 字符栈顶元素已连续出现k-1次，且加上当前字符后满足连续k个，2个栈顶都出栈
				if (numStack[index - 1] + 1 == k) {
					index--;
				} else {
					// 与字符栈顶元素相同但未满足k，计数栈栈顶加1
					numStack[index - 1]++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < index; i++) {
			for (int j = 0; j < numStack[i]; j++) {
				sb.append(chStack[i]);
			}
		}
		return sb.toString();
	}

	// 栈实现
	public static String removeDuplicates_stack(String s, int k) {
		Stack<Character> chStack = new Stack<>();
		Stack<Integer> numStack = new Stack<>();
		for (char ch : s.toCharArray()) {
			// 栈为空或者ch和栈顶元素不相同，入栈，并初始化连续出现数量为1
			if (chStack.isEmpty() || chStack.peek() != ch) {
				chStack.push(ch);
				numStack.push(1);
			} else if (chStack.peek() == ch) {
				// 字符栈顶元素已连续出现k-1次，且加上当前字符后满足连续k个，2个栈顶都出栈
				if (numStack.peek() + 1 == k) {
					numStack.pop();
					chStack.pop();
				} else {
					// 与字符栈顶元素相同但未满足k，计数栈栈顶加1
					numStack.push(numStack.pop() + 1);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!numStack.isEmpty()) {
			int repeat = numStack.pop();
			char repeatCh = chStack.pop();
			for (int i = 0; i < repeat; i++) {
				sb.insert(0, repeatCh);
			}
		}
		return sb.toString();
	}

}
