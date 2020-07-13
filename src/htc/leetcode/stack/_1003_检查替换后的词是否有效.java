package htc.leetcode.stack;

import java.util.Stack;

/*
 * AC
 * https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions
 */
public class _1003_����滻��Ĵ��Ƿ���Ч {
	public static void main(String[] args) {
		System.out.println(isValid("aabcbc"));
		System.out.println(isValid("abcabcababcc"));
		System.out.println(isValid("abccba"));
		System.out.println(isValid("cababc"));
		System.out.println(isValid("abcabcaababccbcabcababcabcabc"));
	}

	// ������ʵ��
	public static boolean isValid(String S) {
		char[] s = S.toCharArray();
		char[] stack = new char[s.length];
		int index = 0;
		for (char cs : s) {
			if (cs != 'c') {
				stack[index++] = cs;
			} else {
				// ��ǰ�ַ���c,���ǰ�治��"ab"��,�϶���false
				if (index < 2 || stack[--index] != 'b' || stack[--index] != 'a') {
					return false;
				}
			}
		}
		return index == 0;
	}

	// ջʵ��
	public static boolean isValid_stack(String S) {
		Stack<Character> stack = new Stack<>();
		for (char cs : S.toCharArray()) {
			if (cs == 'a' || cs == 'b') {
				stack.push(cs);
			} else if (cs == 'c') {
				// ��ǰ�ַ���c,���ǰ�治��"ab"��,�϶���false
				if (stack.size() < 2 || stack.pop() != 'b' || stack.pop() != 'a') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	// ������Ͱ
	@Deprecated
	public static boolean isValid_diu(String S) {
		char[] cs = S.toCharArray();
		for (int i = 0, len = cs.length - 1; i < len;) {
			if (cs[i] == 'a' && cs[i + 1] == 'b' && cs[i + 2] == 'c') {
				i += 3;
			} else if (cs[i] == 'a' && cs[i + 1] == 'b' && cs[i + 2] != 'c') {
				if (cs[len] == 'c') {
					i += 2;
					len -= 1;
				} else {
					return false;
				}
			} else if (cs[i] == 'a' && cs[i + 1] != 'b' && cs[i + 2] != 'c') {
				if (cs[len - 1] == 'b' && cs[len] == 'c') {
					i += 1;
					len -= 2;
				}
			} else {
				return false;
			}
		}

		return true;
	}
}
