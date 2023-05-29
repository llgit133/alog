package org.example.link;

import java.util.Stack;

public class Offer_2_6 {

    public static int[] reversePrint(ListNode head) {

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            count++;
            head = head.next;
        }
        int [] res = new int[count];

        count = 0;
        while (!stack.isEmpty()){
            res[count] = stack.pop();
            count++;
        }
        return res;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;

        int[] ints = reversePrint(node1);
        for (int anInt : ints) {
            System.out.print(" " + anInt);
        }
    }
}
