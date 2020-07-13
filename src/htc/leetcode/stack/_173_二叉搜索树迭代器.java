package htc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import htc.leetcode.datatype.TreeNode;
/*
 * AC
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */
public class _173_二叉搜索树迭代器 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);
		_173_二叉搜索树迭代器 ths = new _173_二叉搜索树迭代器();
		BSTIterator iterator = ths.new BSTIterator(root);
		iterator.next(); // 返回 3
		iterator.next(); // 返回 7
		iterator.hasNext(); // 返回 true
		iterator.next(); // 返回 9
		iterator.hasNext(); // 返回 true
		iterator.next(); // 返回 15
		iterator.hasNext(); // 返回 true
		iterator.next(); // 返回 20
		iterator.hasNext(); // 返回 false
	}

	//86% 31%
	class BSTIterator {
		Stack<TreeNode> stack;

		public BSTIterator(TreeNode root) {
			stack = new Stack<>();
			left2stack(root);
		}

		private void left2stack(TreeNode root) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
		}

		public int next() {
			TreeNode pop = stack.pop();
			if (pop.right != null) {
				//若存在右节点，将右节点及其左子树入栈
				left2stack(pop.right);
			}
			return pop.val;
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}
	}
	
	// 空间复杂度为O(n)，不符合要求
	class BSTIterator_list {

		List<Integer> list;

		public BSTIterator_list(TreeNode root) {
			list = new ArrayList<Integer>();
			// 中序遍历，加入list
			inOrder(root);
		}

		private void inOrder(TreeNode root) {
			if (root != null) {
				inOrder(root.left);
				list.add(root.val);
				inOrder(root.right);
			}
		}

		public int next() {
			return list.remove(0);
		}

		public boolean hasNext() {
			return !list.isEmpty();
		}
	}

}
