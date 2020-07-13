package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;
/*
 * status:AC
 * �ڴ��Ż�����ȥ��
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class _2_������� {
	public static void main(String[] args) {
		ListNodeUtil
				.print(addTwoNumbers(ListNodeUtil.str2Node("1->2 -> 4 -> 3"), ListNodeUtil.str2Node("5 -> 6 -> 4")));
		ListNodeUtil.print(addTwoNumbers(ListNodeUtil.str2Node("9->8"), ListNodeUtil.str2Node("1")));
		ListNodeUtil.print(addTwoNumbers(ListNodeUtil.str2Node("9->9"), ListNodeUtil.str2Node("1")));
		ListNodeUtil.print(addTwoNumbers(ListNodeUtil.str2Node("0"), ListNodeUtil.str2Node("7->3")));
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode back = dummyHead;
		int carry = 0;
		while (l1 != null && l2 != null) {
			back.next = new ListNode((l1.val + l2.val + carry) % 10);
			back = back.next;
			carry = (l1.val + l2.val + carry) / 10;
			l1 = l1.next;
			l2 = l2.next;
		}

		// ��ʱ�ض���һ������Ϊnull������null��������remainder
		//����for����Сʹ����Χ
		for (ListNode remainder = l1 == null ? l2 : l1; remainder != null;) {
			if (carry==0) {
				back.next = remainder;
				break;
			}
			int tmp = carry;
			carry = (remainder.val + carry) / 10;
			remainder.val = (remainder.val + tmp) % 10;
			back.next = remainder;
			back = back.next;
			remainder = remainder.next;
		}

		if (carry != 0) {
			back.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
}
