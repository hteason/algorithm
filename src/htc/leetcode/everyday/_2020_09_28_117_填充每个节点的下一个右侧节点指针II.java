package htc.leetcode.everyday;

import htc.leetcode.datatype.tree.Node;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * AC
 * BFS暴力
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class _2020_09_28_117_填充每个节点的下一个右侧节点指针II {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        _2020_09_28_117_填充每个节点的下一个右侧节点指针II test = new _2020_09_28_117_填充每个节点的下一个右侧节点指针II();
        System.out.println(test.connect(root));
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        Deque<Node> q = new LinkedBlockingDeque<>();
        Deque<Node> q2 = new LinkedBlockingDeque<>();
        q.push(root);
        while (!q.isEmpty()) {
            Node node = q.pollFirst();
            if (node.left != null) {
                q2.offerLast(node.left);
            }
            if (node.right != null) {
                q2.offerLast(node.right);
            }
            if (q.isEmpty()) {
                node.next = null;
                q = q2;
                q2 = new LinkedBlockingDeque<>();

            } else {
                node.next = q.peekFirst();
            }
        }
        return root;
    }
}
