package htc.leetcode.hash_table;

import java.util.Arrays;

/**
 * ����AC
 * TODO ���Ż��ⷨ������ջ
 * ��Ŀ��https://leetcode-cn.com/problems/next-greater-element-ii/
 */
public class _503_��һ������Ԫ��II {
    public static void main(String[] args) {
        _503_��һ������Ԫ��II test = new _503_��һ������Ԫ��II();
        System.out.println(Arrays.toString(test.nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(test.nextGreaterElements(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(test.nextGreaterElements(new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100})));
    }

    /**
     * ��������
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0, len = nums.length; i < len; i++) {
            int nextMax = -1;
            //������ĩβ����ģ,������ͷ��ʼ����
            for (int j = i + 1; j % len != i; j++) {
                if (nums[j % len] > nums[i]) {
                    nextMax = nums[j % len];
                    break;
                }
            }
            res[i] = nextMax;
        }
        return res;
    }
}
