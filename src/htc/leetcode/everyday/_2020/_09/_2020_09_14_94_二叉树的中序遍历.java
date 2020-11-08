package htc.leetcode.everyday._2020._09;

import htc.leetcode.datatype.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _2020_09_14_94_二叉树的中序遍历 {
    //BFS
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (root != null && root.left != null) {
                stack.push(root.left);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                if (pop != null) {
                    list.add(pop.val);
                    if (pop.right != null) {
                        stack.push(pop.right);
                        root = pop.right;
                    }
                }
            }
        }
        return list;
    }
}
