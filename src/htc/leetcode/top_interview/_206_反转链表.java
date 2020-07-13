package htc.leetcode.top_interview;

/*
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

public class _206_反转链表 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

//		ListNodeUtil.print(reverseList(head));
		ListNodeUtil.print(reverseList2(head));
	}

	// 迭代AC 但掌握不牢
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

	// 开始递归试错。。
	// 我太菜了，递归都不会，就把循环转为尾递归而已！！
	// 把cuur和pre的迭代过程转为递归
	// finally：狗命AC
	public static ListNode reverseList2(ListNode head) {
		return reverse(null, head);// 不要只纠结于自身递归，是时候新建一个递归方法了
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
