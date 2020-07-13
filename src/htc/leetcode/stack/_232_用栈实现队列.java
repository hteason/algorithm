package htc.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
 * AC
 * https://leetcode-cn.com/problems/implement-queue-using-stacks
 */
public class _232_��ջʵ�ֶ��� {
	public static void main(String[] args) {
		MyQueue2 queue = new _232_��ջʵ�ֶ���().new MyQueue2();
		queue.push(1);
		queue.push(2);
		queue.peek(); // ���� 1
		queue.pop(); // ���� 1
		queue.push(3);
		queue.push(4);
		queue.peek(); // ���� 2
		queue.pop(); // ���� 2
		queue.empty(); // ���� false

	}

	class MyQueue {

		/** Initialize your data structure here. */
		Stack<Integer> stack;// ������ջ
		Stack<Integer> helper;// Э��ջ

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
		 * ��stackջ�����ݵ���helperջ����ʱ��helperջ�ĳ�ջ˳�򼴶��еĳ���˳��
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
			deque.add(x);// ��x��ջ����ӵ�β��
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			return deque.poll();// ɾ�������ص�һ��ѹ���Ԫ��
		}

		/** Get the front element. */
		public int peek() {
			return deque.peekFirst();// ���ص�һ����ջ��Ԫ��
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
