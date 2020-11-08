package htc.leetcode.everyday._2020._08;

/**
 * AC
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 */
public class _2020_08_24_459_重复的子字符串 {
    public static void main(String[] args) {
        _2020_08_24_459_重复的子字符串 test = new _2020_08_24_459_重复的子字符串();
        System.out.println(test.repeatedSubstringPattern("abab"));
        System.out.println(test.repeatedSubstringPattern("aba"));
        System.out.println(test.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(test.repeatedSubstringPattern("aaaa"));
        System.out.println(test.repeatedSubstringPattern("abababa"));
        System.out.println(test.repeatedSubstringPattern("abababab"));
    }

    public boolean repeatedSubstringPattern(String s) {
        char[] cs = s.toCharArray();
        StringBuilder sub = new StringBuilder();
        for (int i = 0, len = cs.length; i < len / 2; i++) {
            sub.append(cs[i]);
            int subLen = sub.length();
            //原串是当前子串的倍数才会可能是重复子串，否则不是
            if (subLen != 0 && len % subLen == 0) {
                int j = subLen;
                //当前子串逐一对比后面的子串,若能比到最后,必定是重复子串
                for (; j < len; j += subLen) {
                    //每次步长为子串长度
                    if (!sub.toString().equals(s.substring(j, j + subLen))) {
                        break;
                    }
                }
                if (j == len) {
                    return true;
                }
            }
        }
        return false;
    }

    //暴力,超时
    public boolean repeatedSubstringPattern2(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            String sub = s.substring(0, i);
            String res = s.replaceAll(sub, "");
            if ("".equals(res)) {
                return true;
            }
        }
        return false;
    }
}
