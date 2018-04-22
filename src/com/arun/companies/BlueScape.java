package com.arun.companies;

import java.util.Stack;

public class BlueScape {

    public static void main(String[] args) {
        BlueScape test = new BlueScape();

        assert test.solution("13 DUP 4 POP 5 DUP + DUP + -") == 7;
        assert test.solution("5 6 + -") == -1;
        assert test.solution("3 DUP 5 - -") == -1;
        assert test.solution("2147483647 DUP") == -1;
        assert test.solution("1 2147483647 -") == -1;
    }

    int solution(String s){

        Stack<Integer> stack = new Stack<>();

        String[] temp = s.split(" ");
        long sum = 0;
        for(String node : temp){
            switch (node){
                case "POP":
                    if(stack.size() > 0)
                        stack.pop();
                    else
                        return -1;
                    break;
                case "DUP":
                    if(stack.size() > 0)
                        stack.push(stack.peek());
                    else
                        return -1;
                    break;
                case "+":
                    if(stack.size() > 1) {
                        sum = (long) (stack.pop() + stack.pop());
                        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
                            return -1;
                        }else{
                            stack.push((int)sum);
                        }

                    }else {
                        return -1;
                    }
                    break;
                case "-":
                    if(stack.size() > 1) {
                        sum = (long) (stack.pop() - stack.pop());
                        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
                            return -1;
                        }else{
                            stack.push((int)sum);
                        }

                    }else {
                        return -1;
                    }
                    break;
                default:
                    stack.push(Integer.parseInt(node));
                    break;
            }
        }

        return stack.peek();
    }
}
