package htc.leetcode.top_interview;

import java.util.Stack;

/*
 * status:AC
 * TODO 链表实现
 * https://leetcode-cn.com/problems/min-stack/
 */
public class _155_最小栈 {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-1);

		System.out.println(minStack.getMin());

		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
}

class MinStack {

	// 两个维护栈
	Stack<Integer> stack1;// 原数据栈
	Stack<Integer> stack2;// 最小数据栈

	public MinStack() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void push(int x) {
		if (stack1.isEmpty()) {
			stack2.push(x);
		} else {
			Integer min = stack2.peek();
			stack2.push(x < min ? x : min);
		}
		stack1.push(x);
	}

	public void pop() {
		stack1.pop();
		stack2.pop();
	}

	public int top() {
		return stack1.peek();
	}

	public int getMin() {
		return stack2.peek();

	}
}