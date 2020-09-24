package htc.leetcode.everyday;

import htc.leetcode.datatype.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _538_把二叉搜索树转换为累加树 {
    public static void main(String[] args) {
    }

    public TreeNode convertBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        convertBST(root, list);
        System.out.print(list);
        return root;
    }

    public void dfs(TreeNode root, List<Integer> list) {

    }

    public void convertBST(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        convertBST(root.left, list);
        convertBST(root.right, list);
    }
}
