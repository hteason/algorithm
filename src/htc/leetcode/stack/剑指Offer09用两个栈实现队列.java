package htc.leetcode.stack;

import java.util.Stack;

/**
 * AC
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class 剑指Offer09用两个栈实现队列 {
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
     * 思路：
     * 1.添加的数据都压入stack
     * 2.在执行出队操作时，判断helper栈是否为空：
     *    空： 将stack栈的数据全部倒入helper,即stack数据出栈并压进helper,
     *         此时helper栈的数据序列和stack是相反的，符合队列的特点:FIFO(先进先出)
     *    非空:直接弹出并返回helper栈顶数据
     *   注意：stack和helper同时为空时说明队列无数据，直接return -1;即可
     */
    static class CQueue {
        //入队数据都往这个栈添加
        Stack<Integer> stack;
        //从这个栈出队
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
