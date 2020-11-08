package htc.leetcode.everyday._2020._09;

import htc.leetcode.datatype.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _2020_09_04_257_二叉树的所有路径 {
    public static void main(String[] args) {
        _2020_09_04_257_二叉树的所有路径 test = new _2020_09_04_257_二叉树的所有路径();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(test.binaryTreePaths(root));
    }


    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        dfs(root, ans, String.valueOf(root.val));
        return ans;
    }

    //深搜,慢
    public void dfs(TreeNode root, List<String> ans, String s) {
        if (root.left == null && root.right == null) {
            ans.add(s);
        }
        if (root.left != null) {
            dfs(root.left, ans, s + "->" + root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, ans, s + "->" + root.right.val);
        }
    }
}
