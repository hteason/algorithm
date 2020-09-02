package htc.leetcode.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * 自闭
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 */
public class _剑指Offer_20_表示数值的字符串 {
    public static void main(String[] args) {
        _剑指Offer_20_表示数值的字符串 test = new _剑指Offer_20_表示数值的字符串();
        System.out.println(test.isNumber("+100"));
        System.out.println(test.isNumber("3."));
        System.out.println(test.isNumber(" 1e1"));
        System.out.println(test.isNumber("5e2"));
        System.out.println(test.isNumber("-123"));
        System.out.println(test.isNumber("3.1416"));
        System.out.println(test.isNumber("-1E-16"));
        System.out.println(test.isNumber("0123"));
        System.out.println(test.isNumber("1e1"));
        System.out.println("-----------");
        System.out.println(test.isNumber("."));
        System.out.println(test.isNumber(" 1 e1"));
        System.out.println(test.isNumber(".e1"));
        System.out.println(test.isNumber(" ."));
        System.out.println(test.isNumber(" +"));
        System.out.println(test.isNumber("e"));
        System.out.println(test.isNumber("12e"));
        System.out.println(test.isNumber("3.."));
        System.out.println(test.isNumber("1a3.14"));
        System.out.println(test.isNumber("1.2.3"));
        System.out.println(test.isNumber("+-5"));
        System.out.println(test.isNumber("12e+5.4"));
        System.out.println(test.isNumber("e+1"));
        System.out.println(test.isNumber("1e+1."));
        System.out.println(test.isNumber(".2.3e"));
        System.out.println(test.isNumber("6+1"));
        System.out.println(test.isNumber("6-1"));
        System.out.println(test.isNumber("6+1"));
        System.out.println(test.isNumber("6-"));
        System.out.println(test.isNumber("6-+1"));
        System.out.println(test.isNumber("6-"));
    }

    public boolean isNumber1(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isNumber(String s) {
        if (s == null || (s = s.trim()).length() == 0) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        set.add('+');
        set.add('-');
        set.add('.');
        set.add('E');
        set.add('e');
        char[] cs = s.toCharArray();
        if (cs[0] == 'e' || cs[0] == 'E' || (cs.length == 1 && set.contains(cs[0]))) {
            return false;
        }
        boolean preSymbol = false;
        boolean preDot = false;
        boolean hasE = false;
        boolean secSymbol = false;
        boolean preDigit = false;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (!set.contains(c) && !Character.isDigit(c)) {
                return false;
            }
            if (i == cs.length - 1) {
                if ((c == '+' || c == '-' || c == 'E' || c == 'e')) {
                    return false;
                } else if (c == '.' && !hasE && !preDot) {
                    return true;
                }
            }
            if (!hasE && i != 0 && (c == '+' || c == '-')) {
                return false;
            }
            if (!hasE) {
                if (c == '+' || c == '-') {
                    if (preSymbol) {
                        return false;
                    }
                    preSymbol = true;
                    continue;
                }
                if (c == '.') {
                    if (preDot) {
                        return false;
                    } else {
                        preDot = true;
                    }
                    if (i > 0 && !Character.isDigit(cs[i - 1])) {
                        return false;
                    }
                }
                preDigit = true;
            }
            if (c == 'e' || c == 'E') {
                if (set.contains(cs[i - 1])) {
                    return false;
                }
                if (hasE) {
                    return false;
                }
                hasE = true;
                continue;
            }
            if (hasE) {
                if (c == '+' || c == '-') {
                    if (secSymbol) {
                        return false;
                    }
                    secSymbol = true;
                    continue;
                }
                if (c == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}