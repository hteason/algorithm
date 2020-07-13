package htc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import htc.leetcode.datatype.TreeNode;
/*
 * AC
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */
public class _173_���������������� {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);
		_173_���������������� ths = new _173_����������������();
		BSTIterator iterator = ths.new BSTIterator(root);
		iterator.next(); // ���� 3
		iterator.next(); // ���� 7
		iterator.hasNext(); // ���� true
		iterator.next(); // ���� 9
		iterator.hasNext(); // ���� true
		iterator.next(); // ���� 15
		iterator.hasNext(); // ���� true
		iterator.next(); // ���� 20
		iterator.hasNext(); // ���� false
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
				//�������ҽڵ㣬���ҽڵ㼰����������ջ
				left2stack(pop.right);
			}
			return pop.val;
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}
	}
	
	// �ռ临�Ӷ�ΪO(n)��������Ҫ��
	class BSTIterator_list {

		List<Integer> list;

		public BSTIterator_list(TreeNode root) {
			list = new ArrayList<Integer>();
			// �������������list
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
