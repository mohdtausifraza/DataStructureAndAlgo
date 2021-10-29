package Queues;

import java.util.Scanner;

/**
 * It doesn't follow FIFO.
 * In Double Ended Queue you can use both the pointer for Insertion and Deletion.
 *
 * It also has variation
 * 1. Input Restricted Double Ended Queue
 *              Insert          Delete
 *      Front   Not Allowed     Allowed
 *      Rear    Allowed         Allowed
 * 2. Output Restricted Double Ended Queue
 *              Insert          Delete
 *      Front   Allowed         Allowed
 *      Rear    Allowed         Delete
 */
public class DoubleEndedQueue {

    int size;
    int front,rear;
    int[] queue;

    /**
     * Creates Queue of Size
     * @param size Size of the array
     */
    public DoubleEndedQueue(int size) {
        this.size = size;
        this.front = -1;
        this.rear = -1;
        queue = new int[size];
    }

    public void enqueueFromFront(int data){
        if (front == -1){
            System.out.println("Cannot Insert from front");
            return;
        }
        queue[front--] = data;
    }

    public void enqueueFromRear(int data){
        if (rear == this.size-1){
            System.out.println("Cannot Insert from Rear");
            return;
        }
        queue[++rear] = data;
    }

    public int dequeueFromRear(){
        if (rear == front){
            System.out.println("Queue is empty cannot dequeue");
            return -1;
        }
        return queue[rear--];
    }

    public void display(){
        System.out.println("Displaying the Queue");
        for (int i=front+1 ; i<=rear ; i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of the Queue");
        int size = new Scanner(System.in).nextInt();
        DoubleEndedQueue queue = new DoubleEndedQueue(size);
        System.out.println("Queue of Size="+size+" Created Successfully");
        int choice=0;
        while (choice != 10){
            System.out.println("Enter Your choice");
            System.out.println("1.enqueueFromFront(T x)");
            System.out.println("2.enqueueFromRear(T x)");
            System.out.println("9.display()");
            System.out.println("10.Exit()");
            int option = new Scanner(System.in).nextInt();
            switch (option){
                case 1 :
                    System.out.println("Enter the element to be Enqueued From Front");
                    queue.enqueueFromFront(new Scanner(System.in).nextInt());
                    queue.display();
                    break;
                case 2 :
                    System.out.println("Enter the element to be Enqueued From Rear");
                    queue.enqueueFromRear(new Scanner(System.in).nextInt());
                    queue.display();
                    break;
                case 4 :
                    System.out.println("Data dequeued is : "+queue.dequeueFromRear());
                    queue.display();
                    break;
                case 9 :
                    queue.display();
                    break;
                case 10 :
                    choice = 10;
                    break;
            }
        }
    }
}
