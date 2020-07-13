package htc.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
/*
 * AC
 * 用LinkedList代替Stack，快了好多
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 */
public class _1047_删除字符串中的所有相邻重复项 {
	public static void main(String[] args) {
		System.out.println(removeDuplicates("abbaca"));
		System.out.println(removeDuplicates("aa"));
	}

	public static String removeDuplicates(String S) {
		StringBuilder sb = new StringBuilder();

		Deque<Character> stack = new LinkedList<>();
		for (char c : S.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			}else {
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pollLast());
		}

		return sb.toString();
	}
}
