package htc.newcoder.tiba;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

/**
 * @author huangtingcheng
 * @date 2021/2/20
 */
public class _NC78反转链表 {
    public static void main(String[] args) {
        _NC78反转链表 test = new _NC78反转链表();
        ListNodeUtil.print(test.ReverseList3(ListNodeUtil.str2Node("1->2->3")));
    }

    /**
     * 递归算法
     */
    public ListNode ReverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = ReverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }

    /**
     * 原地算法
     */
    public ListNode ReverseList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        head = head.next;
        while (head != null) {
            ListNode next = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
            next.next = cur;
            cur = next;
        }
        return cur;
    }

    /**
     * 暴力,不是原来的链表了
     */
    public ListNode ReverseList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = new ListNode(head.val);
        cur.next = null;
        while (head.next != null) {
            ListNode next = new ListNode(head.next.val);
            next.next = cur;
            cur = next;
            head = head.next;
        }
        return cur;
    }
}
