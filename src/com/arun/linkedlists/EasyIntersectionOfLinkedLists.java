package com.arun.linkedlists;

public class EasyIntersectionOfLinkedLists {

	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		      
				@Override
				public String toString() {
					return "ListNode [val=" + val + ", next=" + next + "]";
				}
		  }
	
	public static void main(String[] args) {
		EasyIntersectionOfLinkedLists inst = new EasyIntersectionOfLinkedLists();
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
		arg44.next = arg31;
		
		assert inst.getIntersectionNode(arg11,arg21) == null;
		assert inst.getIntersectionNode(arg21,arg11) == null;
		assert inst.getIntersectionNode(arg31,arg41) == arg31;
		assert inst.getIntersectionNode(arg41,arg31) == arg31;
	}
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
        	return null;
        }
    	
        int lenA = 0;
        int lenB = 0;
        
        ListNode cur = headA;
        while(cur != null){
        	lenA++;
        	cur = cur.next;
        }
        
        cur = headB;
        while(cur != null){
        	lenB++;
        	cur = cur.next;
        }
        
        ListNode curA = headA;
        ListNode curB = headB;
        int diff = 0;
        int rem = 0;
        if(lenA > lenB){
        	rem = lenB;
        	diff = lenA - lenB;
        	while(diff > 0){
        		curA = curA.next;
        		diff--;
        	}
        }else{
        	rem = lenA;
        	diff = lenB - lenA;
        	while(diff > 0){
        		curB = curB.next;
        		diff--;
        	}
        	
        }
        
        while(rem > 0){
        	if(curA == curB){
        		return curA;
        	}
        	rem--;
        	curA = curA.next;
        	curB = curB.next;
        }
        
    	return null;
    }
    
    

}
