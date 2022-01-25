package Tree;

import Queues.QueueUsingLinkedList;
import Stack.StackUsingLinkedList;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * If Number of Elements = n, then number of null pointer will be n+1;
 */
public class LinkedRepresentationOfBinaryTree {
    static class Node{
        Node rightChild;
        Node leftChild;
        int data;
        Node(int data){
            this.rightChild=null;
            this.leftChild=null;
            this.data= data;
        }
    }

    public Node createTree(int[] array){
        IntStream intStream = Arrays.stream(array);
        if (!intStream.findFirst().isPresent()){
            System.out.println("Array Is Empty");
            return null;
        }

        // 1. Create a Queue.
        // 2. Create root with leftChild and RightChild as null and enqueue its reference in Queue.
        // 3. Dequeue a reference from the queue, and read a data from the array, if data != -1 go Step 4, else go to step 5.
        // 4. Create LeftChild (Node) with its leftChild and RightChild as null, and enqueue its reference in the queue.
        // 5. Create RightChild (Node) with its leftChild and RightChild as null, and enqueue its reference in the queue.
        // 6. Goto Step 3 if queue is not empty. If queue is Empty return the root node reference.
        QueueUsingLinkedList<Node> queue = new QueueUsingLinkedList<>();
        Node root = new Node(Arrays.stream(array).findFirst().getAsInt());
        queue.enqueue(root);
        int index=1;
        while(!queue.isEmpty() && index<array.length){
            Node parent = queue.dequeue();
                int leftChildData = array[index];
                int rightChildData = (index+1 >= array.length) ? -1 :array[index+1];
                if (leftChildData!=-1){
                    Node leftNode = new Node(leftChildData);
                    queue.enqueue(leftNode);
                    parent.leftChild=leftNode;
                }
                if (rightChildData!=-1){
                    Node rightNode = new Node(rightChildData);
                    queue.enqueue(rightNode);
                    parent.rightChild=rightNode;
                }
                index+=2;
        }
        return root;
    }

    // Preorder Traversal
    // Time Complexity : O(n)
    public void preorder(Node node){
        if (node!=null){
            System.out.print(node.data+" ");
            preorder(node.leftChild);
            preorder(node.rightChild);
        }
    }

    // Inorder Traversal
    // Time Complexity : O(n)
    private void inorder(Node node){
        if (node!=null){
            inorder(node.leftChild);
            System.out.print(node.data+" ");
            inorder(node.rightChild);
        }
    }

    // postorder Traversal
    // Time Complexity : O(n)
    public void postorder(Node node){
        if (node!=null){
            postorder(node.leftChild);
            postorder(node.rightChild);
            System.out.print(node.data+" ");
        }
    }

    //Iterative Preorder
    public void iterativePreorder(Node node){
        StackUsingLinkedList<Node> stack = new StackUsingLinkedList<>();
        Node temp = node;
        while (temp!=null || !stack.isEmpty()){
            if (temp!=null){
                System.out.println(temp.data);
                stack.push(temp);
                temp=temp.leftChild;
            }else {
                temp = stack.pop();
                temp = temp.rightChild;
            }
        }
    }

    public static void main(String[] args) {
        LinkedRepresentationOfBinaryTree tree = new LinkedRepresentationOfBinaryTree();
        int[] array = new int[]{8,3,5,12,-1,10,6,-1,4,-1,-1,2,-1,9,7,};
        Node root = tree.createTree(array);
    }
}
