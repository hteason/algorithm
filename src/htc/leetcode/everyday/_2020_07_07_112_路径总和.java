package htc.leetcode.everyday;

import htc.leetcode.datatype.TreeNode;

public class _2020_07_07_112_路径总和 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);


        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22));
        System.out.println(hasPathSum(new TreeNode(1), 0));
        System.out.println(hasPathSum(null, 0));
        System.out.println(hasPathSum(null, 1));


        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        System.out.println(hasPathSum(root1, 1));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        flag = false;
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        //将0加到sum改为sum减到0,可减少大部分代码量
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

        //以下为繁琐解法
//        hasPathSum(root, 0, sum);
//        return flag;
    }

    static boolean flag = false;

    public static boolean hasPathSum(TreeNode root, int count, int sum) {
        if (root != null) {
            boolean result;
            result = hasPathSum(root.left, count + root.val, sum);
            if (result && isLeaf(root)) {
                flag = true;
            }
            result = hasPathSum(root.right, count + root.val, sum);
            if (result && isLeaf(root)) {
                flag = true;
            }
        }
        if (flag) {
            return true;
        } else {
            return count == sum;
        }
    }

    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}


