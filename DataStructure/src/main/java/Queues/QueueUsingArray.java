package Queues;

import java.util.Scanner;

/**
 * Queue ADT
 * Data :
 *      1. Space for storing the element
 *      2. Front for deletion
 *      3. Rear for insertion
 * Operations :
 *      1. enqueue(T data)
 *      2. dequeue()
 *      3. isEmpty()
 *      4. isFull()
 *      5. first()
 *      6. last()
 */
public class QueueUsingArray {

    /**
     * 1. Queue Using Single Pointer (At Rear only)
     *      Insert Time Complexity : O(1)
     *      Delete Time Complexity : O(n)
     */

    /**
     * 2. Queue Using Double Pointer (Front and Rear)
     *      Insert Time Complexity : O(1)
     *      Delete Time Complexity : O(1)
     */

    int size;
    int front,rear;
    int[] queue;

    public QueueUsingArray() {
    }

    /**
     * Creates Queue of Size
     * @param size Size of the array
     */
    public QueueUsingArray(int size) {
        this.size = size;
        this.front = -1;
        this.rear = -1;
        queue = new int[size];
    }


    public  void enqueue(int data){
        if (isFull()){
            System.out.println("Queue is full");
        }else {
            queue[++rear] = data;
        }
    }
    public int dequeue(){
        int data=-1;
        if (isEmpty()){
            System.out.println("Queue is Empty");
        }else {

            data = queue[++front];
            queue[front] = -1;
        }
        return data;
    }

    public boolean isEmpty(){
        return  front == rear;
    }

    public boolean isFull(){
        return rear == this.size-1;
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
        QueueUsingArray queue = new QueueUsingArray(size);
        System.out.println("Queue of Size="+size+" Created Successfully");
        int choice=0;
        while (choice != 8){
            System.out.println("Enter Your choice");
            System.out.println("1.enqueue(T x)");
            System.out.println("2.dequeue()");
            System.out.println("3.first()");
            System.out.println("4.last()");
            System.out.println("5.isEmpty()");
            System.out.println("6.isFull()");
            System.out.println("7.display()");
            System.out.println("8.Exit()");
            int option = new Scanner(System.in).nextInt();
            switch (option){
                case 1 :
                    System.out.println("Enter the element to be enqueued");
                    int data = new Scanner(System.in).nextInt();
                    queue.enqueue(data);
                    queue.display();
                    break;
                case 2 :
                    System.out.println("Data dequeued is : "+queue.dequeue());
                    queue.display();
                    break;
                case 5 :
                    System.out.println("IsEmpty : "+queue.isEmpty());
                    queue.display();
                    break;
                case 6 :
                    System.out.println("IsFull : "+queue.isFull());
                    queue.display();
                    break;
                case 7 :
                    queue.display();
                    break;
                case 8 :
                    choice = 8;
                    break;
            }
        }
    }
}
