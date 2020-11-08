package htc.leetcode.everyday._2020._07;

/**
 * AC
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class _2020_07_17_35_ËÑË÷²åÈëÎ»ÖÃ {
    public static void main(String[] args) {
        System.out.println(new _2020_07_17_35_ËÑË÷²åÈëÎ»ÖÃ().searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(new _2020_07_17_35_ËÑË÷²åÈëÎ»ÖÃ().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new _2020_07_17_35_ËÑË÷²åÈëÎ»ÖÃ().searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(new _2020_07_17_35_ËÑË÷²åÈëÎ»ÖÃ().searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(new _2020_07_17_35_ËÑË÷²åÈëÎ»ÖÃ().searchInsert(new int[]{1, 3, 6, 7}, 5));
        System.out.println(new _2020_07_17_35_ËÑË÷²åÈëÎ»ÖÃ().searchInsert(new int[]{1, 3, 6, 7}, 4));
        System.out.println(new _2020_07_17_35_ËÑË÷²åÈëÎ»ÖÃ().searchInsert(new int[]{1, 3, 6, 7}, 3));
        System.out.println(new _2020_07_17_35_ËÑË÷²åÈëÎ»ÖÃ().searchInsert(new int[]{1, 3, 6, 7}, -1));
        System.out.println(new _2020_07_17_35_ËÑË÷²åÈëÎ»ÖÃ().searchInsert(new int[]{1}, 1));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return searchInsert(nums, target, 0, nums.length);
    }

    private int searchInsert(int[] nums, int target, int begin, int end) {
        if (begin == end - 1) {
            return nums[begin] >= target ? begin : end;
        }
        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            begin = mid;
        } else {
            end = mid;
        }

        return searchInsert(nums, target, begin, end);

    }
}
