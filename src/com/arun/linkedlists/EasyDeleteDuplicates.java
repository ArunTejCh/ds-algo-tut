package com.arun.linkedlists;

public class EasyDeleteDuplicates {

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
		EasyDeleteDuplicates inst = new EasyDeleteDuplicates();
		
		ListNode arg11 = null;
		ListNode arg21 = inst.new ListNode(1);
		ListNode arg31 = inst.new ListNode(1);
		ListNode arg32 = inst.new ListNode(1);
		ListNode arg33 = inst.new ListNode(2);
		ListNode arg34 = inst.new ListNode(2);
		arg31.next = arg32;
		arg32.next = arg33;
		arg33.next = arg34;
		
		assert inst.deleteDuplicates(arg11) == null;
		assert inst.deleteDuplicates(arg21) == arg21;
		assert inst.deleteDuplicates(arg31) == arg31;
	}
	
	
	
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
    	
    	ListNode cur = head;
    	int val = head.val;
    	
    	while(cur !=null && cur.next != null){
    		if(val == cur.next.val){
    			cur.next = cur.next.next;
    		}else{
    			cur = cur.next;
    			val = cur.val;
    		}
    	}
        
    	return head;
    }

}
