package htc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * AC
 * 题目: https://leetcode-cn.com/problems/build-an-array-with-stack-operations/
 * 题解: https://leetcode-cn.com/problems/build-an-array-with-stack-operations/solution/javayi-ci-bian-li-jian-dan-yi-dong-by-hteason/
 */
public class _1441_用栈操作构建数组 {
    public static void main(String[] args) {
        _1441_用栈操作构建数组 test = new _1441_用栈操作构建数组();
        System.out.println(test.buildArray(new int[]{1, 3}, 3));
        System.out.println(test.buildArray(new int[]{1, 2, 3}, 3));
        System.out.println(test.buildArray(new int[]{1, 2}, 4));
        System.out.println(test.buildArray(new int[]{2, 3, 4}, 4));
        System.out.println(test.buildArray(new int[]{1, 2, 3, 4}, 1));
        System.out.println(test.buildArray(new int[]{3}, 1));
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        //i从1遍历到n,同时从头开始对比target元素
        // 当元素i在target里面时只记录push操作,然后target移到下一元素
        // 否则丢弃该元素,即push再pop
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            if (i < target[j]) {
                //当i小于target当前值时,丢弃当前元素,即记录push再pop
                list.add("Push");
                list.add("Pop");
            } else if (i == target[j]) {
                //当元素i在target出现时,记录push操作,并开始比较target下一元素
                list.add("Push");
                j++;
            }
        }
        return list;
    }
}
