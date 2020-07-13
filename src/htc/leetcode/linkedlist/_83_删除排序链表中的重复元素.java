package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;
/*
 * status: AC
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class _83_删除排序链表中的重复元素 {

	public static void main(String[] args) {
		ListNodeUtil.print(deleteDuplicates(ListNodeUtil.arr2Node(new int[] { 1, 1, 2})));
		ListNodeUtil.print(deleteDuplicates(ListNodeUtil.arr2Node(new int[] { 1, 1, 2, 3, 3 })));
		ListNodeUtil.print(deleteDuplicates(ListNodeUtil.arr2Node(new int[] { 1, 1, 1})));
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			//若当前节点值和下一节点值相同，当前节点的next直接指向下一节点的下一节点（cur.next.next），即直接丢弃下一节点
			//须循环执行，避免重复值连续出现，如[1,1,1]
			while (cur.next != null && cur.val == cur.next.val) {
				cur.next = cur.next.next;
			}
			cur = cur.next;
		}
		return head;
	}

}
