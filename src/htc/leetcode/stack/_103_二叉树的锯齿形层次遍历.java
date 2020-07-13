package htc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import htc.leetcode.datatype.TreeNode;

/*
 * AC
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class _103_�������ľ���β�α��� {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(zigzagLevelOrder(root));
	}

	// ջʵ��99.13%��21.04%
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Stack<TreeNode> evenLevel = new Stack<>();
		Stack<TreeNode> oddLevel = new Stack<>();
		evenLevel.push(root);
		for (int i = 0; !evenLevel.isEmpty() || !oddLevel.isEmpty(); i++) {
			List<Integer> cur = new ArrayList<Integer>();
			if ((i & 1) == 0) {
				// ż����,��0��ʼ
				while (!evenLevel.isEmpty()) {
					TreeNode pop = evenLevel.pop();
					if (pop != null) {
						cur.add(pop.val);
						// ����������ջ����Ϊ��һ�㣨�����㣩ʱ�����������ʵ�
						oddLevel.push(pop.left);
						oddLevel.push(pop.right);
					}
				}
			} else {
				// ������
				while (!oddLevel.isEmpty()) {
					TreeNode pop = oddLevel.pop();
					if (pop != null) {
						cur.add(pop.val);
						// ����������ջ����Ϊ��һ�㣨ż���㣩ʱ�����������ʵ�
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
