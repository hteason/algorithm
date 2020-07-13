package htc.leetcode.other;

import htc.leetcode.datatype.ListNode;

/**
 * 237 Definition for singly-linked list. public class ListNode { int val;
 * ListNode next; ListNode(int x) { val = x; } }
 */

public class DeleteNode {

	public static void main(String[] args) {
		ListNode node = new ListNode(4);
		node.next = new ListNode(5);
		node.next.next = new ListNode(1);
		node.next.next.next = new ListNode(9);
		
		deleteNode(node.next.next);
		
		while(node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
	
	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
}
