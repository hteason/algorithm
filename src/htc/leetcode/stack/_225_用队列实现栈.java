package htc.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/*
 *AC
 *˫��������ת��ÿ��pop��top��ʱ�临�Ӷ�ΪO(n)
 *https://leetcode-cn.com/problems/implement-stack-using-queues
 */
public class _225_�ö���ʵ��ջ {

	public static void main(String[] args) {
		MyStack2 myStack = new _225_�ö���ʵ��ջ().new MyStack2();
		myStack.push(1);
		myStack.push(2);
		System.out.println(myStack.top());
		System.out.println(myStack.pop());
		System.out.println(myStack.top());
		System.out.println(myStack.pop());
		System.out.println(myStack.top());
		System.out.println(myStack.pop());
		System.out.println(myStack.empty());
	}

	class MyStack {

		Queue<Integer> queue;
		Queue<Integer> helper;

		/** Initialize your data structure here. */
		public MyStack() {
			queue = new LinkedList<>();
			helper = new LinkedList<>();
		}

		/** Push element x onto stack. */
		public void push(int x) {
			queue.add(x);
		}

		/**
		 * Removes the element on top of the stack and returns that element.
		 * 
		 * @throws IllegalAccessException
		 */
		public int pop() {
			return getAndRemoveTop();
		}

		private int getAndRemoveTop() {
			if (!queue.isEmpty()) {
				// ������ת��helper����queue���һ��ֵ����
				while (queue.size() > 1) {
					helper.add(queue.poll());
				}
				return queue.poll();
			} else {
				// ������ת��queue����queue���һ��ֵ����
				while (helper.size() > 1) {
					queue.add(helper.poll());
				}
				return helper.poll();
			}
		}

		/** Get the top element. */
		public int top() {
			int peek = getAndRemoveTop();
			// �Żض���
			if (queue.isEmpty()) {
				helper.add(peek);
			} else {
				queue.add(peek);
			}
			return peek;
		}

		/** Returns whether the stack is empty. */
		public boolean empty() {
			return queue.isEmpty() && helper.isEmpty();
		}
	}

	// ������ʵ��
	class MyStack2 {

		Queue<Integer> queue;

		/** Initialize your data structure here. */
		public MyStack2() {
			queue = new LinkedList<>();
		}

		/** Push element x onto stack. */
		public void push(int x) {
			queue.add(x);
		}

		/**
		 * Removes the element on top of the stack and returns that element.
		 * 
		 * @throws IllegalAccessException
		 */
		public int pop() {
			return shift();
		}

		private int shift() {
			int size = queue.size();
			while (size-- > 1) {
				// ���裺�ݴ��С,��ͷ��β
				queue.add(queue.poll());
			}
			return queue.poll();
		}

		/** Get the top element. */
		public int top() {
			int peek = shift();
			// �Żض���
			queue.add(peek);
			return peek;
		}

		/** Returns whether the stack is empty. */
		public boolean empty() {
			return queue.isEmpty();
		}
	}
	/**
	 * Your MyStack object will be instantiated and called as such: MyStack obj =
	 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */
}
