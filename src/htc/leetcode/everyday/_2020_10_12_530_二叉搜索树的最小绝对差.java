package htc.leetcode.everyday;

import htc.leetcode.datatype.TreeNode;

import java.util.TreeSet;

/**
 * AC
 * 暴力解法 慢
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class _2020_10_12_530_二叉搜索树的最小绝对差 {

    public static void main(String[] args) {
        _2020_10_12_530_二叉搜索树的最小绝对差 test = new _2020_10_12_530_二叉搜索树的最小绝对差();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(test.getMinimumDifference(root));
    }

    boolean hasSame = false;
    public int getMinimumDifference(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        dfs(root, set);
        if (hasSame) {
            return 0;
        }
        if (set.size() == 1) {
            return root.val;
        }
        int min = Integer.MAX_VALUE;
        int i = 0;
        int pre = 0;
        for (Integer num : set) {
            if (i++ == 0) {
                pre = num;
                continue;
            }
            if (num - pre < min) {
                min = num - pre;
            }
            pre = num;
            i++;
        }
        return min;
    }

    private void dfs(TreeNode root, TreeSet<Integer> set) {
        if (root == null) {
            return;
        }
        if (set.contains(root.val)) {
            hasSame = true;
            return;
        }
        set.add(root.val);
        dfs(root.left, set);
        if (hasSame){
            return;
        }
        dfs(root.right, set);
    }
}
