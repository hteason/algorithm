package htc.leetcode.everyday;

/**
 * AC
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * <p>
 * 其他思路：对于有序数组，可以考虑到二分查找
 */
public class _2020_07_22_剑指Offer11_旋转数组的最小数字 {
    public static void main(String[] args) {
        _2020_07_22_剑指Offer11_旋转数组的最小数字 test = new _2020_07_22_剑指Offer11_旋转数组的最小数字();
        System.out.println(test.minArray(new int[]{1,3,5}));
        System.out.println(test.minArray(new int[]{3,4,5,1,2}));
        System.out.println(test.minArray(new int[]{2,2,2,0,1}));
        System.out.println(test.minArray(new int[]{0}));
        System.out.println(test.minArray(new int[]{1,3,5,-1}));
    }

    //简单解法
    public int minArray(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }
}
