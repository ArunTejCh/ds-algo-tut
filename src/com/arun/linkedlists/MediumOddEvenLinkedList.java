package com.arun.linkedlists;

public class MediumOddEvenLinkedList {

	public static void main(String[] args) {
		MediumOddEvenLinkedList inst = new MediumOddEvenLinkedList();
		
		ListNode arg11 = null;
		ListNode arg21 = inst.new ListNode(1);
		ListNode arg31 = inst.new ListNode(1);
		ListNode arg32 = inst.new ListNode(2);
		ListNode arg33 = inst.new ListNode(3);
		ListNode arg34 = inst.new ListNode(4);
		arg31.next = arg32;
		arg32.next = arg33;
		arg33.next = arg34;
		
		assert inst.oddEvenList(arg11) == null;
		assert inst.oddEvenList(arg21) == arg21;
		assert inst.oddEvenList(arg31) == arg31;
		
	}

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

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode evenHead = head.next;
		ListNode odd = head;
		ListNode even = head.next;
		ListNode cur = head.next.next;
		odd.next =null;
		even.next = null;
		int i = 1;
		while (cur != null) {
			ListNode temp = cur.next;
			if (i % 2 == 1) {
				odd.next = cur;
				odd = cur;
				odd.next = null;
			} else {
				even.next = cur;
				even = cur;
				even.next = null;
			}
			cur = temp;
			i++;
		}

		odd.next = evenHead;
		
		return head;
	}

}
