package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

public class _92_��ת����_II {
	public static void main(String[] args) {
		ListNodeUtil.print(reverseBetween(ListNodeUtil.str2Node("1->2->3->4->5->6->7"), 2, 5));
		ListNodeUtil.print(reverseBetween(ListNodeUtil.str2Node("3->5"), 1, 2));
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m == n) {
			return head;
		}
		// ����ɸ���m,n��Ϊ��������,���£�
		// ��ת����ǰ������preHead����ת����reverseNode����ת����������(����tailListNode)
		// ��1->2->3->4->5��2��5
		// preHead: 1
		// reverseNode: 2->3->4
		// tailListNode: 5
		ListNode curr = head;

		ListNode preHead = null;// ��¼��תǰ�����һ���ڵ�

		// ��ȡ��Ҫ��ת������εĵ�һ���ڵ�
		for (int i = 1; i < m && curr != null; i++) {
			if (i + 1 == m) {
				preHead = curr;
			}
			curr = curr.next;
		}
		// ��ת����εĵ�һ���ڵ�
		ListNode reverseNode = new ListNode(-1);
		// ��ת����������ĵ�һ���ڵ�Ϊ��ת����תǰ��ͷ�ڵ㣬��
		// 1->2->3->4->5��ת����Ϊ2->3->4����ת��4->3->2
		// 2(��תǰ��ͷ�ڵ�)��nextΪ5(��ת����������)

		ListNode tailListNode = reverseNode.next;
		for (int i = m - 1; i < n && curr != null; i++) {
			// ��ת�����2->3->4->5Ϊ4->3->2->5
			// ͷ�巨
			ListNode curTmp = curr.next;
			ListNode tmp = reverseNode.next;
			reverseNode.next = curr;
			curr.next = tmp;
			curr = curTmp;
			if (i == m - 1) {
				// ��ת��n����ʱ��¼��ת�����β�ڵ�
				tailListNode = reverseNode.next;
			}
		}
		// currΪ�ڷ�ת�������Ҫ��ת������currƴ���ڷ�ת�������
		tailListNode.next = curr;
		if (preHead != null) {
			// m���Ǵ�1��ʼʱ������preHead��ƴ�ӵ�һ������ͷ�ת����
			preHead.next = reverseNode.next;
			return preHead;
		} else {
			// �ӵ�һ���ڵ㿪ʼ��תʱ��preHeadΪ�գ�ֱ�ӷ�������ͷ�ڵ����һ���ڵ�
			return reverseNode.next;
		}
	}
}
