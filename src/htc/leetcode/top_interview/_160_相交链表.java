package htc.leetcode.top_interview;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

public class _160_œ‡Ωª¡¥±Ì {
	public static void main(String[] args) {
//		ListNodeUtil.print(ListNodeUtil.arr2Node(getIntersectionNode(new int[] {4,1,8,4,5}, headB)));
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}
}
