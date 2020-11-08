package htc.leetcode.everyday._2020._11;

/**
 * AC
 * FIXME 待优化
 * 双重循环暴力
 * https://leetcode-cn.com/problems/count-of-range-sum/
 */
public class _07_327_区间和的个数 {
    public static void main(String[] args) {
        _07_327_区间和的个数 test = new _07_327_区间和的个数();
        System.out.println(test.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
        System.out.println(test.countRangeSum(new int[]{-2, 2}, -2, 2));
        System.out.println(test.countRangeSum(new int[]{-2147483647, 0, -2147483647, 2147483647},
                -564, 3864));
    }

    /**
     * 暴力，sum即可，不用开数组，否则超内存
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += i == j ? nums[i] : nums[j];
                if (sum >= lower && sum <= upper) {
                    count++;
                }
            }
        }
        return count;
    }
}
