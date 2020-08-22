package htc.leetcode.tree;

import htc.leetcode.datatype.TreeNode;

public class _101_�Գƶ����� {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(2);
		t1.left = new TreeNode(3);
		t1.left.left = new TreeNode(4);
		t1.left.right = new TreeNode(5);
		t1.right = new TreeNode(3);
		t1.right.left = new TreeNode(5);
		//	        t1.right.right = new TreeNode(3);
		System.out.println(isSymmetric(t1));
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		if (root.left == null || root.right == null)
			return false;
		TreeNode nodeL = root.left;
		TreeNode nodeR = root.right;
		while (nodeL != null && nodeR != null) {
			if (nodeL.left != null && nodeR.right != null) {
				//���������=�ҽ����Һ��� && ����������Һ���&&�ҽ������Ӷ�Ϊ�գ� || ��������Һ���=�ҽ������ӣ���
				if (nodeL.left.val == nodeR.right.val
						&& ((nodeL.right == null && nodeR.left == null)
								|| (nodeL.right.val == nodeR.left.val))) {
					nodeL = nodeL.left;
					nodeR = nodeR.right;
				} else {
					return false;
				}
			} else if (nodeL.right != null && nodeR.left != null) {
				if (nodeL.right.val == nodeR.left.val
						&& ((nodeL.left == null && nodeR.right == null)
								|| (nodeL.left.val == nodeR.right.val))) {
					nodeL = nodeL.right;
					nodeR = nodeR.left;
				} else {
					return false;
				}
			} else if (nodeL.left == null && nodeL.right == null
					&& nodeR.left == null && nodeR.right == null) { //Ҷ�ӽ��
				if (nodeL.val == nodeR.val)
					return true;
				else
					return false;
			} else {
				return false;
			}

		}
		return true;
	}
}
