package htc.leetcode.top_interview;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

/* 
 * status: AC
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class _21_合并两个有序链表 {

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

	// 简洁优化版
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);// 加虚拟头节点
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
		// l2还有元素，直接连接剩下的链表
		if (l2 != null) {
			ret.next = l2;
		}
		return head.next;
	}

	/*
	 * 执行用时 : 1 ms , 在所有 Java 提交中击败了 85.38% 的用户。 内存消耗 : 38 MB ,在所有 Java 提交中击败了47.60%
	 * 的用户
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
