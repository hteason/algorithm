package htc.leetcode.linkedlist;

import htc.leetcode.datatype.Node;

/*
 * status��:AC�ˣ�����
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 */

//**������´���ע��ͼ��ʳ�á�**
//- ������3��ʱ�򣬽�7��Ϊ3��next����[1,2,3,7]
//- �ݹ����7��ͷ������pre��¼4��λ��
//- ������8��ʱ�򣬽�11��Ϊ8��next,��[1,2,3,7,8,11]
//- �ݹ����11��ͷ������pre��¼9��λ��
//
//- ��������12��nextΪNULL����ʱ[1,2,3,7,8,11,12]
//- �����ݹ飬12�������ƴ��9��֮�������ֱ��NULL����[1,2,3,7,8,11,12,9,10]
//- �����ݹ飬10�������ƴ��4��֮�������ֱ��NULL����[1,2,3,7,8,11,12,9,10,4,5,6]


//1---2---3---4---5---6--NULL 
//        | 
//        7---8---9---10--NULL 
//            | 
//            11--12--NULL
public class _430_��ƽ���༶˫������ {
	public static void main(String[] args) {
		Node thrid = new Node();
		thrid.val = 11;
		thrid.next = new Node();
		thrid.next.val = 12;

		Node second = new Node();
		second.val = 7;
		second.next = new Node();
		second.next.val = 8;
		second.next.child = thrid;
		second.next.next = new Node();
		second.next.next.val = 9;
		second.next.next.next = new Node();
		second.next.next.next.val = 10;

		Node head = new Node();
		head.val = 1;
		head.next = new Node();
		head.next.val = 2;
		head.next.next = new Node();
		head.next.next.val = 3;
		head.next.next.child = second;
		head.next.next.next = new Node();
		head.next.next.next.val = 4;
		head.next.next.next.next = new Node();
		head.next.next.next.next.val = 5;
		head.next.next.next.next.next = new Node();
		head.next.next.next.next.next.val = 6;
		head = new _430_��ƽ���༶˫������().flatten(head);

		while (head != null) {
			System.out.print(head.prev != null ? head.prev.val : "null");
			System.out.print("_" + head.val + "_");
			System.out.println(head.next != null ? head.next.val : "null");
			head = head.next;
		}

	}

	Node dummyHead = new Node();// ����ͷ�ڵ�
	Node ret = dummyHead;

	public Node flatten(Node head) {
		if (head == null) {
			return null;
		}
		flatten(head, null);
		// ͷ�ڵ��prev��Ҫ�ÿգ��������ʾ�����˫������
		ret.next.prev = null;
		return ret.next;
	}

	private void flatten(Node curr, Node preNext) {
		addNode(curr.val);
		if (curr.child != null) {
			// ����ǰ�ڵ���child�ڵ㣬�ݹ����������
			// ����¼��ǰ�����nextΪpre���ڻ���ʱƴ�ӵ��������β��
			Node pre = curr.next;
			curr.next = curr.child;
			flatten(curr.child, pre);
		}
		else if (curr.next != null) {
			// ������child���������������������next
			// ��Ϊ������child��pre�ÿռ���
			flatten(curr.next, null);
		}
		// child��������������󣬽����������Ľڵ�ƴ�ӵ��������β��
		while (preNext != null) {
			addNode(preNext.val);
			preNext = preNext.next;
		}
	}

	// ���½ڵ���ӵ��������ret��β��
	public void addNode(int val) {
		Node n = new Node();
		n.prev = dummyHead;
		n.val = val;
		dummyHead.next = n;
		dummyHead = n;
	}
}
