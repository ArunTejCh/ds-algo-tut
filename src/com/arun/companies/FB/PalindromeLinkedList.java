package com.arun.companies.FB;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedList sol = new PalindromeLinkedList();

        ListNode n11 = sol.new ListNode(7);

        ListNode n21 = sol.new ListNode(7);
        ListNode n22 = sol.new ListNode(8);
        n21.next = n22;

        ListNode n31 = sol.new ListNode(7);
        ListNode n32 = sol.new ListNode(8);
        ListNode n33 = sol.new ListNode(7);
        n31.next = n32;
        n32.next = n33;

        ListNode n41 = sol.new ListNode(7);
        ListNode n42 = sol.new ListNode(8);
        ListNode n43 = sol.new ListNode(8);
        ListNode n44 = sol.new ListNode(7);
        n41.next = n42;
        n42.next = n43;
        n43.next = n44;

        assert sol.isPalindrome(n11) == true;
        assert sol.isPalindrome(n21) == false;
        assert sol.isPalindrome(n31) == true;
        assert sol.isPalindrome(n41) == true;

    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        int length = this.getLength(head);
        //System.out.println("Got length as :"+ length);

        ListNode revList = null;
        int limit = length / 2;

        while(limit > 0){
            ListNode temp = head.next;
            head.next = revList;
            revList = head;
            head = temp;
            limit--;
        }
        if(length % 2 !=0){
            head = head.next;
        }

        while(head != null){
            if(head.val !=  revList.val){
                return false;
            }

            head = head.next;
            revList = revList.next;
        }

        return true;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
