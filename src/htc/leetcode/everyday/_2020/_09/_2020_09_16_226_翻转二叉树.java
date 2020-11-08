package htc.leetcode.everyday._2020._09;

import htc.leetcode.datatype.TreeNode;

/**
 * AC
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _2020_09_16_226_·­×ª¶þ²æÊ÷ {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }
}
