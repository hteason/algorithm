package htc.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

import htc.leetcode.datatype.ListNode;

/*
 * status:AC
 * TODO ������set
 * https://leetcode-cn.com/problems/linked-list-cycle-ii
 */
public class _142_��������_II {
	public static void main(String[] args) {

	}

	// set
	public static ListNode detectCycle2(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode dummy = head;
		Set<ListNode> set = new HashSet<>();

		while (dummy != null) {
			if (!set.add(dummy)) {
				return dummy;
			}
			dummy = dummy.next;
		}
		return null;
	}

	// floyd����ָ��NB!��
	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode slow = head.next;
		ListNode fast = head.next.next;

		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		//����fastָ��
		fast = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
