package htc.leetcode.top_interview;

/*
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

public class _206_��ת���� {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

//		ListNodeUtil.print(reverseList(head));
		ListNodeUtil.print(reverseList2(head));
	}

	// ����AC �����ղ���
	public static ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode tmp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = tmp;
		}
		return pre;
	}

	// ��ʼ�ݹ��Դ���
	// ��̫���ˣ��ݹ鶼���ᣬ�Ͱ�ѭ��תΪβ�ݹ���ѣ���
	// ��cuur��pre�ĵ�������תΪ�ݹ�
	// finally������AC
	public static ListNode reverseList2(ListNode head) {
		return reverse(null, head);// ��Ҫֻ����������ݹ飬��ʱ���½�һ���ݹ鷽����
	}

	private static ListNode reverse(ListNode pre, ListNode curr) {
		if (curr == null) {
			return pre;
		}
		ListNode tmp = curr.next;
		curr.next = pre;
		return reverse(curr, tmp);
	}

}
