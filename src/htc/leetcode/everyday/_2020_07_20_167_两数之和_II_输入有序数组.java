package htc.leetcode.everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * AC
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class _2020_07_20_167_两数之和_II_输入有序数组 {
    public static void main(String[] args) {
        _2020_07_20_167_两数之和_II_输入有序数组 test = new _2020_07_20_167_两数之和_II_输入有序数组();
        System.out.println(Arrays.toString(test.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(test.twoSum(new int[]{2, 7, 11, 15}, 17)));
        System.out.println(Arrays.toString(test.twoSum(new int[]{2, 7, 11, 15}, 13)));
        System.out.println(Arrays.toString(test.twoSum(new int[]{2, 7, 11, 15}, 14)));
        System.out.println(Arrays.toString(test.twoSum(new int[]{0, 0, 3, 4}, 0)));
    }

    /**
     * 哈希表解法，解法较慢，仅供参考
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            //将值和下标存到HashMap里
            //当存在多个相同的key时也能解决
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            //target减去index1的值后Map存在对应index2的key,说明index1和index2配对成功，直接返回结果
            if (map.containsKey(target - numbers[i])) {
                return new int[]{i + 1, map.get(target - numbers[i]) + 1};
            }
        }
        return null;
    }
//    作者：hteason
//    链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/ti-gong-yi-chong-javade-ha-xi-jie-fa-by-hteason/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
