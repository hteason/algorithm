package htc.leetcode.everyday._2020._12;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author huangtingcheng
 * @date 2020/12/25
 */
public class _12_25_455_分发饼干 {
    public static void main(String[] args) {
        _12_25_455_分发饼干 test = new _12_25_455_分发饼干();
        System.out.println(test.findContentChildren(new int[]{1, 2, 3}, new int[]{3}));
        System.out.println(test.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(test.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println(test.findContentChildren(new int[]{1, 2}, new int[]{1, 1, 2}));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        int count = 0;
        for (int a : g) {
            for (int j = 0; j < s.length; j++) {
                if (a <= s[j] && s[j] != 0) {
                    s[j] = 0;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    //超时
    public int findContentChildren1(int[] g, int[] s) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : s) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for (int a : g) {
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue() > 0 && a <= e.getKey()) {
                    map.put(e.getKey(), e.getValue() - 1);
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
