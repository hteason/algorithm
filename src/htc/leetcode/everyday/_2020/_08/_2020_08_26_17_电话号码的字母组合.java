package htc.leetcode.everyday._2020._08;

import java.util.*;

/**
 * AC:暴力,勉强过
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class _2020_08_26_17_电话号码的字母组合 {

    public static void main(String[] args) {
        _2020_08_26_17_电话号码的字母组合 test = new _2020_08_26_17_电话号码的字母组合();
        System.out.println(test.letterCombinations("23"));
        System.out.println(test.letterCombinations("2323"));
        System.out.println(test.letterCombinations("234"));
        System.out.println(test.letterCombinations("23456789"));
//        System.out.println(test.letterCombinations("23456789345456456456456"));
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        char[] chars = digits.toCharArray();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            List<Character> cs = map.get(chars[i]);
            if (i == 0) {
                for (Character ch : cs) {
                    ans.add(ch.toString());
                }
                continue;
            }

            List<String> list = new ArrayList<>();
            for (String s : ans) {
                for (char ch : cs) {
                    list.add(s + ch);
                }
            }
            ans = new ArrayList<>(list);
        }
        return ans;
    }
}
