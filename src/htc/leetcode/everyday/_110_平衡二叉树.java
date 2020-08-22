package htc.leetcode.everyday;

import htc.leetcode.datatype.TreeNode;

/**
 * TODO Not AC
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class _110_Æ½ºâ¶þ²æÊ÷ {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        System.out.println(max(root,0) + " " + min(root,0));
       return max(root,0) - min(root,0) < 2;
    }

    public int min(TreeNode root, int deep) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(min(root.left, deep++), min(root.right, deep++));
    }

    public int max(TreeNode root, int deep) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(max(root.left, deep++), max(root.right, deep++));
    }
}
