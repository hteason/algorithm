package htc.leetcode.everyday._2020._06;

import htc.leetcode.datatype.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//WA
public class _2020_6_16_297_二叉树的序列化与反序列化 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		root.right.left.left = new TreeNode(6);
		root.right.left.right = new TreeNode(7);
		//		System.out.println(serialize(root));

		System.out.println(deserialize("[1,2,3,null,null,4,5]"));
	}

	public static TreeNode deserialize(String data) {
		String[] datas = data.substring(1, data.length() - 2).split(",");
		TreeNode root = null;
		for (int i = 0; i < datas.length; i++) {
			if (!"null".equals(datas[i])) {
				root = new TreeNode(Integer.valueOf(datas[i]));
			}
			root.left = new TreeNode(Integer.valueOf(datas[(i + 1) * 2 - 1]));
			root.right = new TreeNode(Integer.valueOf(datas[(i + 1) * 2]));
		}
		return null;
	}

	public static String serialize(TreeNode root) {
		//层序遍历
		Stack<TreeNode> level = new Stack<>();
		level.push(root);
		List<Integer> list = new ArrayList<>();
		list.add(root.val);
		for (int index = 0; !level.isEmpty(); index++) {
			TreeNode p = level.pop();
			if (p == null) {
				continue;
			}
			TreeNode ll = null;
			TreeNode lr = null;
			if (p.left != null) {
				ll = p.left.left;
				lr = p.left.right;
				list.add(p.left.val);
			}

			TreeNode rl;
			TreeNode rr;
			if (p.right != null) {
				rl = p.right.left;
				rr = p.right.right;
				list.add(p.right.val);
				//				list.add(ll != null ? ll.val : null);
				//				list.add(lr != null ? lr.val : null);

				if (lr != null) {
					list.add(lr.val);
				} else if (rl != null || rr != null) {
					list.add(null);
				}

				if (ll != null) {
					list.add(ll.val);
				} else if (rl != null || rr != null) {
					list.add(null);
				}

				if (rl != null) {
					list.add(rl.val);
				}

				if (rr != null) {
					list.add(rr.val);
				}
			}
			level.push(p.right);
			level.push(p.left);
		}
		return list.toString();
	}

}