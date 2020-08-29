package htc.leetcode.everyday;

/**
 * AC
 * https://leetcode-cn.com/problems/shortest-palindrome/
 */
public class _2020_08_29_214_��̻��Ĵ� {
    public static void main(String[] args) {
        _2020_08_29_214_��̻��Ĵ� test = new _2020_08_29_214_��̻��Ĵ�();
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
            //ȡ��λ,�ж�ǰһλ�ͺ�һλ�Ƿ����,�����˫ָ��ֱ�ǰ���ƶ�
            for (int i = mid - 1, j = mid + 1; i >= 0 && j < len && chars[i] == chars[j]; i--, j++) {
                if (i == 0 && j == len - 1) {
                    //ǰָ�뵽��ͷ���Һ�ָ�뵽ĩβ,˵���Ѿ��ǻ�����,ֱ�ӷ���
                    return s;
                } else if (i == 0) {
                    //ǰָ�뵽ͷ,��ָ��û��β,����ָ�������Ӵ���ת��ƴ�ӵ�ԭ��sǰ��
                    return new StringBuilder(s.substring(j + 1)).reverse().append(s).toString();
                }
            }
            //ȡ��λ,�ж���λ����ǰһλ�Ƿ����,�����˫ָ��ֱ�ǰ���ƶ�
            for (int i = mid - 1, j = mid; i >= 0 && j < len && chars[i] == chars[j]; i--, j++) {
                if (i == 0 && j == len - 1) {
                    return s;
                } else if (i == 0) {
                    return new StringBuilder(s.substring(j + 1)).reverse() + s;
                }
            }
            //��λ��ǰ��
            mid--;
        }
        //����˵��s��û�л����Ӵ�,ֱ�ӽ�����ĸ�Ժ���Ӵ���ת��ƴ�ӵ�ԭ��sǰ��
        return new StringBuilder(s.substring(1)).reverse().append(s).toString();
    }
}
