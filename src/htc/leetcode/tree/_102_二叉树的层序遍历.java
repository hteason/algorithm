package htc.leetcode.tree;

import htc.leetcode.datatype.TreeNode;
import htc.leetcode.everyday._107_�������Ĳ�α���II;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * AC
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * �ֵ��⣺https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class _102_�������Ĳ������ {

    public static void main(String[] args) {
        _102_�������Ĳ������ test = new _102_�������Ĳ������();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(test.levelOrderBottom(root));
    }

    //BFS ��
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
            list.add(inner);
            cur = next;
        }
        return list;
    }
}
