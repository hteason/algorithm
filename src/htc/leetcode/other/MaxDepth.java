package htc.leetcode.other;

import htc.leetcode.datatype.TreeNode;

/**
 * 104. ��������������

����һ�����������ҳ��������ȡ�

�����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����

 * Definition for a binary tree node.
 * 
 */

public class MaxDepth {
	public static void main(String[] args) {
		int i = 0;
	}
	//TODO unfinished
    public int maxDepth(TreeNode root) {
        return root == null ? 0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}