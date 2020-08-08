package htc.leetcode.everyday;

import htc.leetcode.datatype.TreeNode;

/**
 * AC
 * https://leetcode-cn.com/problems/same-tree/
 */
public class _2020_08_07_100_相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //若同位置节点都为null，则此位置结构和值为相同
        if (p == null && q == null) {
            return true;
        }
        //执行到这里时说明至少有一个节点非空，若其中一个节点为空，则此位置结构肯定不等
        if (p == null || q == null) {
            return false;
        }
        //执行到这里说明p和q结构相同,此时判断值是否相同
        if (p.val != q.val) {
            return false;
        }
        //执行到这里说明上个位置结构和值都相同，递归判断下一左子节点
        //若子节点值不同，说明整棵树都不相同，直接返回结果
        if (!isSameTree(p.left, q.left)) {
            return false;
        }
        //递归判断右子节点，和上述左子树同理
        if (!isSameTree(p.right, q.right)) {
            return false;
        }
        return true;
    }
}
