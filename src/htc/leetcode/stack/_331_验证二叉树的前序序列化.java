package htc.leetcode.stack;

import java.util.Stack;

/*
 * AC
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 */
public class _331_验证二叉树的前序序列化 {
	public static void main(String[] args) {
		System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
		System.out.println(isValidSerialization("1,#"));
		System.out.println(isValidSerialization("9,#,#,1"));
		System.out.println(isValidSerialization("#"));
	}

	// 数组实现(略有提升)  42.80%  44.72%  10ms	36.7 MB
	public static boolean isValidSerialization(String preorder) {
		String[] s = preorder.split(",");
		if (s.length == 1 && "#".equals(s[0])) {
			return true;
		}
		String[] stack = new String[s.length];
		int index = 0;
		for (int i = 0; i < s.length; i++) {
			if (index == 0) {
				stack[index++] = s[i];
			} else if ("#".equals(s[i])) {
				while (index != 0 && "#".equals(stack[index - 1])) {
					index--;
					if (index == 0) {
						return false;
					}
					index--;
				}
				if (i != s.length - 1) {
					stack[index++] = "#";
				}
			} else {
				stack[index++] = s[i];
			}
		}
		return index == 0;
	}

	// 栈实现 慢 22% 5%  14ms	38.1 MB
	public static boolean isValidSerialization_stack(String preorder) {
		String[] s = preorder.split(",");
		if (s.length == 1 && "#".equals(s[0])) {
			return true;
		}
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < s.length; i++) {
			if (stack.isEmpty()) {
				stack.push(s[i]);
			} else if ("#".equals(s[i])) {
				while (!stack.isEmpty() && "#".equals(stack.peek())) {
					stack.pop();
					if (stack.isEmpty()) {
						return false;
					}
					stack.pop();
				}
				if (i != s.length - 1) {
					stack.push("#");
				}
			} else {
				stack.push(s[i]);
			}
		}
		return stack.isEmpty();
	}
}
