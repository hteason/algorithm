package htc.leetcode.everyday._2020._07;

import htc.leetcode.datatype.TreeNode;

/**
 * AC
 * ��Ŀ��https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class _2020_07_28_104_�������������� {
    public int maxDepth(TreeNode root) {
        //�ݹ������ȡ���ֵ
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
