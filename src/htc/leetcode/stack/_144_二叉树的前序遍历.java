package htc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import htc.leetcode.datatype.TreeNode;

/*
 * AC
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class _144_二叉树的前序遍历 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right = new TreeNode(3);
		root.right.right = new TreeNode(6);

		System.out.println(preorderTraversal(root));
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();

		while (root != null) {
			// 输出当前节点并遍历左子树
			while (root != null) {
				list.add(root.val);
				if (root.right != null) {
					// 当右子树非空时入栈
					stack.push(root.right);
				}
				root = root.left;
			}
			// 左子树遍历结束，遍历离左子树叶子节点最近的右子树
			if (!stack.isEmpty()) {
				// 更新根节点为右子树,开始遍历右子树
				root = stack.pop();
			}
		}
		return list;
	}

//	private static void preorder(TreeNode root) {
//		if (root != null) {
//			System.out.println(root.val);
//			preorder(root.left);
//			preorder(root.right);
//		}
//	}

}
