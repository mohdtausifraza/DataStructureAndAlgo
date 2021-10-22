package Queues;

import java.util.Scanner;

public class QueueUsingLinkedList<T> {

    Node<T> front,rear;

    static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Creates Empty Queue
     */
    public QueueUsingLinkedList() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(T data){
        Node<T> node = new Node<>(data);
        if (isFull()){
            System.out.println("Queue is full");
        }else{
            if (front==null){
                front = rear = node;
            }else {
                rear.next = node;
                rear = node;
            }
        }
    }

    public T dequeue(){
        T data=null;
        if (isEmpty()){
            System.out.println("Queue is Empty");
        }else if (front==rear){
            data = front.data;
            front = rear = null;
        }else {
            data = front.data;
            front = front.next;
        }
        return data;
    }

    public T first(){
        if (isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        return front.data;
    }

    public T last(){
        if (isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        return rear.data;
    }

    public boolean isEmpty(){
        return  front == null;
    }

    public boolean isFull(){
        try {
            new Node<>(-1);
        }catch (Exception e){
            return true;
        }
        return false;
    }

    public void display(){
        System.out.println("Displaying the Queue");
        Node<T> temp = front;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
        System.out.println("Empty Queue Created Successfully");
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
