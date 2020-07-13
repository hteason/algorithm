package htc.leetcode.linkedlist;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

public class _24_两两交换链表中的节点 {
	public static void main(String[] args) {
		ListNodeUtil.print(swapPairs(ListNodeUtil.arr2Node()));
		ListNodeUtil.print(swapPairs(ListNodeUtil.arr2Node(1)));
		ListNodeUtil.print(swapPairs(ListNodeUtil.arr2Node(1,2)));
		ListNodeUtil.print(swapPairs(ListNodeUtil.arr2Node(1,2,3)));
		ListNodeUtil.print(swapPairs(ListNodeUtil.arr2Node(1,2,3,4)));
		ListNodeUtil.print(swapPairs(ListNodeUtil.arr2Node(1,2,3,4,5)));
	}

	// 做不出啊！！
	//哦豁，AC!!虽然不知道怎么来的，只知道天已经黑了
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode curr = head;
		ListNode nextNode = curr.next;
		ListNode pre = new ListNode(-1);
		pre.next = nextNode;//*重要，一开始的pre指向nextNode
		
		head = nextNode;//记录头节点位置，作为最终结果返回

		while (nextNode != null) {
			ListNode tmp = nextNode.next;//指向待交换位置的链表段
			curr.next = tmp;//第一位置节点的下一节点指向上述链表段
			nextNode.next = curr;//第二位置节点的下一节点反向指向第一位置的节点

			pre.next = nextNode;//记录上一节点位置的节点移到先一节点
			pre = curr;//后面的pre节点都是当前节点

			if (tmp == null) {//无待交换的链表，退出
				break;
			}
			curr = tmp;//当前节点指向待交换链表段的头节点
			nextNode = tmp.next;//下一节点指向待交换链表段的第二个节点
		}
		return head;
	}
}
