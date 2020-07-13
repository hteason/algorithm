package htc.leetcode.stack;

import java.util.Stack;

/*
 * TODO 优化
 * AC
 * https://leetcode-cn.com/problems/decode-string
 */
public class _394_字符串解码 {
	public static void main(String[] args) {
		int TODO;
//		System.out.println(decodeString("3[a]2[bc]"));
//		System.out.println(decodeString("3[a2[c2[d]]]"));
//		System.out.println(decodeString("2[abc]3[cd]ef"));
//		System.out.println(decodeString("333[agf2[a2[tgrdfg4[ds]]]]20[bc]"));
	}

	// 慢 12.25%、24.78%
	public static String decodeString(String s) {
		Stack<Integer> numStack = new Stack<>();
		Stack<Character> chStack = new Stack<>();
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] >= '0' || cs[i] <= '9') {
				// 获取重复数值
				int num = 0;
				// 数值后面一定是[
				while (cs[i] != '[') {
					num = num * 10 + (cs[i] - '0');
					i++;
				}
				numStack.push(num);
				chStack.push('[');
			} else if (cs[i] == ']') {
				StringBuilder str = new StringBuilder();
				// 把[上的字符全出栈并逆序拼接字符串
				while (!chStack.isEmpty() && chStack.peek() != '[') {
					str.append(chStack.pop());
				}
				chStack.pop();// 弹出[
				// 把需要重复的数量值出栈，循环压入栈中
				Integer repeatTime = numStack.pop();
				while (repeatTime-- > 0) {
					for (int j = 0, len = str.length(); j < len; j++) {
						chStack.push(str.charAt(len - j - 1));
					}
				}
			} else {
				chStack.push(cs[i]);
			}
		}
		StringBuilder ans = new StringBuilder();
		while (!chStack.isEmpty()) {
			ans.append(chStack.pop());
		}
		return ans.reverse().toString();
	}
}
