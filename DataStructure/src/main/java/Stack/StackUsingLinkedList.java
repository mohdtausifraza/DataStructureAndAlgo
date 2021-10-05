package Stack;

import java.util.Scanner;

/**
 * Here we will represent Stack using LinkedList as the Physical DataStructure
 *
 * Here we will always insert the element at the head of the LL so that Complexity will be O(1)
 */
public class StackUsingLinkedList<T> {
    Node<T> top;

    static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public StackUsingLinkedList() {
        this.top = null;
    }

    public void push(T x){
        if (!isFull()){
            Node<T> node = new Node<>(x);
            node.next = top;
            top = node;
        }else {
            System.out.println("Stack Overflow");
        }
    }

    public T pop(){
        T x=null;
        if (isEmpty()){
            System.out.println("Stack Underflow");
        }else {
            x = top.data;
            top = top.next;
        }
        return x;
    }

    /**
     * Element is null if the index is out of bound.
     */
    public T peek(int pos){
        T x=null;
        Node<T> temp = top;
        for (int i=0 ; temp!=null && i<pos-1 ; i++){
            temp = temp.next;
        }
        if (temp!=null && pos > 0){
            x = temp.data;
        }
        return x;
    }

    /**
     * StackTop is the element pointed by top reference variable
     */
    public T stackTop(){
        if (isEmpty()){
            System.out.println("Stack Underflow");
            return null;
        }else {
            return top.data;
        }
    }

    /**
     * Display Stack
     */
    public void display(){
        Node<T> temp = top;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     * Stack is Empty if heap top is pointing to null
     */
    public boolean isEmpty(){
        return top == null ;
    }

    /**
     * Stack is Full if heap is full and no object can be created.
     */
    public boolean isFull(){
        try {
            new Node<T>(null);
        }catch (Exception e){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Creating Stack");
        StackUsingLinkedList<Integer> stack= new StackUsingLinkedList<>();
        System.out.println("Stack of size=0 created successfully");

        int choice=-1;
        while (choice != 8){
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
                    choice = 1;
                    break;
                case 2 :
                    System.out.println("Data Popped is : "+stack.pop());
                    System.out.println("Displaying the stack");
                    stack.display();
                    choice = 2;
                    break;
                case 3 :
                    System.out.println("Enter the Position");
                    int pos = new Scanner(System.in).nextInt();
                    System.out.println("Result of peek is : "+stack.peek(pos));
                    System.out.println("Displaying the stack");
                    stack.display();
                    choice = 3;
                    break;
                case 4 :
                    System.out.println("Result of stackTop is : "+stack.stackTop());
                    System.out.println("Displaying the stack");
                    stack.display();
                    choice = 4;
                    break;
                case 5 :
                    System.out.println("IsEmpty : "+stack.isEmpty());
                    System.out.println("Displaying the stack");
                    stack.display();
                    choice = 5;
                    break;
                case 6 :
                    System.out.println("IsFull : "+stack.isFull());
                    System.out.println("Displaying the stack");
                    stack.display();
                    choice = 6;
                    break;
                case 7 :
                    System.out.println("Displaying the stack");
                    stack.display();
                    choice = 7;
                    break;
                case 8 :
                    choice = 8;
                    break;
            }
        }
    }
}
