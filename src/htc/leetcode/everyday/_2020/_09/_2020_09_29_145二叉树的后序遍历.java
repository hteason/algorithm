package htc.leetcode.everyday._2020._09;

import htc.leetcode.datatype.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * AC
 * dfs�����Ӧ���׽��������
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class _2020_09_29_145�������ĺ������ {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        dfs(root, ans);
        return ans;
    }

    //����
    public void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }
}
