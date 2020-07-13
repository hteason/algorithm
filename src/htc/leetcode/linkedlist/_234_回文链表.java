package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

/*
 * status:AC
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class _234_回文链表 {
	public static void main(String[] args) {
//		System.out.println(isPalindrome(ListNodeUtil.str2Node("1->2")));
//		System.out.println(isPalindrome(ListNodeUtil.str2Node("1->2->2->1")));
//		System.out.println(isPalindrome(ListNodeUtil.str2Node("1->2->3->3->2->1")));
	}

	//慢！TODO 不该借助字符串
	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		while (head != null) {
			s1.append(head.val);
			s2.insert(0, head.val);
			head = head.next;
		}
		return s1.toString().equals(s2.toString());
	}
}
