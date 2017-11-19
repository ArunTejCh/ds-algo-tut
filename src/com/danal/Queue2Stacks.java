package com.danal;

import java.util.Stack;

public class Queue2Stacks {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {

        Queue2Stacks inst = new Queue2Stacks();

        assert inst.remove() == -1;

        inst.add(10);
        inst.add(5);
        inst.add(6);
        inst.add(2);
        inst.add(1);

        assert inst.remove() == 10;
        assert inst.remove() == 5;
        assert inst.remove() == 6;
        assert inst.remove() == 2;
        assert inst.remove() == 1;
        assert inst.remove() == -1;

    }

    public void add(Integer in){
        this.stack1.push(in);
    }

    public int remove(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }

        if(stack2.isEmpty())
            return -1;
        else
            return stack2.pop();
    }

}
