package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;
/*
 * status: AC
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class _83_ɾ�����������е��ظ�Ԫ�� {

	public static void main(String[] args) {
		ListNodeUtil.print(deleteDuplicates(ListNodeUtil.arr2Node(new int[] { 1, 1, 2})));
		ListNodeUtil.print(deleteDuplicates(ListNodeUtil.arr2Node(new int[] { 1, 1, 2, 3, 3 })));
		ListNodeUtil.print(deleteDuplicates(ListNodeUtil.arr2Node(new int[] { 1, 1, 1})));
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			//����ǰ�ڵ�ֵ����һ�ڵ�ֵ��ͬ����ǰ�ڵ��nextֱ��ָ����һ�ڵ����һ�ڵ㣨cur.next.next������ֱ�Ӷ�����һ�ڵ�
			//��ѭ��ִ�У������ظ�ֵ�������֣���[1,1,1]
			while (cur.next != null && cur.val == cur.next.val) {
				cur.next = cur.next.next;
			}
			cur = cur.next;
		}
		return head;
	}

}
