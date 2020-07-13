package htc.leetcode.other;

import java.util.Stack;

public class _155MinStack {
	//TODO ¸¨ÖúÕ»£¬from net Î´Íê³É
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());// --> Returns -3.
		minStack.pop();
		System.out.println(minStack.top());// --> Returns 0.
		System.out.println(minStack.getMin());// --> Returns -2.
	}

}

class MinStack {

	Stack<Integer> helper = new Stack<>();
	Stack<Integer> stack = new Stack<>();

	public MinStack() {

	}

	public void push(int x) {
		if (helper.isEmpty() || helper.peek() > x) {
			helper.push(x);
		} else {
			helper.push(helper.peek());
		}
		stack.push(x);
	}

	public void pop() {
		stack.pop();
		helper.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return helper.peek();
	}
}