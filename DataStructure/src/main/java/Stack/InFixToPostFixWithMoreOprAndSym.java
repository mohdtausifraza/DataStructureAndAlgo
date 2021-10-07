package Stack;

public class InFixToPostFixWithMoreOprAndSym{

    /**
     *    Symbol    Out Stack Precedence    In Stack Precedence
     *     +,-             1                       2               L->R
     *     *,/             3                       4               L->R
     *     ^               6                       5               R->L
     *     (               7                       0               L->R
     *     )               0                       ?               L->R
     *
     *     Note : Out Stack Precedence means precedence of operator when it is outside.
     */
    /**
     *  1.  Traverse in expression from left to right.
     *  2.  If the element is operand add to the POSTFIX string
     *  3.  Else if element is and Operator
     *          if the stack is empty || OSP(char) > ISS(stack.getTop())
     *              Push char in the stack.
     *  4.  Else while OSP(char) <= ISP(stack.top)
     *          IF OSP(char) < ISP(stack.top)
     *              POP from the stack and append to the POSTFIX string
     *              If Stack become empty on popping push the char in stack and break the loop
     *          IF OSP(char) = ISP(stack.top)
     *              Just pop the element from the stack (This for removing '(' ) and break
     *  5.  At the end of the expression POP element one by one from stack and add to POSTFIX string.
     *
     */
    public StringBuilder infixToPostFix(String s){
        char[] exp = s.toCharArray();
        StringBuilder postfix = new StringBuilder();
        StackUsingLinkedList<Character> stack = new StackUsingLinkedList<>();
        for(char c : exp) {
            if(isOperand(c)) {
                postfix.append(c);
            }else if(!isOperand(c) && (stack.isEmpty() || outStackPrecedenceOf(c) > inStackPrecedenceOf(stack.stackTop()))) {
                stack.push(c);
            }else {
                while(outStackPrecedenceOf(c) <= inStackPrecedenceOf(stack.stackTop())) {
                    if (outStackPrecedenceOf(c) < inStackPrecedenceOf(stack.stackTop())){
                        postfix.append(stack.pop());
                        if (stack.top == null){
                            stack.push(c);
                            break;
                        }
                    }else {
                        stack.pop();
                        break;
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            postfix.append(stack.pop());
        }
        return postfix;
    }

    public boolean isOperand(char c){
        return !((c == '+') || (c == '-') || (c == '*') || (c == '/') || (c == '^') || (c == '(') || (c == ')'));
    }

    public int outStackPrecedenceOf(char c){
        if ((c=='+') || (c=='-')){
            return 1;
        }else if ((c=='*') || (c=='/')){
            return 3;
        }else if ((c=='^')){
            return 6;
        }else if ((c=='(')){
            return 7;
        }
        return 0;
    }

    public int inStackPrecedenceOf(char c){
        if ((c=='+') || (c=='-')){
            return 2;
        }else if ((c=='*') || (c=='/')){
            return 4;
        }else if ((c=='^')){
            return 5;
        }else if ((c=='(')){
            return 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        InFixToPostFixWithMoreOprAndSym inFixToPostFix = new InFixToPostFixWithMoreOprAndSym();
        String expression = "((a+b)*c)-d^e^f";
        System.out.println(inFixToPostFix.infixToPostFix(expression));
    }

}
