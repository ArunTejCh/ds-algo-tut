package com.arun.stacks;

import java.util.LinkedList;
import java.util.Queue;

public class EasyStackUsingQueues {

	public static void main(String[] args) {

		EasyStackUsingQueues inst = new EasyStackUsingQueues();

		inst.push(1);
		inst.pop();
		assert inst.empty() == true;
		
		inst.push(1);
		inst.push(2);
		assert inst.top() == 2;
	}

	Queue<Integer> first = new LinkedList<Integer>();
	//Queue<Integer> second = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		first.add(x);
		if (first.size() > 1) {
			int size = first.size();
			for (int i = 0; i < size - 1; i++) {
				first.add(first.remove());
			}
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		first.remove();
	}

	// Get the top element.
	public int top() {
		return first.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return first.isEmpty();
	}
}
