package htc.leetcode.everyday._2020._08;

/**
 * AC
 * https://leetcode-cn.com/problems/multiply-strings/
 */
public class _2020_08_13_43_×Ö·û´®Ïà³Ë {
    public static void main(String[] args) {
        _2020_08_13_43_×Ö·û´®Ïà³Ë test = new _2020_08_13_43_×Ö·û´®Ïà³Ë();
        System.out.println(test.multiply("2", "3"));
        System.out.println(test.multiply("12", "34"));
        System.out.println(test.multiply("123", "456"));
        System.out.println(test.multiply("123456", "7890"));
        System.out.println(test.multiply("456", "890"));
        System.out.println(test.multiply("123456", "10"));
        System.out.println(test.multiply("123456", "0"));
    }


    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        char[] ans = new char[len1 + len2];
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        if ((len1 == 1 && c1[0] == '0') || (len2 == 1 && c2[0] == '0')) {
            return "0";
        }
        int end = ans.length - 1;
        for (int i = c2.length - 1; i >= 0; i--, end--) {
            if (c2[i] == '0') {
                continue;
            }
            int step = 0;
            int cur = end;
            int n2 = c2[i] - '0';
            for (int j = c1.length - 1; j >= 0; j--, cur--) {
                int n1 = c1[j] - '0';
                int mul = n1 * n2 + step;
                if (i != c2.length - 1 && ans[cur] >= '0' && ans[cur] <= '9') {
                    mul += (ans[cur] - '0');
                }
                ans[cur] = (char) (mul % 10 + '0');
                step = mul / 10;
            }
            if (step != 0) {
                ans[cur] = (char) (step + '0');
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if (Character.isDigit(ans[i])) {
                return new String(ans, i, ans.length - i);
            }
            if (i == ans.length - 1) {
                return "0";
            }
        }
        return new String(ans);
    }
}
