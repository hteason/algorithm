package htc.leetcode.other;

import htc.leetcode.datatype.TreeNode;

/**
 * 617 �ϲ�������
 * 
 * ���������������������㽫�����е�һ�����ǵ���һ����ʱ��������������һЩ�ڵ����ص���
 * 
 * ����Ҫ�����Ǻϲ�Ϊһ���µĶ��������ϲ��Ĺ�������������ڵ��ص�����ô�����ǵ�ֵ�����Ϊ�ڵ�ϲ������ֵ������Ϊ NULL
 * �Ľڵ㽫ֱ����Ϊ�¶������Ľڵ㡣
 * 
 * Definition for a binary tree node.
 * 
 */


public class MergeTrees {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.left.left = new TreeNode(5);
		t1.right = new TreeNode(2);
		
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.left.right = new TreeNode(4);
		t2.right = new TreeNode(3);
		t2.right.right = new TreeNode(7);

		mergeTrees(t1, t2);
	}
	
	
	
	//TODO unfinished
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1==null && t2==null) {
			return t1;
		}
		int t1Val = 0;
		if(t1!=null) {
			t1Val = t1.val;
		}
		int t2Val = 0;
		if(t2!=null) {
			t2Val = t2.val;
		}
		t1.left = new TreeNode(t1Val+t2Val);
		mergeTrees(t1.left, t2.left);
		t1.right = new TreeNode(t1Val+t2Val);
		mergeTrees(t1.right, t2.right);
		return t1;
	}
}
