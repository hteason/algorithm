package htc.leetcode.everyday._2020._11;

import htc.leetcode.datatype.TreeNode;

/**
 * AC
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 *
 * @date 2020/11/24
 */
public class _24_222_完全二叉树的节点个数 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
