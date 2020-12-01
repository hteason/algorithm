package htc.leetcode.everyday._2020._12;

/**
 * AC
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @date 2020/12/1
 */
public class _01_34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
            return ans;
        }
        int begin = 0;
        int end = nums.length - 1;
        int mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (nums[mid] < target) {
                begin = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                //向前后遍历
                begin = mid;
                end = mid;
                while (begin >= 0 && nums[begin] == target) {
                    ans[0] = begin--;
                }
                while (end < nums.length && nums[end] == target) {
                    ans[1] = end++;
                }
                return ans;
            }
        }
        return ans;
    }
}
