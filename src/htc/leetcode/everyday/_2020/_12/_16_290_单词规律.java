package htc.leetcode.everyday._2020._12;

import java.util.HashMap;
import java.util.Map;

/**
 * AC
 * https://leetcode-cn.com/problems/word-pattern/
 *
 * @date 2020/12/16
 */
public class _16_290_单词规律 {
    public static void main(String[] args) {
        _16_290_单词规律 test = new _16_290_单词规律();
        System.out.println(test.wordPattern("abba", "dog cat cat dog"));
        System.out.println(test.wordPattern("abba", "dog cat cat fish"));
        System.out.println(test.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(test.wordPattern("abba", "dog dog dog dog"));
        System.out.println(test.wordPattern("aaaa", "dog dog dog dog"));
        System.out.println(test.wordPattern("abcd", "a b cc d"));
    }

    /**
     * 双map,98.94% 76.85%
     */
    public boolean wordPattern(String pattern, String s) {
        char[] cs = pattern.toCharArray();
        String[] ss = s.split(" ");
        if (cs.length != ss.length) {
            return false;
        }
        Map<Character, String> m1 = new HashMap<>();
        Map<String, Character> m2 = new HashMap<>();
        for (int i = 0; i < ss.length; i++) {
            String str = m1.get(cs[i]);
            Character ch = m2.get(ss[i]);
            if (str == null && ch == null) {
                m1.put(cs[i], ss[i]);
                m2.put(ss[i], cs[i]);
            } else if (ch != null) {
                if (ch != cs[i]) {
                    return false;
                }
            } else {
                if (!str.equals(ss[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
