package Queues;

import Stack.StackUsingLinkedList;

import java.util.Scanner;

public class QueueUsingTwoStack {
    /**
     * Enqueue : Push into Stack-1
     * Dequeue : If Stack-2 is having element pop and return the top element;
     * Else if Stack-2 is empty, Transfer from Stack-1 to Stack-2 and
     * when transfer is complete delete the top of Stack-2
     */

    static StackUsingLinkedList<Integer> stack1;
    static StackUsingLinkedList<Integer> stack2;

    public void enqueue(int data) {
        stack1.push(data);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }

    public void display() {
        System.out.println("Stack-1");
        stack1.display();
        System.out.println("Stack-2");
        stack2.display();
    }

    public static void main(String[] args) {
        stack1 = new StackUsingLinkedList<>();
        stack2 = new StackUsingLinkedList<>();
        QueueUsingTwoStack queue = new QueueUsingTwoStack();
        System.out.println("Empty Queue Created Successfully");
        int choice = 0;
        while (choice != 4) {
            System.out.println("Enter Your choice");
            System.out.println("1.enqueue(T x)");
            System.out.println("2.dequeue()");
            System.out.println("3.display()");
            System.out.println("4.Exit()");
            int option = new Scanner(System.in).nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the element to be enqueued");
                    int data = new Scanner(System.in).nextInt();
                    queue.enqueue(data);
                    queue.display();
                    break;
                case 2:
                    System.out.println("Data dequeued is : " + queue.dequeue());
                    queue.display();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    choice = 4;
                    break;
            }
        }
    }
}
