package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
/*
 * status:AC
 * 内存待优化
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class _876_链表的中间结点 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		ListNode retListNode = middleNode(head);
		while (retListNode!=null) {
			System.out.println(retListNode.val);
			retListNode = retListNode.next;
		}
	}

	// 快慢指针
	public static ListNode middleNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}
