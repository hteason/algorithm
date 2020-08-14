package htc.leetcode.everyday;

import java.util.Stack;

/**
 * AC
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _2020_08_14_20_有效的括号 {

    //数组优化版【推荐】 100% 98.8%
    public boolean isValid_up(String s) {
        char[] stack = new char[s.length()];
        int index = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[index++] = ')';
            } else if (c == '[') {
                stack[index++] = ']';
            } else if (c == '{') {
                stack[index++] = '}';
            } else if (index != 0) {
                if (stack[--index] != c) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return index == 0;
    }

    //慢 推荐数组法
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (!stack.isEmpty()) {
                if (stack.pop() != c) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
