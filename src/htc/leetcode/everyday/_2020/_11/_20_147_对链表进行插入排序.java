package htc.leetcode.everyday._2020._11;

import htc.leetcode.datatype.ListNode;
import htc.leetcode.datatype.ListNodeUtil;

/**
 * AC
 * https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class _20_147_��������в������� {
    public static void main(String[] args) {
        ListNode root = ListNodeUtil.str2Node("4->2->1->3->-2");
        ListNodeUtil.print(root);
        _20_147_��������в������� test = new _20_147_��������в�������();
        ListNodeUtil.print(test.insertionSortList(root));

        root = ListNodeUtil.str2Node("-1->5->3->4->0");
        ListNodeUtil.print(root);
        ListNodeUtil.print(test.insertionSortList(root));

        root = ListNodeUtil.str2Node("0->-1");
        ListNodeUtil.print(root);
        ListNodeUtil.print(test.insertionSortList(root));
    }

    /**
     * ǰ�����������ȡԪ�أ���Ԫ��ǰ�������,�ɲ���ʱ����,���Ƴ�ԭ�ڵ�
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        while (head.next != null) {
            ListNode cur = head.next;
            ListNode dummyCur = dummyHead.next;
            ListNode dummyPrev = dummyHead;
            while (dummyCur != cur) {
                if (cur.val <= dummyCur.val) {
                    ListNode temp = dummyPrev.next;
                    //��ԭ���㷨,new��ֵͬ�ڵ㲢����
                    dummyPrev.next = new ListNode(cur.val);
                    dummyPrev.next.next = temp;
                    //�Ƴ�ԭ�ڵ�
                    head.next = head.next.next;
                    break;
                }
                dummyPrev = dummyCur;
                dummyCur = dummyCur.next;
            }
            if (dummyCur == cur) {
                head = head.next;
            }
        }
        return dummyHead.next;
    }
}
