package htc.leetcode.everyday._2020._12;

/**
 * AC
 * https://leetcode-cn.com/problems/find-the-difference/
 *
 * @date 2020/12/18
 */
public class _18_389_找不同 {
    public static void main(String[] args) {
        _18_389_找不同 test = new _18_389_找不同();
        System.out.println(test.findTheDifference("abcd", "abcde"));
        System.out.println(test.findTheDifference("", "y"));
        System.out.println(test.findTheDifference("a", "aa"));
        System.out.println(test.findTheDifference("ae", "aea"));
    }

    public char findTheDifference(String s, String t) {
        if ("".equals(s)) {
            return t.charAt(0);
        }
        if ("".equals(t)) {
            return s.charAt(0);
        }
        int[] ss = new int[26];
        for (char c : s.toCharArray()) {
            ss[c - 'a']++;
        }
        int[] ts = new int[26];
        for (char c : t.toCharArray()) {
            ts[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ss[i] != ts[i]) {
                return (char) (i + 'a');
            }
        }
        return ' ';//执行不到
    }
}
