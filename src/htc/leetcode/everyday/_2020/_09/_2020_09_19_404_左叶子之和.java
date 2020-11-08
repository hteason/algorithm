package htc.leetcode.everyday._2020._09;

import htc.leetcode.datatype.TreeNode;

/**
 * AC
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class _2020_09_19_404_×óÒ¶×ÓÖ®ºÍ {

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }
}
