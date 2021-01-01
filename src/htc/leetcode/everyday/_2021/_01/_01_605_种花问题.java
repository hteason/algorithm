package htc.leetcode.everyday._2021._01;

/**
 * AC
 * https://leetcode-cn.com/problems/can-place-flowers/
 *
 * @date 2021/1/1
 */
public class _01_605_种花问题 {
    public static void main(String[] args) {
        _01_605_种花问题 test = new _01_605_种花问题();
        System.out.println(test.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(test.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(test.canPlaceFlowers(new int[]{0, 0, 0, 0, 1}, 2));
        System.out.println(test.canPlaceFlowers(new int[]{1, 0, 0, 0, 0}, 2));
        System.out.println(test.canPlaceFlowers(new int[]{0, 0, 0, 0, 0}, 2));
        System.out.println();
        System.out.println(test.canPlaceFlowers(new int[]{0, 0, 0}, 2));
        System.out.println(test.canPlaceFlowers(new int[]{0, 0, 0, 0}, 2));
        System.out.println(test.canPlaceFlowers(new int[]{0, 0, 0, 0}, 1));
        System.out.println(test.canPlaceFlowers(new int[]{0, 0, 1, 0}, 1));
        System.out.println(test.canPlaceFlowers(new int[]{1, 0, 0, 1}, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i += 2) {
            if (flowerbed[i] == 0) {
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    n--;
                } else {
                    i++;
                }
            }
        }
        return n <= 0;
    }
}
