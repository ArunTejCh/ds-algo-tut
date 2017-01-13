package com.arun.linkedlists;

public class EasyMergeTwoSortedLists {

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
		EasyMergeTwoSortedLists inst = new EasyMergeTwoSortedLists();
		
		ListNode arg11 = null;
		ListNode arg21 = inst.new ListNode(1);
		ListNode arg31 = inst.new ListNode(1);
		ListNode arg32 = inst.new ListNode(1);
		ListNode arg33 = inst.new ListNode(2);
		ListNode arg34 = inst.new ListNode(2);
		arg31.next = arg32;
		arg32.next = arg33;
		arg33.next = arg34;
		
		ListNode arg41 = inst.new ListNode(4);
		ListNode arg42 = inst.new ListNode(4);
		ListNode arg43 = inst.new ListNode(4);
		ListNode arg44 = inst.new ListNode(4);
		arg41.next = arg42;
		arg42.next = arg43;
		arg43.next = arg44;
		
		assert inst.mergeTwoLists(arg11,arg21) == arg21;
		assert inst.mergeTwoLists(arg21,arg11) == arg21;
		assert inst.mergeTwoLists(arg31,arg41) == arg31;
		assert inst.mergeTwoLists(arg41,arg31) == arg31;
		

	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
        	return null;
        }
    	
    	if(l1 == null){
        	return l2;
        }
    	if(l2 == null){
    		return l1;
    	}
    	
    	ListNode cur = null;
    	ListNode retHead = null;
    	if(l1.val < l2.val){
    		cur = l1;
    		retHead = l1;
    		l1 = l1.next;
    		cur.next = null;
    	}else{
    		cur = l2;
    		retHead = l2;
    		l2 = l2.next;
    		cur.next = null;
    	}
    	
    	while(!(l1 == null && l2 == null)){
    		if(l1 == null){
    			cur.next = l2;
    			return retHead;
    		}
    		if(l2 == null){
    			cur.next = l1;
    			return retHead;
    		}
    		ListNode temp = null;
    		if(l1.val < l2.val){
    			temp = l1.next;
    			cur.next = l1;
    			cur = cur.next;
    			cur.next = null;
        		l1 = temp;
    		}else{
    			temp = l2.next;
    			cur.next = l2;
    			cur = cur.next;
    			cur.next = null;
        		l2 = temp;
    		}
    	}
        
    	return retHead;
    }

}
