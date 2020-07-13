package htc.leetcode.stack;

import java.util.Stack;

/*
 * TODO �Ż�
 * AC
 * https://leetcode-cn.com/problems/decode-string
 */
public class _394_�ַ������� {
	public static void main(String[] args) {
		int TODO;
//		System.out.println(decodeString("3[a]2[bc]"));
//		System.out.println(decodeString("3[a2[c2[d]]]"));
//		System.out.println(decodeString("2[abc]3[cd]ef"));
//		System.out.println(decodeString("333[agf2[a2[tgrdfg4[ds]]]]20[bc]"));
	}

	// �� 12.25%��24.78%
	public static String decodeString(String s) {
		Stack<Integer> numStack = new Stack<>();
		Stack<Character> chStack = new Stack<>();
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] >= '0' || cs[i] <= '9') {
				// ��ȡ�ظ���ֵ
				int num = 0;
				// ��ֵ����һ����[
				while (cs[i] != '[') {
					num = num * 10 + (cs[i] - '0');
					i++;
				}
				numStack.push(num);
				chStack.push('[');
			} else if (cs[i] == ']') {
				StringBuilder str = new StringBuilder();
				// ��[�ϵ��ַ�ȫ��ջ������ƴ���ַ���
				while (!chStack.isEmpty() && chStack.peek() != '[') {
					str.append(chStack.pop());
				}
				chStack.pop();// ����[
				// ����Ҫ�ظ�������ֵ��ջ��ѭ��ѹ��ջ��
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
