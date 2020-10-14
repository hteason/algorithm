package htc.leetcode.everyday;

import java.util.*;

/**
 * AC
 * 推荐桶计数解法
 * https://leetcode-cn.com/problems/find-common-characters/
 */

public class _1002_查找常用字符 {
    public static void main(String[] args) {
        _1002_查找常用字符 test = new _1002_查找常用字符();
        System.out.println(test.commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(test.commonChars(new String[]{"cool", "lock", "cook"}));
        System.out.println(test.commonChars(new String[]{"abc", "def", "ghijk"}));
        System.out.println(test.commonChars(new String[]{"abc"}));
    }

    /**
     * 桶计数：
     * 一维数组下标代表字母，0-a 1-b ... 25-z
     * 二维下标代表对应字母出现了多少次
     * 如：["bella","label","roller"]最后计数对应为
     * [1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
     * [1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
     * [0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0]
     * <p>
     * 最后从上往下纵向对比取最小值min，然后把对应字母重复min次插入List中
     * 比如上例下标0从上往下取值分别是[1,1,0],最小值为0，说明a最终出现0次，
     * 同理，下标4(对应e)分别为[1,1,1],最小值为1,e最终出现1次
     * 同理，下标11(l)出现2次
     * 其他均为0次
     * 结果为 e,l,l
     */
    public List<String> commonChars(String[] A) {
        int[][] map = new int[A.length][26];
        for (int i = 0, len = A.length; i < len; i++) {
            for (char c : A[i].toCharArray()) {
                map[i][c - 'a'] = map[i][c - 'a'] + 1;
            }
        }
        List<String> ans = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < A.length; j++) {
                min = Math.min(map[j][i], min);
            }
            for (int k = 0; k < min; k++) {
                ans.add(String.valueOf((char) ('a' + i)));
            }
        }
        return ans;
    }

    /**
     * 哈希计数，耗内存耗时
     */
    public List<String> commonChars1(String[] A) {
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
