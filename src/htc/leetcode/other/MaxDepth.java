package htc.leetcode.other;

import htc.leetcode.datatype.TreeNode;

/**
 * 104. 二叉树的最大深度

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

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