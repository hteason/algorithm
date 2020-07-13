package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

public class _445_两数相加_II {

	public static void main(String[] args) {
//		ListNode l1 = ListNodeUtil.str2Node("7 -> 2 -> 4 -> 3");
//		ListNode l2 = ListNodeUtil.str2Node("5 -> 6 -> 4");
//		ListNodeUtil.print(addTwoNumbers(l1, l2));
//		l1 = ListNodeUtil.arr2Node(3,9,9,9,9,9,9,9,9,9);
//		l2 = ListNodeUtil.arr2Node(7);
//		ListNodeUtil.print(addTwoNumbers(l1, l2));
	}

	//整数位数不限制，大数加法，哭了！
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		long n1 = 0;//链表1的数值形式
		long n2 = 0;//链表2的数值形式
		ListNode tmp1 = l1;
		ListNode tmp2 = l2;
		//遍历链表，将每个链表转为对应的整数值
		while (tmp1 != null || tmp2 != null) {
			if (tmp1 != null) {
				n1 = n1 * 10 + tmp1.val;
				tmp1 = tmp1.next;
			}
			if (tmp2 != null) {
				n2 = n2 * 10 + tmp2.val;
				tmp2 = tmp2.next;
			}
		}

		ListNode curr = new ListNode(0);
		ListNode first = curr;
		long answer = n1 + n2;
		System.out.println(answer);
		//依次将总和的值使用头插法添加到链表
		//因为可能出现总和为0的情况，用do-while，而不是while
		do {
			ListNode tmp = new ListNode((int)(answer % 10));
			ListNode next = first.next;
			first.next = tmp;
			tmp.next = next;
			answer /= 10;
		}while(answer != 0);
		return first.next;
	}

}
