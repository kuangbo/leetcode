package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _20 {
    public static void main(String[] args) {
        System.out.println(isValid("(){}]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (c == '('|| c == '[' || c == '{') {
                stack.push(c);
            }
            if (stack.empty())
                return false;
            if (c == ')') {
                char temp = stack.lastElement();
                if (temp != '(')
                    return false;
                stack.pop();
            }
            if (c == ']') {
                char temp = stack.lastElement();
                if (temp != '[')
                    return false;
                stack.pop();
            }
            if (c == '}') {
                char temp = stack.lastElement();
                if (temp != '{')
                    return false;
                stack.pop();
            }
        }
        return stack.empty();
    }
}
