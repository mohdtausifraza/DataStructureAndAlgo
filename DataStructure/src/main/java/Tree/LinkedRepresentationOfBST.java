package Tree;

import Stack.StackUsingLinkedList;

import java.util.stream.IntStream;

public class LinkedRepresentationOfBST {
    public static class Node {
        public Node leftChild;
        public Node rightChild;
        public int data;

        public Node(int data) {
            this.leftChild = null;
            this.rightChild = null;
            this.data = data;
        }
    }

    /**
     * Insert in a BST (Iterative)
     * 1. Search for the keys in the tree with tail pointer
     * 2. If the key is found don't insert
     * 3. Else insert using tail pointer;
     */
    public Node insertIteratively(Node root, int key) {
        if (root == null) {
            return new Node(key);
        } else {
            Node tail = null, temp = root;
            while (temp != null) {
                tail = temp;
                if (key == temp.data) {
                    return root;
                } else if (key < temp.data) {
                    temp = temp.leftChild;
                } else if (key > temp.data) {
                    temp = temp.rightChild;
                }
            }
            if (key < tail.data) {
                tail.leftChild = new Node(key);
            } else {
                tail.rightChild = new Node(key);
            }
        }
        return root;
    }

    /**
     * Insert in a BST (Recursive)
     */
    public Node insertRecursively(Node node, int key) {
        if (node == null) {
            return new Node(key);
        } else if (key == node.data) {
            return node;
        } else if (key < node.data) {
            node.leftChild = insertRecursively(node.leftChild, key);
        } else {
            node.rightChild = insertRecursively(node.rightChild, key);
        }
        return node;
    }

    public static void main(String[] args) {
        LinkedRepresentationOfBST bst = new LinkedRepresentationOfBST();
        int[] keys = {9, 15, 5, 20, 16, 8, 12, 3, 6};
    }
}
