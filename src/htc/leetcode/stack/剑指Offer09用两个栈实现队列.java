package htc.leetcode.stack;

import java.util.Stack;

/**
 * AC
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class ��ָOffer09������ջʵ�ֶ��� {
    public static void main(String[] args) {
        CQueue q = new CQueue();
        q.appendTail(3);
        System.out.println(q.deleteHead());
        System.out.println(q.deleteHead());

        CQueue q1 = new CQueue();
        System.out.println(q1.deleteHead());
        q1.appendTail(5);
        q1.appendTail(2);
        System.out.println(q1.deleteHead());
        System.out.println(q1.deleteHead());

        CQueue q2 = new CQueue();
        System.out.println(q2.deleteHead());
        System.out.println(q2.deleteHead());
        System.out.println(q2.deleteHead());
    }

    /**
     * ˼·��
     * 1.��ӵ����ݶ�ѹ��stack
     * 2.��ִ�г��Ӳ���ʱ���ж�helperջ�Ƿ�Ϊ�գ�
     *    �գ� ��stackջ������ȫ������helper,��stack���ݳ�ջ��ѹ��helper,
     *         ��ʱhelperջ���������к�stack���෴�ģ����϶��е��ص�:FIFO(�Ƚ��ȳ�)
     *    �ǿ�:ֱ�ӵ���������helperջ������
     *   ע�⣺stack��helperͬʱΪ��ʱ˵�����������ݣ�ֱ��return -1;����
     */
    static class CQueue {
        //������ݶ������ջ���
        Stack<Integer> stack;
        //�����ջ����
        Stack<Integer> helper;

        public CQueue() {
            stack = new Stack<>();
            helper = new Stack<>();
        }

        public void appendTail(int value) {
            stack.push(value);
        }

        public int deleteHead() {
            if (helper.empty()) {
                while (!stack.empty()) {
                    helper.push(stack.pop());
                }
            }
            return helper.empty() ? -1 : helper.pop();
        }
    }
}
