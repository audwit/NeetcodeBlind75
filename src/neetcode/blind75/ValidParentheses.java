package neetcode.blind75;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        String input = "]]";
        ValidParentheses validParentheses = new ValidParentheses();
        if(validParentheses.isValid(input))
            System.out.println("Parentheses is valid");
        else
            System.out.println("Input is invalid");
    }

    boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();

        if(s.length()%2!=0)
            return false;

        for(Character c:s.toCharArray()){
            if(c=='(' || c=='{' || c=='[')
                stack.push(c);
            else if(c==')' && !stack.isEmpty() && stack.peek()=='(')
                stack.pop();
            else if(c=='}' && !stack.isEmpty() && stack.peek()=='{')
                stack.pop();
            else if(c==']' && !stack.isEmpty() && stack.peek()=='[')
                stack.pop();
            else
                return false;
        }

        if (!stack.isEmpty())
            return false;
        else
            return true;
    }
}
