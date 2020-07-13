package htc.leetcode.stack;

import java.util.Stack;
/*
 * AC
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 */
public class _150_逆波兰表达式求值 {
	public static void main(String[] args) {
		System.out.println(evalRPN("2", "1", "+", "3", "*"));
		System.out.println(evalRPN("4", "13", "5", "/", "+"));
		System.out.println(evalRPN("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"));
	}

	// 纯数组模拟栈实现
	public static int evalRPN(String... tokens) {
		int[] numStack = new int[tokens.length / 2 + 1];
		int index = 0;
		for (String s : tokens) {
			switch (s) {
			case "+":
				numStack[index - 2] += numStack[--index];
				break;
			case "-":
				numStack[index - 2] -= numStack[--index];
				break;
			case "*":
				numStack[index - 2] *= numStack[--index];
				break;
			case "/":
				numStack[index - 2] /= numStack[--index];
				break;
			default:
				numStack[index++] = Integer.parseInt(s);
				break;
			}
		}
		return numStack[0];
	}

	// 栈实现
	public static int evalRPN_stack(String... tokens) {
		Stack<Integer> numStack = new Stack<>();
		Integer op1, op2;
		for (String s : tokens) {
			switch (s) {
			case "+":
				op2 = numStack.pop();
				op1 = numStack.pop();
				numStack.push(op1 + op2);
				break;
			case "-":
				op2 = numStack.pop();
				op1 = numStack.pop();
				numStack.push(op1 - op2);
				break;
			case "*":
				op2 = numStack.pop();
				op1 = numStack.pop();
				numStack.push(op1 * op2);
				break;
			case "/":
				op2 = numStack.pop();
				op1 = numStack.pop();
				numStack.push(op1 / op2);
				break;
			default:
				numStack.push(Integer.valueOf(s));
				break;
			}
		}
		return numStack.pop();
	}
}
