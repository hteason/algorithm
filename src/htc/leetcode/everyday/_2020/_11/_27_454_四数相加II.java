package htc.leetcode.everyday._2020._11;

import java.util.HashMap;
import java.util.Map;

/**
 * AC
 * https://leetcode-cn.com/problems/4sum-ii/
 *
 * @date 2020/11/27
 */
public class _27_454_�������II {
    public static void main(String[] args) {
        _27_454_�������II test = new _27_454_�������II();
        System.out.println(test.fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 1}
        ));
    }

    /**
     * ���Ա��� X
     */
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        for (int a : A) {
            for (int b : B) {
                for (int c : C) {
                    for (int d : D) {
                        if (a + b + c + d == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * ����
     */
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map1 = new HashMap<>(A.length);
        for (int a : A) {
            for (int b : B) {
                map1.put(a + b, map1.getOrDefault(a + b, 0) + 1);
            }
        }
        Map<Integer, Integer> map2 = new HashMap<>(A.length);
        for (int c : C) {
            for (int d : D) {
                map2.put(c + d, map2.getOrDefault(c + d, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> e : map1.entrySet()) {
            Integer key = e.getKey();
            if (map2.containsKey(-key)) {
                count += e.getValue() * map2.get(-key);
            }
        }
        return count;
    }

    /**
     * �Ż�����2��һ��map,�������
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(A.length);
        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                count += map.getOrDefault(-c - d, 0);
            }
        }
        return count;
    }
}
