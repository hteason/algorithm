package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;
/*
 * status:AC
 * https://leetcode-cn.com/problems/remove-linked-list-elements
 */
public class _203_移除链表元素 {
	public static void main(String[] args) {
		ListNodeUtil.print(removeElements(ListNodeUtil.arr2Node(new int[] { 1, 4, 3, 2, 5, 2 }), 2));
		ListNodeUtil.print(removeElements(ListNodeUtil.arr2Node(new int[] { 1, 4, 3, 2, 5, 2 }), 2));
		ListNodeUtil.print(removeElements(ListNodeUtil.arr2Node(new int[] {}), 6));
		ListNodeUtil.print(removeElements(ListNodeUtil.arr2Node(new int[] { 1 }), 1));
		ListNodeUtil.print(removeElements(ListNodeUtil.arr2Node(new int[] { 1, 1 }), 1));
	}

	public static ListNode removeElements(ListNode head, int val) {
		// 如果头节点就是删除值,先覆盖删除头节点
		while (head != null && head.val == val) {
			head = head.next;
		}
		if (head == null) {
			return null;
		}

		ListNode pre = head;
		ListNode cur = pre.next;

		while (cur != null) {
			if (cur.val == val) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}
}
