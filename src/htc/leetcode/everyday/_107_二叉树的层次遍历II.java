package htc.leetcode.everyday;

import htc.leetcode.datatype.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * AC
 * 两个队列cur和next，迭代遍历，边遍历当前队列边存到内层List，遍历完一层存到外层List
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class _107_二叉树的层次遍历II {

    public static void main(String[] args) {
        _107_二叉树的层次遍历II test = new _107_二叉树的层次遍历II();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(test.levelOrderBottom(root));
    }

    //BFS 慢
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> cur = new LinkedBlockingQueue<>();
        cur.add(root);
        while (!cur.isEmpty()) {
            Queue<TreeNode> next = new LinkedBlockingQueue<>();
            List<Integer> inner = new ArrayList<>();
            for (TreeNode node : cur) {
                inner.add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            list.add(0, inner);
            cur = next;
        }
        return list;
    }

    //数组 超出内存限制
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        TreeNode[] cur = new TreeNode[1];
        cur[0] = root;
        for (int size = 2; ; size *= 2) {
            int index = 0;
            TreeNode[] next = new TreeNode[size];
            List<Integer> inner = new ArrayList<>();
            for (TreeNode node : cur) {
                if (node == null) {
                    break;
                }
                inner.add(node.val);
                if (node.left != null) {
                    next[index++] = node.left;
                }
                if (node.right != null) {
                    next[index++] = node.right;
                }
            }
            //插到头部
            list.add(0, inner);
            if (index == 0) {
                break;
            }
            cur = next;
        }
        return list;
    }
}
