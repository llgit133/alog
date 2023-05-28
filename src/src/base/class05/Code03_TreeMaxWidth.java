package src.base.class05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

//求树的最大宽度
public class Code03_TreeMaxWidth {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static int getMaxWidth(Node head) {
		if (head == null) {
			return 0;
		}
		int maxWidth = 0;
		int curWidth = 0;
		int curLevel = 0;
		HashMap<Node, Integer> levelMap = new HashMap<>();

		levelMap.put(head, 1);
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(head);
		Node node = null;
		Node left = null;
		Node right = null;
		//当队列不为空时
		while (!queue.isEmpty()) {
			//队列推出一个节点Node
			node = queue.poll();
			left = node.left;
			right = node.right;
			//左节点不为空时，放入levelMap，同时放入队列
			if (left != null) {
				levelMap.put(left, levelMap.get(node) + 1);
				queue.add(left);
			}
			//右节点不为空时，放入levelMap，同时放入队列
			if (right != null) {
				levelMap.put(right, levelMap.get(node) + 1);
				queue.add(right);
			}

			//当当前节点的序号大于curLevel时，令curWidth为0，curLevel设置为当前节点的序号
			//否则curWidth++
			if (levelMap.get(node) > curLevel) {
				curWidth = 0;
				curLevel = levelMap.get(node);
			} else {
				curWidth++;
			}
			//和当前最大值比较获取最大值
			maxWidth = Math.max(maxWidth, curWidth);
		}
		return maxWidth;
	}



	// 每个节点对应的层数
	public static HashMap<Node, Integer> getMaxWidth1(Node head) {
		HashMap<Node, Integer> levelMap = new HashMap<>();
		levelMap.put(head, 1);
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(head);
		//当队列不为空时
		while (!queue.isEmpty()) {
			//队列推出一个节点Node
			Node node = queue.poll();
			//左节点不为空时，放入levelMap，同时放入队列
			if (node.left != null) {
				levelMap.put(node.left, levelMap.get(node) + 1);
				queue.add(node.left);
			}
			//右节点不为空时，放入levelMap，同时放入队列
			if (node.right != null) {
				levelMap.put(node.right, levelMap.get(node) + 1);
				queue.add(node.right);
			}
		}
		return levelMap;
	}

	//
	public static HashMap<Node, Integer> getMaxWidth2(Node head) {
		HashMap<Node, Integer> levelMap = new HashMap<>();
		levelMap.put(head, 1);
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(head);
		//当队列不为空时
		while (!queue.isEmpty()) {
			//队列推出一个节点Node
			Node node = queue.poll();
			//左节点不为空时，放入levelMap，同时放入队列
			if (node.left != null) {
				levelMap.put(node.left, levelMap.get(node) + 1);
				queue.add(node.left);
			}
			//右节点不为空时，放入levelMap，同时放入队列
			if (node.right != null) {
				levelMap.put(node.right, levelMap.get(node) + 1);
				queue.add(node.right);
			}
		}
		return levelMap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.left = new Node(5);
		head.right.right = new Node(6);
		head.left.left.right = new Node(7);
		int width = getMaxWidth(head);
		System.out.println(width);


		HashMap<Node, Integer> maxWidth2 = getMaxWidth1(head);
		int max = 0;
		Set<Map.Entry<Node, Integer>> entries = maxWidth2.entrySet();
		for (Map.Entry<Node, Integer> entry : entries) {
			max = entry.getValue()>max? entry.getValue():max;
		}
		System.out.println("最大值：max " + max);
	}

}

