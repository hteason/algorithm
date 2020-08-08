package htc.leetcode.everyday;

import htc.leetcode.datatype.TreeNode;

/**
 * AC
 * https://leetcode-cn.com/problems/same-tree/
 */
public class _2020_08_07_100_��ͬ���� {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //��ͬλ�ýڵ㶼Ϊnull�����λ�ýṹ��ֵΪ��ͬ
        if (p == null && q == null) {
            return true;
        }
        //ִ�е�����ʱ˵��������һ���ڵ�ǿգ�������һ���ڵ�Ϊ�գ����λ�ýṹ�϶�����
        if (p == null || q == null) {
            return false;
        }
        //ִ�е�����˵��p��q�ṹ��ͬ,��ʱ�ж�ֵ�Ƿ���ͬ
        if (p.val != q.val) {
            return false;
        }
        //ִ�е�����˵���ϸ�λ�ýṹ��ֵ����ͬ���ݹ��ж���һ���ӽڵ�
        //���ӽڵ�ֵ��ͬ��˵��������������ͬ��ֱ�ӷ��ؽ��
        if (!isSameTree(p.left, q.left)) {
            return false;
        }
        //�ݹ��ж����ӽڵ㣬������������ͬ��
        if (!isSameTree(p.right, q.right)) {
            return false;
        }
        return true;
    }
}
