package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

public class _328_奇偶链表 {
	public static void main(String[] args) {
//		ListNodeUtil.print(oddEvenList(ListNodeUtil.str2Node("1->2->3->4->5")));
	}

	//卒
	public static ListNode oddEvenList(ListNode head) {
		// 节点数小于等于2时直接返回，此时已符合分组规则
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		while (slow != null && slow.next != null) {

			if (fast != null) {
				//奇数位交换
				int tmp = slow.val;
				slow.val = fast.val;
				fast.val = tmp;
				fast = fast.next != null ? fast = fast.next.next : fast.next;
			} else {
				//还原相对位置
//				int tmp = slow.val;
//				slow.val = slow.next.val;
//				slow.next.val = tmp;
			}
			slow = slow.next;
		}

		return head;
	}
}
