package htc.leetcode.everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * AC
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class _2020_07_20_167_����֮��_II_������������ {
    public static void main(String[] args) {
        _2020_07_20_167_����֮��_II_������������ test = new _2020_07_20_167_����֮��_II_������������();
        System.out.println(Arrays.toString(test.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(test.twoSum(new int[]{2, 7, 11, 15}, 17)));
        System.out.println(Arrays.toString(test.twoSum(new int[]{2, 7, 11, 15}, 13)));
        System.out.println(Arrays.toString(test.twoSum(new int[]{2, 7, 11, 15}, 14)));
        System.out.println(Arrays.toString(test.twoSum(new int[]{0, 0, 3, 4}, 0)));
    }

    /**
     * ��ϣ��ⷨ���ⷨ�����������ο�
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            //��ֵ���±�浽HashMap��
            //�����ڶ����ͬ��keyʱҲ�ܽ��
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            //target��ȥindex1��ֵ��Map���ڶ�Ӧindex2��key,˵��index1��index2��Գɹ���ֱ�ӷ��ؽ��
            if (map.containsKey(target - numbers[i])) {
                return new int[]{i + 1, map.get(target - numbers[i]) + 1};
            }
        }
        return null;
    }
//    ���ߣ�hteason
//    ���ӣ�https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/ti-gong-yi-chong-javade-ha-xi-jie-fa-by-hteason/
//    ��Դ�����ۣ�LeetCode��
//    ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
}
