package com.arun.companies.FB;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList soln = new ReverseLinkedList();

        ListNode n11 = soln.new ListNode(4);

        ListNode n21 = soln.new ListNode(4);
        ListNode n22 = soln.new ListNode(5);
        n21.next = n22;

        ListNode n31 = soln.new ListNode(1);
        ListNode n32 = soln.new ListNode(2);
        ListNode n33 = soln.new ListNode(3);
        ListNode n34 = soln.new ListNode(4);
        n31.next = n32;
        n32.next=n33;
        n33.next=n34;

        assert soln.reverseList(null) == null;
        assert soln.reverseList(n11).val == 4;
        assert soln.reverseList(n21).val == 5;
        assert soln.reverseList(n31).val == 4;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode rev = null;
        ListNode cur = head;

        if(cur == null || cur.next == null)
            return cur;

        while(cur != null){
            ListNode temp = cur.next;
            cur.next = rev;
            rev = cur;
            cur = temp;
        }

        return rev;
    }

}
