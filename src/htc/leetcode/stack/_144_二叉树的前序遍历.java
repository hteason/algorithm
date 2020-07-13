package htc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import htc.leetcode.datatype.TreeNode;

/*
 * AC
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class _144_��������ǰ����� {
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
			// �����ǰ�ڵ㲢����������
			while (root != null) {
				list.add(root.val);
				if (root.right != null) {
					// ���������ǿ�ʱ��ջ
					stack.push(root.right);
				}
				root = root.left;
			}
			// ����������������������������Ҷ�ӽڵ������������
			if (!stack.isEmpty()) {
				// ���¸��ڵ�Ϊ������,��ʼ����������
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
