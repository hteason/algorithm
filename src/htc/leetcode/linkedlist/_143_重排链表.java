package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;
/*
 * status:AC
 * TODO 内存待优化：6.79%
 * https://leetcode-cn.com/problems/reorder-list
 */
public class _143_重排链表 {
	public static void main(String[] args) {
		ListNode head = ListNodeUtil.str2Node("1->2->3");
		reorderList(head);
		ListNodeUtil.print(head);

		head = ListNodeUtil.str2Node("1->2->3->4->5");
		reorderList(head);
		ListNodeUtil.print(head);
	}

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}

		ListNode slow = head;
		ListNode fast = head;
		// 获取中点位置
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		boolean odd = false;
		if (fast != null && fast.next == null) {
			// 奇数个节点，slow再前移一位
			odd = true;
			slow = slow.next;
		}

		// 将中点位置之后的节点使用头插法拼到新链表pre
		ListNode pre = new ListNode(-1);
		while (slow != null) {
			ListNode tmp = slow;
			slow = slow.next;
			ListNode preNext = pre.next;
			pre.next = tmp;
			tmp.next = preNext;
		}

		slow = head;
		fast = head;
		pre = pre.next;
		while (fast != null && fast.next != null) {
			ListNode slowNext = slow.next;
			ListNode preNext = pre.next;
			slow.next = pre;
			pre.next = slowNext;
			if (preNext == null) {
				// 中点后的逆序链表遍历结束时退出循环
				// 若节点数是奇数：slow前移2位;若节点数是偶数：slow前移1位
				slow = odd ? slow.next.next : slow.next;
				// 截断尾节点后的节点
				slow.next = null;
				break;
			}
			slow = slowNext;
			pre = preNext;
			fast = fast.next.next;
		}
	}
}
