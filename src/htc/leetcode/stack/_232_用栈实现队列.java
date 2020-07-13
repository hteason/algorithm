package htc.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
 * AC
 * https://leetcode-cn.com/problems/implement-queue-using-stacks
 */
public class _232_用栈实现队列 {
	public static void main(String[] args) {
		MyQueue2 queue = new _232_用栈实现队列().new MyQueue2();
		queue.push(1);
		queue.push(2);
		queue.peek(); // 返回 1
		queue.pop(); // 返回 1
		queue.push(3);
		queue.push(4);
		queue.peek(); // 返回 2
		queue.pop(); // 返回 2
		queue.empty(); // 返回 false

	}

	class MyQueue {

		/** Initialize your data structure here. */
		Stack<Integer> stack;// 新数据栈
		Stack<Integer> helper;// 协助栈

		public MyQueue() {
			stack = new Stack<>();
			helper = new Stack<>();
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			stack.push(x);
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			trans();
			return helper.pop();
		}

		/** Get the front element. */
		public int peek() {
			trans();
			return helper.peek();
		}

		/*
		 * 将stack栈的数据倒到helper栈，此时的helper栈的出栈顺序即队列的出队顺序
		 */
		private void trans() {
			if (helper.size() == 0) {
				while (!stack.isEmpty()) {
					helper.push(stack.pop());
				}
			}
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return stack.isEmpty() && helper.isEmpty();
		}
	}

	class MyQueue2 {

		/** Initialize your data structure here. */
		Deque<Integer> deque;

		public MyQueue2() {
			deque = new LinkedList<Integer>();
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			deque.add(x);// 将x入栈，添加到尾部
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			return deque.poll();// 删除并返回第一个压入的元素
		}

		/** Get the front element. */
		public int peek() {
			return deque.peekFirst();// 返回第一个入栈的元素
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return deque.isEmpty();
		}
	}

	/**
	 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
	 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
	 * obj.peek(); boolean param_4 = obj.empty();
	 */
}
