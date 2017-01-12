package com.arun.stacks;

import java.util.Stack;

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
    }
    
    int min = Integer.MAX_VALUE;
    Stack<Integer> mainStack = null;
    
    public void push(int x) {
    	if(x<= min){
    		mainStack.push(min);
    		min = x;
    	}
    	mainStack.push(x);
    }
    
    public void pop() {
        if(mainStack.pop() == min)
        	min = mainStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return min;
    }

}
