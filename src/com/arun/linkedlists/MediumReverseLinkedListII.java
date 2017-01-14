package com.arun.linkedlists;

public class MediumReverseLinkedListII {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	}
	
	public static void main(String[] args) {
		MediumReverseLinkedListII inst = new MediumReverseLinkedListII();
		
		ListNode arg11 = null;
		ListNode arg21 = inst.new ListNode(1);
		ListNode arg31 = inst.new ListNode(1);
		ListNode arg32 = inst.new ListNode(1);
		ListNode arg33 = inst.new ListNode(2);
		ListNode arg34 = inst.new ListNode(2);
		arg31.next = arg32;
		arg32.next = arg33;
		arg33.next = arg34;

		ListNode arg41 = inst.new ListNode(2);
		ListNode arg42 = inst.new ListNode(4);
		ListNode arg43 = inst.new ListNode(4);
		ListNode arg44 = inst.new ListNode(9);
		arg41.next = arg42;
		arg42.next = arg43;
		arg43.next = arg44;

		assert inst.reverseBetween(arg11, 0, 0) == null;
		assert inst.reverseBetween(arg21, 1, 1) == arg21;
		assert inst.reverseBetween(arg31, 2, 3) != null;
		assert inst.reverseBetween(arg41, 1, 4) != null;
	}
	
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || (head.next == null && m == 1 && n==1)){
        	return head;
        }
        
        ListNode cur = head;
        ListNode parent = null;
        n = n - m +1;
        while(m > 1){
        	parent = cur;
        	cur = cur.next;
        	m--;
        }
        
        ListNode leftEnd = parent;
        ListNode start = cur;
        
        if(leftEnd != null)
        	leftEnd.next = null;
        ListNode temp = null;
        while(n > 0){
        	ListNode next = cur.next;
        	cur.next = temp;
        	temp = cur;
        	cur = next;
        	n--;
        }
        if(leftEnd != null)
        	leftEnd.next = temp;
        else
        	head = temp;
        start.next = cur;
    	return head;
    }

}
