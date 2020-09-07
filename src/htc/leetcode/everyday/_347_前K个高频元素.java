package htc.leetcode.everyday;

import java.util.*;

/**
 * AC
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class _347_前K个高频元素 {
    public static void main(String[] args) {
        _347_前K个高频元素 test = new _347_前K个高频元素();
        System.out.println(Arrays.toString(test.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(test.topKFrequent(new int[]{1}, 1)));
        System.out.println(Arrays.toString(test.topKFrequent(new int[]{1, 2}, 1)));
    }

    //慢
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue() - e1.getValue());
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).getKey();
        }
        return ans;
    }
}
