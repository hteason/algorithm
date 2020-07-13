package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;
/*
 * TODO 尝试用双向链表实现
 * status:AC
 * https://leetcode-cn.com/problems/design-linked-list/
 */
public class _707_设计链表 {

	public static void main(String[] args) {

		ListNode doubleList;//TODO 使用双向链表
		
		MyLinkedList linkedList = new _707_设计链表().new MyLinkedList();
		linkedList.addAtHead(1);
		linkedList.addAtTail(3);
		linkedList.addAtIndex(1, 2); // 链表变为1-> 2-> 3
		System.out.println(linkedList.get(1)); // 返回2
		linkedList.deleteAtIndex(1); // 现在链表是1-> 3
		System.out.println(linkedList.get(1)); // 返回3
	}

	// 单链表，慢
	class MyLinkedList {

		ListNode head;
		int size;

		/** Initialize your data structure here. */
		public MyLinkedList() {
			head = new ListNode(-1);
		}

		/**
		 * Get the value of the index-th node in the linked list. If the index is
		 * invalid, return -1.
		 */
		public int get(int index) {
			ListNode node = node(index + 1);
			return node != null ? node.val : -1;
		}

		// 根据下标获取节点
		private ListNode node(int index) {
			ListNode element = head;
			for (int i = 0; element != null; i++) {
				if (i == index) {
					return element;
				}
				element = element.next;
			}
			return null;
		}

		public void print() {
			ListNodeUtil.print(head.next);
		}

		/**
		 * Add a node of value val before the first element of the linked list. After
		 * the insertion, the new node will be the first node of the linked list.
		 */
		public void addAtHead(int val) {
			addAtIndex(0, val);
		}

		/** Append a node of value val to the last element of the linked list. */
		public void addAtTail(int val) {
			addAtIndex(size, val);
		}

		/**
		 * Add a node of value val before the index-th node in the linked list. If index
		 * equals to the length of linked list, the node will be appended to the end of
		 * linked list. If index is greater than the length, the node will not be
		 * inserted.
		 */
		public void addAtIndex(int index, int val) {
			if (index < 0 || index > size) {
				return;
			}
			ListNode indexNode = node(index);
			ListNode newNode = new ListNode(val);
			ListNode next = indexNode.next;
			newNode.next = next;
			indexNode.next = newNode;
			indexNode = newNode;
			size++;
			print();
		}

		/** Delete the index-th node in the linked list, if the index is valid. */
		public void deleteAtIndex(int index) {
			if (index < 0 || index >= size) {
				return;
			}
			ListNode node = node(index);
			if (node == null || node.next == null) {
				return;
			}
			node.next = node.next.next;
			size--;
			print();
		}

	}

	/**
	 * Your MyLinkedList object will be instantiated and called as such:
	 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
	 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
	 * obj.deleteAtIndex(index);
	 */
}
