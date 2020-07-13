package htc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import htc.leetcode.datatype.TreeNode;

/*
 * AC
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class _94_��������������� {
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
		// 1.�����ڵ�root��ջ
		stack.push(root);
		// 2. ջΪ��ʱ˵���������������˳�ѭ��
		while (!stack.isEmpty()) {
			// 3.��root�ǿ�ʱ��������������ջ,stack.push(root.left),
			// ����root����Ϊ������,ֱ��������Ϊnull,ִ�в���4
			if (root != null && root.left != null) {
				// ��ǰ���������пգ��Ż��ڴ����ģ�����stack.push(null)
				stack.push(root.left);
				root = root.left;
			} else {
				// 4. ��ʱ������Ϊnull������ջ��Ԫ��
				TreeNode pop = stack.pop();
				// ��ջ��Ԫ�ط�null�������ֵ���ҽ�����������ջ��
				// root����Ϊ���������ص�����3
				if (pop != null) {
					list.add(pop.val);
					// ��ǰ���������пգ��Ż��ڴ�����
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
