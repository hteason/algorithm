package htc.leetcode.everyday._2020._11;

/**
 * AC
 * Ͱ����
 * https://leetcode-cn.com/problems/increasing-decreasing-string/
 *
 * @date 2020/11/25
 */
public class _25_1370_�����½��ַ��� {
    public static void main(String[] args) {
        _25_1370_�����½��ַ��� test = new _25_1370_�����½��ַ���();
        System.out.println(test.sortString("aaaabbbbcccc"));
        System.out.println(test.sortString("rat"));
        System.out.println(test.sortString("leetcode"));
        System.out.println(test.sortString("ggggggg"));
        System.out.println(test.sortString("spo"));
        System.out.println(test.sortString(""));
    }

    public String sortString(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() != s.length()) {
            int i = 0;
            for (; i < 26; i++) {
                if (map[i] != 0) {
                    sb.append((char) (i + 'a'));
                    map[i]--;
                }
            }
            for (i--; i >= 0; i--) {
                if (map[i] != 0) {
                    sb.append((char) (i + 'a'));
                    map[i]--;
                }
            }

        }
        return sb.toString();
    }
}
