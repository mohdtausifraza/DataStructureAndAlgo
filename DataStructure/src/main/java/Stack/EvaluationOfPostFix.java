package Stack;

public class EvaluationOfPostFix {
    /**
     * Approach :   Convert InFix to PostFix
     *              Traverse in PostFix expression
     *              If OPERAND Push into stack
     *              Else of its OPERATOR POP out two OPERANDS from stack and perform that operation and PUSH result into the stack
     */

    static InFixToPostFixWithMoreOprAndSym inFixToPostFix;

    public double evaluate(String s){
        char[] expression = s.toCharArray();
        StackUsingLinkedList<Double> stack = new StackUsingLinkedList<>();
        int i=0;
        while (i<expression.length){
            if (inFixToPostFix.isOperand(expression[i])){
                stack.push((double) Character.digit(expression[i++], 10));
            }else {
                performOperationAndPush(stack,expression[i++]);
            }
        }
        return stack.pop();
    }
    public void performOperationAndPush(StackUsingLinkedList<Double> stack, char operator){
        double operand2 = stack.pop();
        double operand1 = stack.pop();
        switch (operator) {
            case '+':
                stack.push(operand1 + operand2);
                break;
            case '-':
                stack.push(operand1 - operand2);
                break;
            case '*':
                stack.push(operand1 * operand2);
                break;
            case '/':
                stack.push(operand1 / operand2);
                break;
            case '^':
                stack.push(Math.pow(operand1, operand2));
                break;
        }
    }
    public static void main(String[] args) {
        inFixToPostFix = new InFixToPostFixWithMoreOprAndSym();
        String expression= "6+5+3*4";
        String postfix = inFixToPostFix.infixToPostFix(expression).toString();
        System.out.println(postfix);
        System.out.println(new EvaluationOfPostFix().evaluate(postfix));
    }
}
