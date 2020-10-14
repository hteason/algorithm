package htc.leetcode.everyday;

import java.util.*;

/**
 * AC
 * �Ƽ�Ͱ�����ⷨ
 * https://leetcode-cn.com/problems/find-common-characters/
 */

public class _1002_���ҳ����ַ� {
    public static void main(String[] args) {
        _1002_���ҳ����ַ� test = new _1002_���ҳ����ַ�();
        System.out.println(test.commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(test.commonChars(new String[]{"cool", "lock", "cook"}));
        System.out.println(test.commonChars(new String[]{"abc", "def", "ghijk"}));
        System.out.println(test.commonChars(new String[]{"abc"}));
    }

    /**
     * Ͱ������
     * һά�����±������ĸ��0-a 1-b ... 25-z
     * ��ά�±�����Ӧ��ĸ�����˶��ٴ�
     * �磺["bella","label","roller"]��������ӦΪ
     * [1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
     * [1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
     * [0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0]
     * <p>
     * ��������������Ա�ȡ��Сֵmin��Ȼ��Ѷ�Ӧ��ĸ�ظ�min�β���List��
     * ���������±�0��������ȡֵ�ֱ���[1,1,0],��СֵΪ0��˵��a���ճ���0�Σ�
     * ͬ���±�4(��Ӧe)�ֱ�Ϊ[1,1,1],��СֵΪ1,e���ճ���1��
     * ͬ���±�11(l)����2��
     * ������Ϊ0��
     * ���Ϊ e,l,l
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
     * ��ϣ���������ڴ��ʱ
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
