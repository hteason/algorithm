package htc.leetcode.everyday._2020._12;

/**
 * AC
 * https://leetcode-cn.com/problems/monotone-increasing-digits/
 *
 * @date 2020/12/15
 */
public class _15_738_单调递增的数字 {
    public static void main(String[] args) {
        _15_738_单调递增的数字 test = new _15_738_单调递增的数字();
        System.out.println(test.monotoneIncreasingDigits(0));//9
        System.out.println(test.monotoneIncreasingDigits(1));//9
        System.out.println(test.monotoneIncreasingDigits(10));//9
        System.out.println(test.monotoneIncreasingDigits(100));//9
        System.out.println(test.monotoneIncreasingDigits(1234));//1234
        System.out.println(test.monotoneIncreasingDigits(123432));//123399
        System.out.println(test.monotoneIncreasingDigits(332));//299
        System.out.println(test.monotoneIncreasingDigits(354));//349
        System.out.println(test.monotoneIncreasingDigits(354243));//349999
        System.out.println(test.monotoneIncreasingDigits(542734));//499999
    }

    public int monotoneIncreasingDigits(int N) {
        if (N < 10) {
            return N;
        }
        char[] ns = String.valueOf(N).toCharArray();
        for (int i = 0, len = ns.length - 1; i < len; i++) {
            if (ns[i] > ns[i + 1]) {
                for (int j = i + 1; j < len + 1; j++) {
                    ns[j] = '9';
                }
                ns[i]--;
                while (i > 0 && ns[i] < ns[i - 1]) {
                    ns[i - 1]--;
                    ns[i] = '9';
                    i--;
                }
            }
        }
        int ans = 0;
        for (int n : ns) {
            ans = ans * 10 + (n - '0');
        }
        return ans;
    }
}
