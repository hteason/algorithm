package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

public class _445_�������_II {

	public static void main(String[] args) {
//		ListNode l1 = ListNodeUtil.str2Node("7 -> 2 -> 4 -> 3");
//		ListNode l2 = ListNodeUtil.str2Node("5 -> 6 -> 4");
//		ListNodeUtil.print(addTwoNumbers(l1, l2));
//		l1 = ListNodeUtil.arr2Node(3,9,9,9,9,9,9,9,9,9);
//		l2 = ListNodeUtil.arr2Node(7);
//		ListNodeUtil.print(addTwoNumbers(l1, l2));
	}

	//����λ�������ƣ������ӷ������ˣ�
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		long n1 = 0;//����1����ֵ��ʽ
		long n2 = 0;//����2����ֵ��ʽ
		ListNode tmp1 = l1;
		ListNode tmp2 = l2;
		//����������ÿ������תΪ��Ӧ������ֵ
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
		//���ν��ܺ͵�ֵʹ��ͷ�巨��ӵ�����
		//��Ϊ���ܳ����ܺ�Ϊ0���������do-while��������while
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
