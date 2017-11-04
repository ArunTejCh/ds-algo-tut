package com.arun.companies.FB;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses temp = new ValidParentheses();
        assert temp.isValid("()") == true;
        assert temp.isValid("()[]{}") == true;
        assert temp.isValid("([)]") == false;
        assert temp.isValid("(]") == false;
        assert temp.isValid("(") == false;
        assert temp.isValid("]") == false;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '(' || cur == '{' || cur == '['){
                stack.push(cur);
            }else{
                if(stack.isEmpty())
                    return false;
                if(cur == ')'){
                    if(stack.pop() != '(')
                        return false;
                }else if(cur == '}'){
                    if(stack.pop() != '{')
                        return false;
                }else{
                    if(stack.pop() != '[')
                        return false;
                }
            }

        }
        if(stack.size() == 0)
            return true;
        else
            return false;
    }
}
