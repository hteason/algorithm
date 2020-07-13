package htc.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

/*
 * AC
 * 纯数组 > 单调栈 > 双重循环
 * https://leetcode-cn.com/problems/next-greater-node-in-linked-list
 */
public class _1019_链表中的下一个更大节点 {
	public static void main(String[] args) {
//		nextLargerNodes(ListNodeUtil.arr2Node(2, 1, 5));
//		nextLargerNodes(ListNodeUtil.arr2Node(2, 7, 4, 3, 5));
//		nextLargerNodes(ListNodeUtil.arr2Node(1, 7, 5, 1, 9, 2, 5, 1));
		nextLargerNodes(ListNodeUtil.arr2Node(2, 7, 4, 3, 5));
	}

	public static int[] nextLargerNodes(ListNode head) {
		int len = 0;
		ListNode node = head;
		while (node != null) {
			len++;
			node = node.next;
		}
		int[] map = new int[len];
		int[] res = new int[len];
		int[] index = new int[len];
		for (int i = 0, j = 0; head != null; i++) {
			map[i] = head.val;
			while (j != 0 && head.val > map[index[j - 1]]) {
				res[index[--j]] = head.val;
			}
			index[j++] = i;
			head = head.next;
		}
//		System.out.println(Arrays.toString(res));
		return res;
	}

	public static int[] nextLargerNodes_stack(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		int[] map = new int[10000];
		int[] res = new int[10000];
		int i;
		for (i = 0; head != null; i++) {
			map[i] = head.val;
			while (!stack.isEmpty() && head.val > map[stack.peek()]) {
				res[stack.pop()] = head.val;
			}
			stack.push(i);
			head = head.next;
		}
		return Arrays.copyOfRange(res, 0, i);
	}

	// 慢！O(n^2)
	public static int[] nextLargerNodes_2for(ListNode head) {
		List<Integer> res = new ArrayList<Integer>();
		ListNode outter = head;
		ListNode inner = head;
		while (outter != null) {
			for (inner = outter.next; inner != null;) {
				if (inner.val > outter.val) {
					res.add(inner.val);
					break;
				}
				inner = inner.next;
			}
			if (inner == null) {
				res.add(0);
			}
			outter = outter.next;
		}
		return res.stream().mapToInt(Integer::valueOf).toArray();
	}
}
