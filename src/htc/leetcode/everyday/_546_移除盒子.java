package htc.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Not AC
 * https://leetcode-cn.com/problems/remove-boxes/
 */
public class _546_ÒÆ³ýºÐ×Ó {
    public static void main(String[] args) {
        _546_ÒÆ³ýºÐ×Ó test = new _546_ÒÆ³ýºÐ×Ó();
        System.out.println(test.removeBoxes(new int[]{1,3,2,2,2,3,4,3,1}));
        System.out.println(test.removeBoxes(new int[]{1,3,2,2,4,4,2,2,3,4,3,1}));
    }
    public int removeBoxes(int[] boxes) {
        Map<Integer,Integer> count = new HashMap<>();
        for (int num:  boxes) {
            count.put(num,count.getOrDefault(num,0)+1);
        }
        int ans = 0;
        for (Map.Entry<Integer,Integer> e:count.entrySet()){
            ans += e.getValue()*e.getValue();
        }
        return ans;
    }
}
