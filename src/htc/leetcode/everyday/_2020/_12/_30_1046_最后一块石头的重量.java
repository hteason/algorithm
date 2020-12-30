package htc.leetcode.everyday._2020._12;

import java.util.Arrays;

/**
 * AC
 * https://leetcode-cn.com/problems/last-stone-weight/
 *
 * @date 2020/12/30
 */
public class _30_1046_最后一块石头的重量 {
    public static void main(String[] args) {
        _30_1046_最后一块石头的重量 test = new _30_1046_最后一块石头的重量();
        System.out.println(test.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(test.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 2}));
        System.out.println(test.lastStoneWeight(new int[]{2}));
        System.out.println(test.lastStoneWeight(new int[]{2, 5}));
        System.out.println(test.lastStoneWeight(new int[]{2, 5, 1}));
        System.out.println(test.lastStoneWeight(new int[]{2, 2}));
    }

    public int lastStoneWeight(int[] stones) {
        while (true) {
            int len = stones.length;
            if (len == 1) {
                return stones[0];
            }
            Arrays.sort(stones);
            stones[len - 2] = stones[len - 1] - stones[len - 2];
            stones = Arrays.copyOf(stones, len - 1);
        }
    }
}
