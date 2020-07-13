package htc.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

import htc.leetcode.datatype.ListNode;

/**
 * status:���Ż�
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class _1290_����������ת���� {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(0);
		head.next.next = new ListNode(1);
		System.out.println(getDecimalValue(head));
	}
	
	//TODO: �Ż���https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/solution/er-jin-zhi-lian-biao-zhuan-zheng-shu-by-leetcode/

	
	// ����
	public static int getDecimalValue(ListNode head) {
		int ret = 0;
		List<Integer> nums = new ArrayList<>();
		while (head != null) {
			nums.add(head.val);
			head = head.next;
		}
		for (int size = nums.size() - 1, i = size; i >= 0; i--) {
			if (nums.get(i) == 0) {
				continue;
			}
			ret += Math.pow(2, size - i) * nums.get(i);
		}
		return ret;
	}
}
