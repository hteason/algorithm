package htc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import htc.leetcode.datatype.TreeNode;

/*
 * AC
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class _94_二叉树的中序遍历 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(5);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.left.left = new TreeNode(6);
		root.right.left.right = new TreeNode(7);
		System.out.println(inorderTraversal(root));
	}

	/*
	 * 1 / \ 4 2 / / \ 5 3 null / \ 6 7
	 * 
	 */
	// 73% 40%
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}

		Stack<TreeNode> stack = new Stack<>();
		// 1.将根节点root入栈
		stack.push(root);
		// 2. 栈为空时说明树遍历结束，退出循环
		while (!stack.isEmpty()) {
			// 3.当root非空时，将其左子树入栈,stack.push(root.left),
			// 并将root更新为左子树,直到左子树为null,执行步骤4
			if (root != null && root.left != null) {
				// 提前对左子树判空，优化内存消耗，减少stack.push(null)
				stack.push(root.left);
				root = root.left;
			} else {
				// 4. 此时左子树为null，弹出栈顶元素
				TreeNode pop = stack.pop();
				// 若栈顶元素非null，输出其值，且将其右子树入栈，
				// root更新为右子树，回到步骤3
				if (pop != null) {
					list.add(pop.val);
					// 提前对右子树判空，优化内存消耗
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
