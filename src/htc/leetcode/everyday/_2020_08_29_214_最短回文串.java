package htc.leetcode.everyday;

/**
 * AC
 * https://leetcode-cn.com/problems/shortest-palindrome/
 */
public class _2020_08_29_214_最短回文串 {
    public static void main(String[] args) {
        _2020_08_29_214_最短回文串 test = new _2020_08_29_214_最短回文串();
        System.out.println(test.shortestPalindrome("aacecaaa"));
        System.out.println(test.shortestPalindrome("abcd"));
        System.out.println(test.shortestPalindrome("aa"));
        System.out.println(test.shortestPalindrome("baab"));
        System.out.println(test.shortestPalindrome("caab"));
        System.out.println(test.shortestPalindrome("ba"));
        System.out.println(test.shortestPalindrome("a"));
        System.out.println(test.shortestPalindrome(""));
        System.out.println(test.shortestPalindrome("aaaaa"));
    }

    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int mid = len / 2;
        while (mid > 0) {
            //取中位,判断前一位和后一位是否相等,相等则双指针分别前后移动
            for (int i = mid - 1, j = mid + 1; i >= 0 && j < len && chars[i] == chars[j]; i--, j++) {
                if (i == 0 && j == len - 1) {
                    //前指针到开头，且后指针到末尾,说明已经是回文数,直接返回
                    return s;
                } else if (i == 0) {
                    //前指针到头,后指针没到尾,将后指针后面的子串反转并拼接到原串s前面
                    return new StringBuilder(s.substring(j + 1)).reverse().append(s).toString();
                }
            }
            //取中位,判断中位数和前一位是否相等,相等则双指针分别前后移动
            for (int i = mid - 1, j = mid; i >= 0 && j < len && chars[i] == chars[j]; i--, j++) {
                if (i == 0 && j == len - 1) {
                    return s;
                } else if (i == 0) {
                    return new StringBuilder(s.substring(j + 1)).reverse() + s;
                }
            }
            //中位数前移
            mid--;
        }
        //到这说明s中没有回文子串,直接将首字母以后的子串反转并拼接到原串s前面
        return new StringBuilder(s.substring(1)).reverse().append(s).toString();
    }
}
