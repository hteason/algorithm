package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

public class _24_�������������еĽڵ� {
	public static void main(String[] args) {
		ListNodeUtil.print(swapPairs(ListNodeUtil.arr2Node()));
		ListNodeUtil.print(swapPairs(ListNodeUtil.arr2Node(1)));
		ListNodeUtil.print(swapPairs(ListNodeUtil.arr2Node(1,2)));
		ListNodeUtil.print(swapPairs(ListNodeUtil.arr2Node(1,2,3)));
		ListNodeUtil.print(swapPairs(ListNodeUtil.arr2Node(1,2,3,4)));
		ListNodeUtil.print(swapPairs(ListNodeUtil.arr2Node(1,2,3,4,5)));
	}

	// ������������
	//Ŷ��AC!!��Ȼ��֪����ô���ģ�ֻ֪�����Ѿ�����
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode curr = head;
		ListNode nextNode = curr.next;
		ListNode pre = new ListNode(-1);
		pre.next = nextNode;//*��Ҫ��һ��ʼ��preָ��nextNode
		
		head = nextNode;//��¼ͷ�ڵ�λ�ã���Ϊ���ս������

		while (nextNode != null) {
			ListNode tmp = nextNode.next;//ָ�������λ�õ������
			curr.next = tmp;//��һλ�ýڵ����һ�ڵ�ָ�����������
			nextNode.next = curr;//�ڶ�λ�ýڵ����һ�ڵ㷴��ָ���һλ�õĽڵ�

			pre.next = nextNode;//��¼��һ�ڵ�λ�õĽڵ��Ƶ���һ�ڵ�
			pre = curr;//�����pre�ڵ㶼�ǵ�ǰ�ڵ�

			if (tmp == null) {//�޴������������˳�
				break;
			}
			curr = tmp;//��ǰ�ڵ�ָ�����������ε�ͷ�ڵ�
			nextNode = tmp.next;//��һ�ڵ�ָ�����������εĵڶ����ڵ�
		}
		return head;
	}
}
