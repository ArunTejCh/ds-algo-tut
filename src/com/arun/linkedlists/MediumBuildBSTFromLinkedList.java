package com.arun.linkedlists;

public class MediumBuildBSTFromLinkedList {

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

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
		
	}

	public static void main(String[] args) {
		MediumBuildBSTFromLinkedList inst = new MediumBuildBSTFromLinkedList();

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

		assert inst.sortedListToBST(arg11) == null;
		assert inst.sortedListToBST(arg21).val == 1;
		assert inst.sortedListToBST(arg31) != null;
		assert inst.sortedListToBST(arg41) != null;
		
	}

	public TreeNode sortedListToBST(ListNode head) {
		if(head == null)
			return null;
		int len = 0;
		ListNode temp = head;
		while (temp != null) {
			temp = temp.next;
			len++;
		}
		TreeNode ret = recurse(head, len);
		return ret;
	}
	
	private TreeNode recurse(ListNode head, int len){
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		int mid = len/2;
		int rightLen = len - mid - 1;
		int leftlen = 0;
		
		if(len%2 == 0){
			leftlen = len - mid;
		}else{
			leftlen = len - mid - 1;
		}
		ListNode midNode = head;
		ListNode midParent = null;
		
		for(int i = 0; i < mid ; i++){
			midParent = midNode;
			midNode = midNode.next;
		}
		
		ListNode right = midNode.next;
		ListNode left = head;
		
		midParent.next = null;
		midNode.next = null;
		TreeNode leftNode = null;
		TreeNode rightNode = null;
		if(left != null){
			leftNode = recurse(left, leftlen);
		}
		
		if(right != null){
			rightNode = recurse(right, rightLen);
		}
		
		TreeNode cur = new TreeNode(midNode.val);
		
		cur.left = leftNode;
		cur.right = rightNode;

		return cur;
	}
}
