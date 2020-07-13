package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

public class _61_旋转链表 {
	public static void main(String[] args) {
		ListNodeUtil.print(rotateRight(ListNodeUtil.str2Node("1->2->3->4->5"), 0));
		ListNodeUtil.print(rotateRight(ListNodeUtil.str2Node("1->2->3->4->5"), 11));
		ListNodeUtil.print(rotateRight(ListNodeUtil.str2Node("0->1->2"), 4));
		ListNodeUtil.print(rotateRight(ListNodeUtil.str2Node("1->2"), 1));
	}

	// 完全遍历
	// 构造环形链表
	// 截断尾部
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}
		ListNode dummy = head;
		int len = 0;
		// 从头到尾遍历链表并记录链表长度len
		while (head.next != null) {
			len++;
			head = head.next;
		}
		len++;

		// 计算需要移动多少位，主要解决k大于len的情况
		if (k > len) {
			// 当k大于链表长度时，先对k%len，得到尾节点距离开始节点多少个单位长度
			len = len - k % len - 1;
		} else if (k==len) {
			// 移动位数为0时直接返回原链表
			return dummy;
		}else {
			// 当k小于链表长度len时，直接移动len-k-1位
			len = len - k - 1;
		}

		//构造环形链表，即尾部指向头部
		head.next = dummy;
		head = dummy;
		//通过len寻找新链表的尾部
		for (int i = 0; i < len; i++) {
			head = head.next;
		}

		//新链表尾部的next就是head
		dummy = head.next;
		//断开环形链表，使其形成单向链表
		head.next = null;
		//返回新链表的头部
		return dummy;
	}

}
