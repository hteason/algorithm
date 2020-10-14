package htc.leetcode.everyday;

import java.util.*;

/**
 * AC
 * https://leetcode-cn.com/problems/find-common-characters/
 */
public class _1002_查找常用字符 {
    public static void main(String[] args) {
        _1002_查找常用字符 test = new _1002_查找常用字符();
        System.out.println(test.commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(test.commonChars(new String[]{"cool", "lock", "cook"}));
        System.out.println(test.commonChars(new String[]{"abc", "def", "ghijk"}));
        System.out.println(test.commonChars(new String[]{"abc"}));
        System.out.println(test.commonChars(new String[]{}));
    }

    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0) {
            return new ArrayList<>();
        }
        if (A.length == 1) {
            return Arrays.asList(A);
        }

        Map<Character, Integer>[] map = new Map[A.length];
        for (int i = 0, len = A.length; i < len; i++) {
            map[i] = new HashMap<>(A[i].length());
            for (char c : A[i].toCharArray()) {
                map[i].put(c, map[i].getOrDefault(c, 0) + 1);
            }
        }
        Map<Character, Integer> res = map[0];
        for (int i = 1; i < map.length; i++) {
            Map<Character, Integer> m = map[i];
            for (Map.Entry<Character, Integer> e : res.entrySet()) {
                Character k = e.getKey();
                if (m.containsKey(k)) {
                    Integer value = e.getValue();
                    Integer times = m.get(k);
                    res.put(k, value < times ? value : times);
                } else {
                    res.put(k, 0);
                }
            }
        }
        List<String> ans = new ArrayList<>(res.size());
        for (Map.Entry<Character, Integer> e : res.entrySet()) {
            Character key = e.getKey();
            for (int i = 0, times = e.getValue(); i < times; i++) {
                ans.add(String.valueOf(key));
            }
        }
        return ans;
    }
}
