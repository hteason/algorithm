package htc.leetcode.everyday._2020._12;

/**
 * AC
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * @date 2020/12/23
 */
public class _12_23_387_字符串中的第一个唯一字符 {
    public static void main(String[] args) {
        _12_23_387_字符串中的第一个唯一字符 test = new _12_23_387_字符串中的第一个唯一字符();
        System.out.println(test.firstUniqChar("leetcode"));
        System.out.println(test.firstUniqChar("loveleetcode"));
        System.out.println(test.firstUniqChar("a"));
        System.out.println(test.firstUniqChar("aa"));
    }

    public int firstUniqChar(String s) {
        char[] cs = s.toCharArray();
        int[] count = new int[26];
        for (char c : cs) {
            count[c - 'a']++;
        }
        for (int i = 0; i < cs.length; i++) {
            if (count[cs[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
