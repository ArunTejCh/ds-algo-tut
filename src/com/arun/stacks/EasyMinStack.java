package com.arun.stacks;

import java.util.Stack;
import java.util.TreeMap;

public class EasyMinStack {

	public static void main(String[] args) {
		
		EasyMinStack minStack = new EasyMinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin();   //--> Returns -3.
		minStack.pop();
		minStack.top();      //--> Returns 0.
		minStack.getMin();

	}
	
    /** initialize your data structure here. */
    public EasyMinStack() {
        mainStack = new Stack<Integer>();
        sortedList = new TreeMap<Integer, Integer>();
    }
    
    Stack<Integer> mainStack = null;
    TreeMap<Integer,Integer> sortedList = null;
    
    public void push(int x) {
        mainStack.push(x);
        Integer val = sortedList.get(x);
        if(val == null){
        	val = 0;
        }
        sortedList.put(x, ++val);
    }
    
    public void pop() {
        int x = mainStack.pop();
        Integer val = sortedList.get(x);
        if(val == 1){
        	sortedList.remove(x);
        }else{
        	sortedList.put(x, --val);
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return sortedList.firstKey();
    }

}
