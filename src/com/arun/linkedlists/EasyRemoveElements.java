package com.arun.linkedlists;

import com.arun.linkedlists.EasyDeleteDuplicates.ListNode;

public class EasyRemoveElements {

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

		EasyRemoveElements inst = new EasyRemoveElements();
		
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
		
		assert inst.removeElements(arg11,0) == null;
		assert inst.removeElements(arg21,0) == arg21;
		assert inst.removeElements(arg31,2) == arg31;
		assert inst.removeElements(arg41,4) == null;
		
	}

    public ListNode removeElements(ListNode head, int val) {
        if(head == null || (head.next == null && head.val == val)){
        	return null;
        }
    	
    	ListNode cur = head;
        while(cur.next != null){
        	if(cur.next.val == val){
        		cur.next = cur.next.next;
        	}else{
        		cur = cur.next;
        	}
        }
        
    	if(head.val != val)
    		return head;
    	else
    		return head.next;
    }
	
}
