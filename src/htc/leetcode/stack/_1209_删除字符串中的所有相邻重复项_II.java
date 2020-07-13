package htc.leetcode.stack;

import java.util.Stack;
/*
 * AC
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii
 */
public class _1209_ɾ���ַ����е����������ظ���_II {
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
			// ջΪ�ջ���ch��ջ��Ԫ�ز���ͬ����ջ������ʼ��������������Ϊ1
			if (index == 0 || chStack[index - 1] != ch) {
				chStack[index] = ch;
				numStack[index++] = 1;
			} else if (chStack[index - 1] == ch) {
				// �ַ�ջ��Ԫ������������k-1�Σ��Ҽ��ϵ�ǰ�ַ�����������k����2��ջ������ջ
				if (numStack[index - 1] + 1 == k) {
					index--;
				} else {
					// ���ַ�ջ��Ԫ����ͬ��δ����k������ջջ����1
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

	// ջʵ��
	public static String removeDuplicates_stack(String s, int k) {
		Stack<Character> chStack = new Stack<>();
		Stack<Integer> numStack = new Stack<>();
		for (char ch : s.toCharArray()) {
			// ջΪ�ջ���ch��ջ��Ԫ�ز���ͬ����ջ������ʼ��������������Ϊ1
			if (chStack.isEmpty() || chStack.peek() != ch) {
				chStack.push(ch);
				numStack.push(1);
			} else if (chStack.peek() == ch) {
				// �ַ�ջ��Ԫ������������k-1�Σ��Ҽ��ϵ�ǰ�ַ�����������k����2��ջ������ջ
				if (numStack.peek() + 1 == k) {
					numStack.pop();
					chStack.pop();
				} else {
					// ���ַ�ջ��Ԫ����ͬ��δ����k������ջջ����1
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
