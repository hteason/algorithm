package htc.leetcode.everyday._2020._11;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * AC
 * 优先队列解法
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 */
public class _06_1356_根据数字二进制下1的数目排序 {
    public static void main(String[] args) {
        _06_1356_根据数字二进制下1的数目排序 test = new _06_1356_根据数字二进制下1的数目排序();
        System.out.println(Arrays.toString(test.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(test.sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
    }

    public int[] sortByBits(int[] arr) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {
            int c1 = Integer.bitCount(a);
            int c2 = Integer.bitCount(b);
            return c1 == c2 ? a - b : c1 - c2;
        });
        for (int a : arr) {
            q.add(a);
        }
        for (int i = 0, size = q.size(); i < size; i++) {
            arr[i] = q.poll();
        }
        return arr;
    }
}
