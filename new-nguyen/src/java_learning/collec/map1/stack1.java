package java_learning.collec.map1;

import java.util.Stack;

public class stack1 {
    public static  String find_status(String ex)
    {
        Stack<Character> new_stack = new Stack<>();
        for(char c: ex.toCharArray())
        {
            if(c == '(' || c == '[' || c == '{') new_stack.push(c);
            else if(c == ')' || c == ']' || c == '}')
            {
                if(new_stack.isEmpty()) return "Unbalanced";
                char c_temp = new_stack.pop();
                if (c_temp == '(' && c != ')' ||
                c_temp == '[' && c != ']' ||
                c_temp == '{' && c != '}')
                {
                    return "Unbalanced";
                }
            }
        }
        return new_stack.isEmpty()?"Balanced":"Unbalanced";
    }

    public static void main(String[] args) {
        String ex1 = "((()))";
        String ex2 = "{[()]()}";
        String ex3 = "({[)]}";
        System.out.println("Status of ex1: " + find_status(ex1));
        System.out.println("Status of ex2: " + find_status(ex2));
        System.out.println("Status of ex3: " + find_status(ex3));
    }
}
