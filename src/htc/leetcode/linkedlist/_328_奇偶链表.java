package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

public class _328_��ż���� {
	public static void main(String[] args) {
//		ListNodeUtil.print(oddEvenList(ListNodeUtil.str2Node("1->2->3->4->5")));
	}

	//��
	public static ListNode oddEvenList(ListNode head) {
		// �ڵ���С�ڵ���2ʱֱ�ӷ��أ���ʱ�ѷ��Ϸ������
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		while (slow != null && slow.next != null) {

			if (fast != null) {
				//����λ����
				int tmp = slow.val;
				slow.val = fast.val;
				fast.val = tmp;
				fast = fast.next != null ? fast = fast.next.next : fast.next;
			} else {
				//��ԭ���λ��
//				int tmp = slow.val;
//				slow.val = slow.next.val;
//				slow.next.val = tmp;
			}
			slow = slow.next;
		}

		return head;
	}
}
