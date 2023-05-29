package org.example.double_pointer;

public class Offer_2_25 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        // 尾插法
        while (l1 != null && l2 != null){
            if( l1.val <= l2.val ){
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 有链表未空
        cur.next = (l1==null) ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        ListNode b4 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = null;

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = null;

        ListNode node = mergeTwoLists(a1, b1);

        while (node != null){
            System.out.print(" "+node.val);
            node = node.next;
        }
    }
}
