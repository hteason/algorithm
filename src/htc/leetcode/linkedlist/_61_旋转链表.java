package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

public class _61_��ת���� {
	public static void main(String[] args) {
		ListNodeUtil.print(rotateRight(ListNodeUtil.str2Node("1->2->3->4->5"), 0));
		ListNodeUtil.print(rotateRight(ListNodeUtil.str2Node("1->2->3->4->5"), 11));
		ListNodeUtil.print(rotateRight(ListNodeUtil.str2Node("0->1->2"), 4));
		ListNodeUtil.print(rotateRight(ListNodeUtil.str2Node("1->2"), 1));
	}

	// ��ȫ����
	// ���컷������
	// �ض�β��
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}
		ListNode dummy = head;
		int len = 0;
		// ��ͷ��β����������¼������len
		while (head.next != null) {
			len++;
			head = head.next;
		}
		len++;

		// ������Ҫ�ƶ�����λ����Ҫ���k����len�����
		if (k > len) {
			// ��k����������ʱ���ȶ�k%len���õ�β�ڵ���뿪ʼ�ڵ���ٸ���λ����
			len = len - k % len - 1;
		} else if (k==len) {
			// �ƶ�λ��Ϊ0ʱֱ�ӷ���ԭ����
			return dummy;
		}else {
			// ��kС��������lenʱ��ֱ���ƶ�len-k-1λ
			len = len - k - 1;
		}

		//���컷��������β��ָ��ͷ��
		head.next = dummy;
		head = dummy;
		//ͨ��lenѰ���������β��
		for (int i = 0; i < len; i++) {
			head = head.next;
		}

		//������β����next����head
		dummy = head.next;
		//�Ͽ���������ʹ���γɵ�������
		head.next = null;
		//�����������ͷ��
		return dummy;
	}

}
