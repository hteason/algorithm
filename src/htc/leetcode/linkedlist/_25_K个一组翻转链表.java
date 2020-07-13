package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

public class _25_K个一组翻转链表 {

	public static void main(String[] args) {
		ListNodeUtil.print(reverseKGroup(ListNodeUtil.str2Node("1->2->3->4->5"), 2));
//		ListNodeUtil.print(reverseKGroup(ListNodeUtil.str2Node("1->2->3->4->5"), 3));
//		ListNodeUtil.print(reverseKGroup(ListNodeUtil.str2Node("1->2->3->4->5"), 4));
//		ListNodeUtil.print(reverseKGroup(ListNodeUtil.str2Node("1->2->3->4->5"), 5));
	}

	//卒
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode pre = head;
		ListNode curr = head;
		ListNode nextNode = head.next;
		ListNode nextTmp = k==2?nextNode:nextNode.next;
		ListNode lastNext = head;
		for (int i = 0; i < k-1 && lastNext.next != null; i++) {
			lastNext = lastNext.next;
		}

		ListNode tmp = lastNext.next == null ? lastNext : lastNext.next;

		System.out.println(curr.val);
		System.out.println(nextNode.val);
		System.out.println(lastNext.val);
		System.out.println(tmp.val);

		for (int i = 0; i < k && nextTmp != tmp; i++) {
			nextNode.next = curr;
			if (i == 0) {
				pre = tmp;
			}
			curr = nextNode;
			nextNode = nextTmp;
			nextTmp = nextTmp.next;

			if (i == k - 1) {
				head.next = nextNode;
			}
		}

//		while (tmp != null) {
//
//		}

		return head;
	}
}
