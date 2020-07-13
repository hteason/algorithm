package htc.leetcode.top_interview;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

/* 
 * status: AC
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class _21_�ϲ������������� {

	public static void main(String[] args) {
		// 1->2->4
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(1);
		n1.next.next = new ListNode(2);

		// 1->3->4
		ListNode n2 = new ListNode(3);
		n2.next = new ListNode(4);
		n2.next.next = new ListNode(4);

		ListNodeUtil.print(mergeTwoLists(n1, n2));
	}

	// ����Ż���
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);// ������ͷ�ڵ�
		ListNode ret = head;
		while (l1 != null) {
			while (l2 != null && l1.val >= l2.val) {
				ListNode tmp = new ListNode(l2.val);
				ret.next = tmp;
				ret = ret.next;
				l2 = l2.next;
			}
			ListNode tmp = new ListNode(l1.val);
			ret.next = tmp;
			ret = ret.next;
			l1 = l1.next;
		}
		// l2����Ԫ�أ�ֱ������ʣ�µ�����
		if (l2 != null) {
			ret.next = l2;
		}
		return head.next;
	}

	/*
	 * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 85.38% ���û��� �ڴ����� : 38 MB ,������ Java �ύ�л�����47.60%
	 * ���û�
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head;
		if (l1.val < l2.val) {
			head = new ListNode(l1.val);
			l1 = l1.next;
		} else {
			head = new ListNode(l2.val);
			l2 = l2.next;
		}
		ListNode ret = head;
		while (l1 != null) {
			while (l2 != null && l1.val >= l2.val) {
				ListNode tmp = new ListNode(l2.val);
				ret.next = tmp;
				ret = tmp;
				l2 = l2.next;
			}
			ListNode tmp = new ListNode(l1.val);
			ret.next = tmp;
			ret = tmp;
			l1 = l1.next;
		}
		while (l2 != null) {
			ListNode tmp = new ListNode(l2.val);
			ret.next = tmp;
			ret = tmp;
			l2 = l2.next;
		}
		return head;
	}

}
