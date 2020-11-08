package htc.leetcode.everyday._2020._08;

/**
 * AC
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class _2020_08_30_557_反转字符串中的单词III {
    public static void main(String[] args) {
        _2020_08_30_557_反转字符串中的单词III test = new _2020_08_30_557_反转字符串中的单词III();
        System.out.println(test.reverseWords3("Let's take LeetCode contest"));
    }

    //纯数组，几个中最快的
    public String reverseWords3(String s) {
        char[] ss = s.toCharArray();
        char[] ans = new char[ss.length];

        for (int i = 0, index = 0, len = ss.length; i < len; i++) {
            int j = i;
            while (j < len && ss[j] != ' ') {
                j++;
            }
            if (j > len) {
                break;
            }
            for (int k = j - 1; k >= i; k--) {
                ans[index++] = ss[k];
            }
            if (j <= len - 1) {
                ans[index++] = ' ';
            }
            i = j;
        }
        return new String(ans);
    }

    public String reverseWords2(String s) {
        String[] ss = s.split(" ");
        char[] ans = new char[s.length()];
        for (int i = 0, index = 0, len = ss.length; i < len; i++) {
            char[] cs = ss[i].toCharArray();
            for (int j = cs.length - 1; j >= 0; j--) {
                ans[index++] = cs[j];
            }
            if (i != len - 1) {
                ans[index++] = ' ';
            }
        }
        return new String(ans);
    }

    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = ss.length; i < len; i++) {
            String str = ss[i];
            String sub = new StringBuilder(str).reverse().toString();
            sb.append(sub);
            if (i != len - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
