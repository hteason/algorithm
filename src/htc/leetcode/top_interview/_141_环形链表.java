package htc.leetcode.top_interview;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

public class _141_ª∑–Œ¡¥±Ì {
	public static void main(String[] args) {
		System.out.println(hasCycle(ListNodeUtil.arr2Node(new int[] { 3, 2, 0, -4 })));
	}

	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			if (slow == fast) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}
}
