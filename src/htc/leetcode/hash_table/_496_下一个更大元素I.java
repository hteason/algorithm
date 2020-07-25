package htc.leetcode.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * AC
 * ��Ŀ��https://leetcode-cn.com/problems/next-greater-element-i/
 * ��⣺https://leetcode-cn.com/problems/next-greater-element-i/solution/wo-xun-si-zhao-zhi-jie-yong-mapbu-shi-ke-yi-jie-ju/
 */
public class _496_��һ������Ԫ��I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //map�洢nums2��ÿ��Ԫ�ص���һ�����ֵ
        Map<Integer, Integer> map = new HashMap<>();
        //�������nums2,��ʵ�������Ҳ����,�Ͳ�����
        for (int i = nums2.length - 1; i >= 0; i--) {
            //Ĭ�ϲ�������һ�����ֵ,key��ӦvalueΪ-1
            int nextMax = -1;
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    //����һ�γ�����һ������ֵʱ,����nextMax���˳�����ѭ��
                    nextMax = nums2[j];
                    break;
                }
            }
            //�洢nums2��ÿ��Ԫ�ص���һ������ֵ
            map.put(nums2[i], nextMax);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            //����nums1����map�л�ȡ��Ӧ����һ������ֵ
            /*
             ����˵������Ϊnums1Ϊnums2�Ӽ�,����get��ʱ���ǲ������null�����,�����ʱ�����˷��Ӽ����,
                    �������ж�,����ֱ��д��res[i] = map.get(nums1[i]);
             */
            res[i] = map.get(nums1[i]) == null ? -1 : map.get(nums1[i]);
        }
        return res;
    }
}
