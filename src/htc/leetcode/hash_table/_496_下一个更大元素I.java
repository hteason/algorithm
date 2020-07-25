package htc.leetcode.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * AC
 * 题目：https://leetcode-cn.com/problems/next-greater-element-i/
 * 题解：https://leetcode-cn.com/problems/next-greater-element-i/solution/wo-xun-si-zhao-zhi-jie-yong-mapbu-shi-ke-yi-jie-ju/
 */
public class _496_下一个更大元素I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //map存储nums2中每个元素的下一个最大值
        Map<Integer, Integer> map = new HashMap<>();
        //逆序遍历nums2,其实正序遍历也可以,就不改了
        for (int i = nums2.length - 1; i >= 0; i--) {
            //默认不存在下一个最大值,key对应value为-1
            int nextMax = -1;
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    //当第一次出现下一个更大值时,更新nextMax并退出本次循环
                    nextMax = nums2[j];
                    break;
                }
            }
            //存储nums2中每个元素的下一个更大值
            map.put(nums2[i], nextMax);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            //遍历nums1，从map中获取对应的下一个更大值
            /*
             补充说明：因为nums1为nums2子集,所以get的时候是不会出现null的情况,做题的时候考虑了非子集情况,
                    多做了判断,可以直接写成res[i] = map.get(nums1[i]);
             */
            res[i] = map.get(nums1[i]) == null ? -1 : map.get(nums1[i]);
        }
        return res;
    }
}
