package Stack;

public class InFixToPostFix {
    /**
     *  1.  Traverse in expression from left to right.
     *  2.  If it is a operand, append it to postFix String. and continue traversing
     *  3.  If it is Operator
     *          If Stack is empty add the operator to the stack
     *          else if precedence of operator is greater than stack top precedence push that operator to the stack
     *          else pop from the stack and append to postfix string and continue.
     */
    public StringBuilder infixToPostFix(String s){
        char[] exp = s.toCharArray();
        StringBuilder postfix = new StringBuilder();
        StackUsingLinkedList<Character> stack = new StackUsingLinkedList<>();
        int i=0;
        while (i<exp.length){
            char c = exp[i];
            if (isOperand(c)){
                postfix.append(c);
                i++;
            }else if(stack.top ==null && precedenceOf(c) > 0) {
                stack.push(c);
                i++;
            }else{
                if (precedenceOf(c) > precedenceOf(stack.stackTop())){
                    stack.push(c);
                    i++;
                }else {
                    postfix.append(stack.pop());
                }
            }
        }
        while (stack.top!=null){
            postfix.append(stack.pop());
        }
        return postfix;
    }

    public boolean isOperand(char c){
        return !((c == '+') || (c == '-') || (c == '*') || (c == '/'));
    }

    public int precedenceOf(char c){
        if ((c=='+') || (c=='-')){
            return 1;
        }else if ((c=='*') || (c=='/')){
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        InFixToPostFix inFixToPostFix = new InFixToPostFix();
        String expression = "a+b*c-d/e";
        System.out.println(inFixToPostFix.infixToPostFix(expression));
    }

}
