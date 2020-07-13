package htc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import htc.leetcode.datatype.TreeNode;

public class _145_二叉树的后序遍历 {
	public static void main(String[] args) {
		int TODO;//还不想做
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		System.out.println(postorderTraversal(root));
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (root != null) {
			while (root.right != null) {
				root = root.right;
				stack.push(root);
			}
			if (root.left != null) {
				root = root.left;
				stack.push(root);
//				System.out.println(root.val);
			}
			if (!stack.isEmpty() && root.left == null && root.right == null) {
				System.out.println(root.val);
				root = stack.pop();
			} else {
				root = null;
			}
		}

		return null;
	}
}
