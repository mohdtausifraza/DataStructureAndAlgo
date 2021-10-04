package Stack;

import java.util.Scanner;

/**
 * Here we will represent Stack using Array as the Physical DataStructure
 */
public class StackUsingArray {
    int size;
    int top;
    int[] stack;

    public StackUsingArray(int size) {
        this.size = size;
        this.top = -1;
        stack = new int[size];
    }

    public void push(int x){
        if (!isFull()){
            stack[++top] = x;
        }else {
            System.out.println("Stack Overflow");
        }
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }else {
            return stack[top--];
        }
    }

    /**
     * Element at position [ p = top-pos+1 ]
     */
    public int peek(int pos){
        if (top-pos+1 < 0){
            System.out.println("StackIndexOutOfBound");
            return -1;
        }else {
            return stack[top-pos+1];
        }
    }

    /**
     * StackTop is the element at pos = 1
     */
    public int stackTop(){
        if (isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }else {
            return stack[top];
        }
    }

    /**
     * Display Stack
     */
    public void display(){
        for (int i=top ; i >=0 ; i--){
            System.out.println(stack[i]);
        }
    }

    /**
     * Stack is Empty if top = -1;
     */
    public boolean isEmpty(){
        return (top == -1) ? true : false ;
    }

    /**
     * Stack is Full if top = size-1;
     */
    public boolean isFull(){
        return (top == this.size-1) ? true : false ;
    }

    public static void main(String[] args) {
        System.out.println("Enter size of the stack");
        int size = new Scanner(System.in).nextInt();
        System.out.println("Creating Stack");
        StackUsingArray stack= new StackUsingArray(size);
        System.out.println("Stack of Size = "+size +" created successfully");
        String choice=null;
        while (choice != "Exit"){
            System.out.println("Enter Your choice");
            System.out.println("1.push(int x)");
            System.out.println("2.pop()");
            System.out.println("3.peek(int pos)");
            System.out.println("4.stackTop()");
            System.out.println("5.isEmpty()");
            System.out.println("6.isFull()");
            System.out.println("7.display()");
            System.out.println("8.Exit()");
            int option = new Scanner(System.in).nextInt();
            switch (option){
                case 1 :
                    System.out.println("Enter the element to be pushed");
                    int data = new Scanner(System.in).nextInt();
                    stack.push(data);
                    System.out.println("Displaying the stack");
                    stack.display();
                    choice = "Push";
                    break;
                case 2 :
                    System.out.println("Data Popped is : "+stack.pop());
                    System.out.println("Displaying the stack");
                    stack.display();
                    choice = "Pop";
                    break;
                case 3 :
                    System.out.println("Enter the Position");
                    int pos = new Scanner(System.in).nextInt();
                    System.out.println("Result of peek is : "+stack.peek(pos));
                    System.out.println("Displaying the stack");
                    stack.display();
                    choice = "Peek";
                    break;
                case 4 :
                    System.out.println("Result of stackTop is : "+stack.stackTop());
                    System.out.println("Displaying the stack");
                    stack.display();
                    choice = "StackTop";
                    break;
                case 5 :
                    System.out.println("IsEmpty : "+stack.isEmpty());
                    System.out.println("Displaying the stack");
                    stack.display();
                    choice = "IsEmpty";
                    break;
                case 6 :
                    System.out.println("IsFull : "+stack.isFull());
                    System.out.println("Displaying the stack");
                    stack.display();
                    choice = "IsFull";
                    break;
                case 7 :
                    System.out.println("Displaying the stack");
                    stack.display();
                    choice = "Display";
                    break;
                case 8 :
                    choice = "Exit";
                    break;
            }
        }
    }
}
