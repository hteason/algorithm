package htc.leetcode.everyday._2021._01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * AC
 * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 *
 * @date 2021/1/22
 */
public class _22_989_数组形式的整数加法 {
    public static void main(String[] args) {
        _22_989_数组形式的整数加法 test = new _22_989_数组形式的整数加法();
        System.out.println(test.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(test.addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println(test.addToArrayForm(new int[]{2, 1, 5}, 806));
        System.out.println(test.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
        System.out.println(test.addToArrayForm(new int[]{9}, 1));
        System.out.println(test.addToArrayForm(new int[]{1}, 23));
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans = new ArrayList<>(A.length);
        int carry = 0;
        int i;
        for (i = A.length - 1; i >= 0 || K > 0; i--) {
            int mod = K % 10;
            int num = i < 0 ? 0 : A[i];
            ans.add((mod + num + carry) % 10);
            carry = (mod + num + carry) / 10;
            K /= 10;
        }
        if (carry != 0) {
            ans.add(1);
        }
        Collections.reverse(ans);
        return ans;
    }
}
