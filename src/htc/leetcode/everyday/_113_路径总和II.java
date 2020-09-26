package htc.leetcode.everyday;

import htc.leetcode.datatype.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * AC
 * 深搜+栈
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class _113_路径总和II {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        _113_路径总和II test = new _113_路径总和II();
        System.out.println(test.pathSum(root, 22));
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(test.pathSum(root, 1));
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Stack<Integer> stack = new Stack<>();
        dfs(root, sum, stack);
        return ans;
    }

    private void dfs(TreeNode root, int sum, Stack<Integer> stack) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            stack.push(root.val);
            List<Integer> sub = new ArrayList<>(stack.size());
            for (Integer num : stack) {
                sub.add(num);
                sum -= num;
            }
            if (sum == 0) {
                ans.add(sub);
            }
            if (!stack.isEmpty()) {
                stack.pop();
            }
            return;
        }
        stack.push(root.val);
        dfs(root.left, sum, stack);
        dfs(root.right, sum, stack);
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }
}
