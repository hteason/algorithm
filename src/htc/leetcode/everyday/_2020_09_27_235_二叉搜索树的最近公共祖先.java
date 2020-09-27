package htc.leetcode.everyday;

import htc.leetcode.datatype.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * AC
 * 暴力
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class _2020_09_27_235_二叉搜索树的最近公共祖先 {
    public static void main(String[] args) {
        _2020_09_27_235_二叉搜索树的最近公共祖先 test = new _2020_09_27_235_二叉搜索树的最近公共祖先();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

//        System.out.println(test.lowestCommonAncestor(root, root, root));//6
//        System.out.println(test.lowestCommonAncestor(root, root.left, root.right));//6
        System.out.println(test.lowestCommonAncestor(root, root.left, root.left.right));//2
//        System.out.println(test.lowestCommonAncestor(root, root.left.left, root.left.right));//2
//        System.out.println(test.lowestCommonAncestor(root, root.left.left, root.left.right.right));//2
//        System.out.println(test.lowestCommonAncestor(root, root.right.right, root.left.right.right));//6
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> pq = new ArrayDeque<>();
        Deque<TreeNode> qq = new ArrayDeque<>();
        dfs(root, p.val, q.val, pq, qq);
        if (pq.isEmpty() || qq.isEmpty()) {
            return root;
        }

        TreeNode ans = null;
        TreeNode pqt = null;
        TreeNode qqt = null;
        while (!pq.isEmpty() && !qq.isEmpty()) {
            pqt = pq.pollFirst();
            qqt = qq.pollFirst();
            if (pqt != qqt) {
                break;
            }else {
                ans = pqt;
            }
        }
        System.out.println(ans.val);
        return ans;
    }

    boolean foundP = false;
    boolean foundQ = false;

    public void dfs(TreeNode root, int p, int q, Deque<TreeNode> pq, Deque<TreeNode> qq) {
        if (root == null) {
            return;
        }
        int val = root.val;
        if (!foundP) {
            pq.add(root);
        }
        if (!foundQ) {
            qq.add(root);
        }
        if (val == p) {
            foundP = true;
        }
        if (val == q) {
            foundQ = true;
        }
        if (foundP && foundQ) {
            return;
        }
        dfs(root.left, p, q, pq, qq);
        dfs(root.right, p, q, pq, qq);
        if (!foundP) {
            pq.pollLast();
        }
        if (!foundQ) {
            qq.pollLast();
        }
    }
}
