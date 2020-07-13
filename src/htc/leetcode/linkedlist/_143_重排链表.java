package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;
/*
 * status:AC
 * TODO �ڴ���Ż���6.79%
 * https://leetcode-cn.com/problems/reorder-list
 */
public class _143_�������� {
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
		// ��ȡ�е�λ��
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		boolean odd = false;
		if (fast != null && fast.next == null) {
			// �������ڵ㣬slow��ǰ��һλ
			odd = true;
			slow = slow.next;
		}

		// ���е�λ��֮��Ľڵ�ʹ��ͷ�巨ƴ��������pre
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
				// �е������������������ʱ�˳�ѭ��
				// ���ڵ�����������slowǰ��2λ;���ڵ�����ż����slowǰ��1λ
				slow = odd ? slow.next.next : slow.next;
				// �ض�β�ڵ��Ľڵ�
				slow.next = null;
				break;
			}
			slow = slowNext;
			pre = preNext;
			fast = fast.next.next;
		}
	}
}
