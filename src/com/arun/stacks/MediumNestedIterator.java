package com.arun.stacks;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MediumNestedIterator implements Iterator<Integer> {

	Queue<Integer> q = null;
	Stack<NestedInteger> nest = null;
	
    public MediumNestedIterator(List<NestedInteger> nestedList) {
        q = new LinkedList<Integer>();
        nest = new Stack<NestedInteger>();
        if(nestedList.size() == 0)
        	return;
        
        nest.addAll(nestedList);
        
        while(!nest.isEmpty()){
        	NestedInteger cur = nest.pop();
        	if(cur.isInteger()){
        		q.add(cur.getInteger());
        	}else{
        		nest.addAll(cur.getList());
        	}
        }
        
    }

    @Override
    public Integer next() {
        return q.remove();
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }
}
