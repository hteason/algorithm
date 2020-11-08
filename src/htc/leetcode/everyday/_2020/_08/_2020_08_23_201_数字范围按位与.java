package htc.leetcode.everyday._2020._08;

/**
 * AC
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 */
public class _2020_08_23_201_数字范围按位与 {
    public static void main(String[] args) {
        _2020_08_23_201_数字范围按位与 test = new _2020_08_23_201_数字范围按位与();
        System.out.println(test.rangeBitwiseAnd(1, 4));
        System.out.println(test.rangeBitwiseAnd(5, 7));
        System.out.println(test.rangeBitwiseAnd(0, 1));
        System.out.println(test.rangeBitwiseAnd(2, 2));
        System.out.println(test.rangeBitwiseAnd(2, 3));
        System.out.println(test.rangeBitwiseAnd(4, 5));
        System.out.println(test.rangeBitwiseAnd(12, 14));
        System.out.println(test.rangeBitwiseAnd(0, 2147483647));
        System.out.println(test.rangeBitwiseAnd(2147483646, 2147483647));
        System.out.println(test.rangeBitwiseAnd(2147483247, 2147483647));
        System.out.println(test.rangeBitwiseAnd(600000000, 2147483645));
        System.out.println(test.rangeBitwiseAnd(536870912, 1073741823));
        System.out.println(test.rangeBitwiseAnd(1073741925, 2147483646));
    }

    public int rangeBitwiseAnd(int m, int n) {
        //两个相同的数经过与运算之后是本身
        if (m == n) {
            return m;
        }
        //判断n和m是否在同一个2次幂范围内,不是的话结果肯定是0,因为中间经历了所有比特位数不一样得情况
        for (int i = 0; i < 31; i++) {
            int num = 2 << i;
            if (m < num) {
                if (n >= num) {
                    return 0;
                } else {
                    break;
                }
            }
        }
        /*
        n m在同个2次幂范围内
        1. 对二进制数从后往前对每一位遍历,查找最后一个不相等的数(即一个是0一个是1的情况)
        2. 将最后一个不相等的数本身和之后的数当作0,再把之前的01串转换为十进制,即为结果

        如:n=10 m=12, 十进制分别为1010和1100
        1. 从后往前遍历二进制,最后一个不相等的数位于下标1,即1[0]10和1[1]00
        2. 把下标1本身和后面的数当作0,下标1之前的数不变,即1000,转为十进制得8
         */
        int ans = 0;
        for (int pow = 1; m != 0; pow <<= 1) {
            int mb = m & 1;
            int nb = n & 1;
            if (mb != nb) {
                ans = 0;
            } else if (mb == 1) {
                ans += pow;
            }
            m >>= 1;
            n >>= 1;
        }
        return ans;
    }
}
