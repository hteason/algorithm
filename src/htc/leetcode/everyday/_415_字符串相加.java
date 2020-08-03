package htc.leetcode.everyday;

/**
 * AC
 * https://leetcode-cn.com/problems/add-strings/
 */
public class _415_×Ö·û´®Ïà¼Ó {
    public static void main(String[] args) {
        _415_×Ö·û´®Ïà¼Ó test = new _415_×Ö·û´®Ïà¼Ó();
        System.out.println(test.addStrings("123", "456"));
        System.out.println(test.addStrings("123", "4567"));
        System.out.println(test.addStrings("999", "1"));
        System.out.println(test.addStrings("0", "1"));
        System.out.println(test.addStrings("0", "10"));
    }

    public String addStrings(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int max = Math.max(n1.length, n2.length);
        char[] ans = new char[max];
        int adder = 0;
        for (int i = n1.length - 1, j = n2.length - 1; i >= 0 || j >= 0; i--, j--) {
            int nu1 = i < 0 ? 0 : n1[i] - '0';
            int nu2 = j < 0 ? 0 : n2[j] - '0';
            int sum = nu1 + nu2 + adder;
            adder = sum / 10;
            ans[--max] = (char) ('0' + (sum % 10));
        }
        if (adder != 0) {
            return adder + String.valueOf(ans);
        }
        return String.valueOf(ans);
    }
}
