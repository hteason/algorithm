package htc.leetcode.lcof;

import java.util.Arrays;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

/*
 * AC
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class _06_从尾到头打印链表 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(reversePrint(ListNodeUtil.arr2Node())));
		System.out.println(Arrays.toString(reversePrint(ListNodeUtil.arr2Node(1))));
		System.out.println(Arrays.toString(reversePrint(ListNodeUtil.arr2Node(1, 3, 2))));
		System.out.println(Arrays.toString(reversePrint(ListNodeUtil.arr2Node(1, 3, 2, 3, 5, 23, 34, 5, 235, 235))));
	}

	public static int[] reversePrint(ListNode head) {
		int[] ans = new int[10000];
		int index = recursion(head, ans, 0);
		return Arrays.copyOf(ans, index);
	}

	private static int recursion(ListNode head, int[] ans, int index) {
		if (head == null) {
			return 0;
		}
		index = recursion(head.next, ans, index);
		ans[index++] = head.val;
		return index;
	}
}
