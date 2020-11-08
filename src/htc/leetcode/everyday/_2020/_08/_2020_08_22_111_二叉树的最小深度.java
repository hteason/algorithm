package htc.leetcode.everyday._2020._08;

import htc.leetcode.datatype.TreeNode;

/**
 * AC
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class _2020_08_22_111_二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else if (root.left != null) {
            return minDepth(root.left) + 1;
        } else if (root.right != null) {
            return minDepth(root.right) + 1;
        }
        return 1;
    }

    /**
     * 简洁，但可读性低
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return ((root.left != null && root.right != null) ? Math.min(minDepth(root.left), minDepth(root.right)) :
                root.left != null ? minDepth(root.left) :
                        root.right != null ? minDepth(root.right) : 0) + 1;
    }
}
