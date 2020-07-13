package htc.leetcode.other;

import htc.leetcode.datatype.ListNode;

import htc.leetcode.datatype.ListNode;

public class _206ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next =  new ListNode(3);
		head.next.next.next =  new ListNode(4);
		head.next.next.next.next =  new ListNode(5);
		
		ListNode ln = reverseList(head);
		if(ln!=null) {
			System.out.println(ln.val);
			ln=ln.next;
		}
	}

    public static ListNode reverseList(ListNode head) {
        if(head==null) {
        	return head;
        }
        int val = head.val;
        head.next = reverseList(head.next);
        return head;
    }
}
