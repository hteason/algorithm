package htc.leetcode.everyday._2020._07;

import htc.leetcode.datatype.TreeNode;

/**
 * AC
 * 题目：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class _2020_07_28_104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        //递归遍历，取最大值
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
