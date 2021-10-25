package Queues;

import java.util.Scanner;

/**
 * It solves the Drawback of Queue where
 *  1.  We are not able to re-use same place, as front pointer is moved to next.
 *  2.  There is a point where front and rear both is pointing to last location of array
 *      which means array is full as well as empty.
 *
 *  Approach :  Front and Rear will point to 0th position.
 *              Start Adding from index=1
 *              Don't fill where Rear is pointing
 *
 *              To get Circular value use % Like : (rear+1)%size
 */
public class CircularQueue extends QueueUsingArray{

    public CircularQueue(int size) {
        this.size = size;
        this.front = 0;
        this.rear = 0;
        queue = new int[size];
    }

    public  void enqueue(int data){
        if ((rear+1)%size == front){
            System.out.println("Queue is full");
        }else {
            rear = (rear+1) % size;
            queue[rear] = data;
        }
    }
    public int dequeue(){
        int data=-1;
        if (isEmpty()){
            System.out.println("Queue is Empty");
        }else {
            front = (front+1)%size;
            data = queue[front];
            queue[front] = 0;
        }
        return data;
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of the Circular Queue");
        int size = new Scanner(System.in).nextInt();
        CircularQueue queue = new CircularQueue(size);
        System.out.println("Circular Queue of Size="+size+" Created Successfully");
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
                case 3 :
                    System.out.println("First element is : "+queue.first());
                    queue.display();
                    break;
                case 4 :
                    System.out.println("Last element is : "+queue.last());
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
