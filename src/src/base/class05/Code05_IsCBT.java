package src.base.class05;

import java.util.LinkedList;

//
public class Code05_IsCBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static boolean isCBT(Node head) {
		if (head == null) {
			return true;
		}
		LinkedList<Node> queue = new LinkedList<>();
		boolean leaf = false;  // 记录开关 遇到过两个孩子不双全
		Node l = null;
		Node r = null;
		queue.add(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;

			// l == null && r != null  条件1
			// leaf && (l != null || r != null) 条件2   遇到过两个孩子不双全 而且不是叶节点（有孩子）
			if ((leaf && (l != null || r != null)) || (l == null && r != null)) {return false;}
			if (l != null) {queue.add(l);}
			if (r != null) {queue.add(r);}
			else {leaf = true;}   // 说明不双全
		}
		return true;
	}


	public static void main(String[] args) {

	}
}
