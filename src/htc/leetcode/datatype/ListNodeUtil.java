package htc.leetcode.datatype;

public class ListNodeUtil {
	public static void main(String[] args) {
		ListNodeUtil.print(ListNodeUtil.arr2Node(new int[] { 1, 4, 3, 2, 5, 2 }));
		ListNodeUtil.print(ListNodeUtil.str2Node("1 ->  1->2->3->3"));
	}

	//数组/不定参数转链表
	public static ListNode arr2Node(int...arr) {
		ListNode head = new ListNode(-1);
		ListNode listNode = head;
		for (int num : arr) {
			ListNode tmp = new ListNode(num);
			listNode.next = tmp;
			listNode = tmp;
		}
		return head.next;
	}


	//专用于leetcode测试样例的复制
	public static ListNode str2Node(String s) {
		if(s==null||s.trim().length()==0) {
			return null;
		}
		String[] arr = s.split("\\s*->\\s*");
		ListNode head = new ListNode(-1);
		ListNode listNode = head;
		for (String num : arr) {
			ListNode tmp = new ListNode(Integer.valueOf(num));
			listNode.next = tmp;
			listNode = tmp;
		}
		return head.next;
	}

	//输出链表
	public static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("null");
	}
}
