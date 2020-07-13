package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;
/*
 * AC
 * ����ָ����ƴ��
 * https://leetcode-cn.com/problems/partition-list
 */
public class _86_�ָ����� {
	public static void main(String[] args) {
		ListNodeUtil.print(partition(ListNodeUtil.str2Node("1->4->3->2->5->2"), 3));
		ListNodeUtil.print(partition(ListNodeUtil.str2Node("2->1->2"), 2));
		ListNodeUtil.print(partition(ListNodeUtil.str2Node("1->2->1->2"), 2));
	}

    //"����"ָ�룺lees��large
	public static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode less = new ListNode(-1);
		ListNode large = new ListNode(-1);

		ListNode lessHead = less;
		ListNode largeHead = large;
		while (head != null) {
			if (head.val < x) {
				less.next = head;
				less = head;
			} else {
				large.next = head;
				large = head;
			}
			head = head.next;
		}
		large.next = null;
		less.next = largeHead.next;
		return lessHead.next;
	}

	// ��
	@Deprecated
	public static ListNode partition2(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode preMin = new ListNode(-1);
		ListNode cur = head;
		ListNode pre = head;

		// ����ͷ�ڵ��Ǵ��ڵ��ڻ���С��
		if (head.val < x) {// С�ڣ�����preMin����ͷ�ڵ�
			preMin = head;
		}

		pre = cur;
		cur = cur.next;

		while (cur != null) {
			if (cur.val < x) {
				// ����ǰ�ڵ�ΪpreMin����һ�ڵ㣬����ǰ�ڵ��preMin���ڣ�
				// �ҵ�ǰ�ڵ�ֵҲС��x�����²������ƶ�
				if (cur == preMin.next) {
					preMin = cur;
					pre = cur;
					cur = cur.next;
					continue;
				}
				// С�ڷָ�ֵ�����뵽��һС��ֵ֮��

//				// 1.��¼��һ�ڵ�
//				ListNode curNext = cur.next;
//				pre.next = null;// �ϵ�next�ڵ㣬��ֹ������
//				// 2.��¼min����һ�ڵ�
//				ListNode minNext = preMin.next;
//				preMin.next = cur;
//				cur.next = minNext;
//				pre.next = curNext;
//				cur = curNext;

				ListNode curNext = cur.next;
				cur.next = pre;
				pre.next = curNext;
				preMin.next = cur;
				cur = curNext;

			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return head;
	}
}
