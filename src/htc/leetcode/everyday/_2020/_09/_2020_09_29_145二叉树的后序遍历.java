package htc.leetcode.everyday._2020._09;

import htc.leetcode.datatype.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * AC
 * dfs解决，应进阶解决：迭代
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class _2020_09_29_145二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        dfs(root, ans);
        return ans;
    }

    //深搜
    public void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }
}
