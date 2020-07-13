package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

/*
 * status：AC
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class _19_删除链表的倒数第N个节点 {
	public static void main(String[] args) {
		ListNodeUtil.print(removeNthFromEnd(ListNodeUtil.str2Node("1->2->3->4->5"), 1));
		ListNodeUtil.print(removeNthFromEnd(ListNodeUtil.str2Node("1->2->3->4->5"), 2));
		ListNodeUtil.print(removeNthFromEnd(ListNodeUtil.str2Node("1->2->3->4->5"), 3));
		ListNodeUtil.print(removeNthFromEnd(ListNodeUtil.str2Node("1->2->3->4->5"), 4));
		ListNodeUtil.print(removeNthFromEnd(ListNodeUtil.str2Node("1->2->3->4->5"), 5));
		ListNodeUtil.print(removeNthFromEnd(ListNodeUtil.str2Node("1->2->3->4->5"), 6));
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		//删除索引下标大于等于总长度-1时，默认删除第一个元素
		//索引下标最大值=链表长度-1
		return remove(head, head.next, n, 0) < n  ? head.next : head;
	}

	private static int remove(ListNode pre, ListNode head, int n, int backIndex) {
		if (head == null) {
			return backIndex;
		}
		backIndex = 1 + remove(head, head.next, n, backIndex);
		if (backIndex == n) {
			// 丢弃节点
			pre.next = pre.next.next;
		}
		return backIndex;
	}

}
