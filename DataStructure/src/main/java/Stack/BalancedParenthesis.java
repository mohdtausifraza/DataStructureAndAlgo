package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Here we are assuming that only one parenthesis is used i.e ( and )
 * Also here we are not validating the expressions.
 */
public class BalancedParenthesis {
    /**
     * Approach : Push in stack if it is a opening Parenthesis
     *            Pop and match if it is a closing Parenthesis
     *            Skip if element is other than Parenthesis
     */

    public boolean isBalancedParenthesis(String s){
        StackUsingLinkedList<Character> stack = new StackUsingLinkedList<>();
        char[] expression = s.toCharArray();
        for(char c : expression){
            if (c == '('){
                stack.push(c);
            }else if(c == ')'){
                if (stack.top == null){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     *  ( => 40  )=>41
     *  { => 91  }=>93
     *  [ => 123 ]=>125
     */
    public boolean isBalancedParenthesisMoreThanOneParenthesis(String s){
        StackUsingLinkedList<Character> stack = new StackUsingLinkedList<>();
        char[] expression = s.toCharArray();
        for(char c : expression){
            if (c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else if(c == '}' || c == ']' || c == ')'){
                if (stack.top == null){
                    return false;
                }else{
                    char popElement = stack.pop();
                    if (popElement=='(' && c!=')' || popElement=='{' && c!='}' || popElement=='[' && c!=']'){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter the Expression");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        BalancedParenthesis bp = new BalancedParenthesis();
//        System.out.println(bp.isBalancedParenthesis(expression));
        System.out.println(bp.isBalancedParenthesisMoreThanOneParenthesis(expression));


    }

}
