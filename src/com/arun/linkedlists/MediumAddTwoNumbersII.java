package com.arun.linkedlists;

import java.util.Stack;

public class MediumAddTwoNumbersII {

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
		MediumAddTwoNumbersII inst = new MediumAddTwoNumbersII();

		ListNode arg11 = null;
		ListNode arg21 = inst.new ListNode(1);
		ListNode arg31 = inst.new ListNode(1);
		ListNode arg32 = inst.new ListNode(1);
		ListNode arg33 = inst.new ListNode(2);
		ListNode arg34 = inst.new ListNode(2);
		arg31.next = arg32;
		arg32.next = arg33;
		arg33.next = arg34;

		ListNode arg41 = inst.new ListNode(9);
		ListNode arg42 = inst.new ListNode(4);
		ListNode arg43 = inst.new ListNode(4);
		ListNode arg44 = inst.new ListNode(9);
		arg41.next = arg42;
		arg42.next = arg43;
		arg43.next = arg44;

		assert inst.addTwoNumbers(arg11, arg21) == arg21;
		assert inst.addTwoNumbers(arg21, arg11) == arg21;
		assert inst.addTwoNumbers(arg31, arg41) != null;
		assert inst.addTwoNumbers(arg41, arg31) != null;

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		Stack<Integer> one = new Stack<Integer>();
		Stack<Integer> two = new Stack<Integer>();

		while (l1 != null) {
			one.push(l1.val);
			l1 = l1.next;
		}

		while (l2 != null) {
			two.push(l2.val);
			l2 = l2.next;
		}

		ListNode ret = null;
		int carry = 0;

		while (!(one.isEmpty() && two.isEmpty())) {
			int first = one.isEmpty() ? 0 : one.pop();
			int second = two.isEmpty() ? 0 : two.pop();

			int sum = first + second + carry;

			int val = sum % 10;
			carry = sum / 10;

			ListNode temp = new ListNode(val);

			temp.next = ret;
			ret = temp;
		}

		if (carry > 0) {
			ListNode temp = new ListNode(carry);
			temp.next = ret;
			ret = temp;
		}
		return ret;
	}

}
