package htc.leetcode.everyday;

import java.util.Arrays;

public class _2020_07_08_面试题16_11_跳水板 {
    public static void main(String[] args) {
        _2020_07_08_面试题16_11_跳水板 test = new _2020_07_08_面试题16_11_跳水板();
        System.out.println(Arrays.toString(test.divingBoard(1, 2, 3)));
        System.out.println(Arrays.toString(test.divingBoard(1, 1, 3)));
        System.out.println(Arrays.toString(test.divingBoard(2, 5, 3)));
        System.out.println(Arrays.toString(test.divingBoard(1, 1, 0)));
        System.out.println(Arrays.toString(test.divingBoard(0, 0, 0)));
        System.out.println(Arrays.toString(test.divingBoard(1, 1, 100000)));
        System.out.println(Arrays.toString(test.divingBoard(1, 2, 100000)));
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        int min = k * shorter;
        int max = k * longer;
        int step = longer - shorter;

        int[] arr = new int[(max - min) / step + 1];
        for (int i = min, j = 0; i <= max; i += step, j++) {
            arr[j] = i;
        }
        return arr;
    }
/*
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            int[] a = new int[1];
            a[0] = shorter * k;
            return a;
        }
        List<Integer> result = new ArrayList<>();
        divingBoard(shorter, longer, k, result, 0, -1);
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    public void divingBoard(int shorter, int longer, int k, List<Integer> result, int sum, int pre) {
        if (k == 0) {
            if (!result.contains(sum)) {
                result.add(sum);
            }
        } else if (pre == longer) {
            divingBoard(shorter, longer, k - 1, result, sum + longer, longer);
        } else {
            divingBoard(shorter, longer, k - 1, result, sum + shorter, shorter);
            divingBoard(shorter, longer, k - 1, result, sum + longer, longer);
        }
    }*/
}
