package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;
/*
 * AC
 * 分治指针再拼接
 * https://leetcode-cn.com/problems/partition-list
 */
public class _86_分隔链表 {
	public static void main(String[] args) {
		ListNodeUtil.print(partition(ListNodeUtil.str2Node("1->4->3->2->5->2"), 3));
		ListNodeUtil.print(partition(ListNodeUtil.str2Node("2->1->2"), 2));
		ListNodeUtil.print(partition(ListNodeUtil.str2Node("1->2->1->2"), 2));
	}

    //"分治"指针：lees，large
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

	// 弃
	@Deprecated
	public static ListNode partition2(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode preMin = new ListNode(-1);
		ListNode cur = head;
		ListNode pre = head;

		// 处理头节点是大于等于还是小于
		if (head.val < x) {// 小于，更新preMin虚拟头节点
			preMin = head;
		}

		pre = cur;
		cur = cur.next;

		while (cur != null) {
			if (cur.val < x) {
				// 若当前节点为preMin的下一节点，即当前节点和preMin相邻，
				// 且当前节点值也小于x，更新并继续移动
				if (cur == preMin.next) {
					preMin = cur;
					pre = cur;
					cur = cur.next;
					continue;
				}
				// 小于分隔值，插入到上一小于值之后

//				// 1.记录下一节点
//				ListNode curNext = cur.next;
//				pre.next = null;// 断掉next节点，防止环出现
//				// 2.记录min的下一节点
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
