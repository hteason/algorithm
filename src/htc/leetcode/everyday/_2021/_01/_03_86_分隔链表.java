package htc.leetcode.everyday._2021._01;

import htc.leetcode.datatype.ListNode;

/**
 * AC
 * https://leetcode-cn.com/problems/partition-list/
 *
 * @date 2021/1/4
 */
public class _03_86_分隔链表 {
    //"分治"指针：lees，large
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode less = new ListNode(-1);
        ListNode large = new ListNode(-1);

        ListNode lessHead = less;
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = head;
            } else {
                large.next = head;
                large = head;
            }
            head = head.next;
        }
        large.next = null;
        less.next = largeHead.next;
        return lessHead.next;
    }
}
