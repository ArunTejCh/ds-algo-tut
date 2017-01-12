package com.arun.linkedlists;

public class EasyReverseLinkedList {

	public static void main(String[] args) {
		EasyReverseLinkedList inst = new EasyReverseLinkedList();
		
		ListNode arg11 = null;
		ListNode arg21 = inst.new ListNode(1);
		ListNode arg31 = inst.new ListNode(1);
		ListNode arg32 = inst.new ListNode(2);
		ListNode arg33 = inst.new ListNode(3);
		ListNode arg34 = inst.new ListNode(4);
		arg31.next = arg32;
		arg32.next = arg33;
		arg33.next = arg34;
		
		assert inst.reverseList(arg11) == null;
		assert inst.reverseList(arg21) == arg21;
		assert inst.reverseList(arg31) == arg34;
	}

	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode cur = head;
		ListNode next = head.next;
		cur.next = null;
		
		while(next != null){
			ListNode temp = next.next;
			next.next = cur;
			cur = next;
			next = temp;
		}
		
		return cur;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
