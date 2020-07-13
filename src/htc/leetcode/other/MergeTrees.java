package htc.leetcode.other;

import htc.leetcode.datatype.TreeNode;

/**
 * 617 合并二叉树
 * 
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL
 * 的节点将直接作为新二叉树的节点。
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
