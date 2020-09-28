package htc.leetcode.tree;

import htc.leetcode.datatype.tree.Node;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * AC
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * �ο�������ͬ -> {@link htc.leetcode.everyday._2020_09_28_117_���ÿ���ڵ����һ���Ҳ�ڵ�ָ��II#connect(Node)}
 */
public class _116_���ÿ���ڵ����һ���Ҳ�ڵ�ָ�� {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        _116_���ÿ���ڵ����һ���Ҳ�ڵ�ָ�� test = new _116_���ÿ���ڵ����һ���Ҳ�ڵ�ָ��();
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
