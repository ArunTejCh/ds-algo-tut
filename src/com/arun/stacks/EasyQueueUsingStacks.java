package com.arun.stacks;

import java.util.Stack;

public class EasyQueueUsingStacks {

	public static void main(String[] args) {
		EasyQueueUsingStacks inst = new EasyQueueUsingStacks();

		inst.push(1);
		inst.push(2);
		int res = inst.peek();
	}

	Stack<Integer> first = new Stack<Integer>();
	Stack<Integer> second = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		first.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (second.isEmpty()) {
			while (!first.empty()) {
				second.push(first.pop());
			}
		}
		second.pop();
	}

	// Get the front element.
	public int peek() {
		if (second.isEmpty()) {
			while (!first.empty()) {
				second.push(first.pop());
			}
		}
		return second.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return first.isEmpty() && second.isEmpty();
	}

}
