package htc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import htc.leetcode.datatype.TreeNode;

/*
 * AC
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class _103_二叉树的锯齿形层次遍历 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(zigzagLevelOrder(root));
	}

	// 栈实现99.13%、21.04%
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Stack<TreeNode> evenLevel = new Stack<>();
		Stack<TreeNode> oddLevel = new Stack<>();
		evenLevel.push(root);
		for (int i = 0; !evenLevel.isEmpty() || !oddLevel.isEmpty(); i++) {
			List<Integer> cur = new ArrayList<Integer>();
			if ((i & 1) == 0) {
				// 偶数层,从0开始
				while (!evenLevel.isEmpty()) {
					TreeNode pop = evenLevel.pop();
					if (pop != null) {
						cur.add(pop.val);
						// 左子树先入栈，因为下一层（奇数层）时左子树最后访问到
						oddLevel.push(pop.left);
						oddLevel.push(pop.right);
					}
				}
			} else {
				// 奇数层
				while (!oddLevel.isEmpty()) {
					TreeNode pop = oddLevel.pop();
					if (pop != null) {
						cur.add(pop.val);
						// 右子树先入栈，因为下一层（偶数层）时右子树最后访问到
						evenLevel.push(pop.right);
						evenLevel.push(pop.left);
					}
				}
			}
			if (!cur.isEmpty()) {
				res.add(cur);
			}
		}
		return res;
	}

}
