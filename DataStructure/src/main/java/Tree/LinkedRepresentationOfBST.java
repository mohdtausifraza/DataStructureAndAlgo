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

    /**
     * Creating BST from given keys
     */
    public Node createBST(int[] keys) {
        if (keys.length < 1)
            return null;
        Node root = insertIteratively(null, keys[0]);
        IntStream.range(1, keys.length).forEach(i -> {
            insertIteratively(root, keys[i]);
        });
        return root;
    }

    /**
     * Inorder Traversal in BST
     * It will always gives the element in sorted order
     */
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.leftChild);
            System.out.print(node.data + "  ");
            inorder(node.rightChild);
        }
    }

    /**
     * Searching in BST (Recursive)
     */
    public Node searchRecursive(Node node, int key) {
        if (node == null) {
            return null;
        } else if (node.data == key) {
            return node;
        } else if (key < node.data) {
            return searchRecursive(node.leftChild, key);
        } else {
            return searchRecursive(node.rightChild, key);
        }
    }

    /**
     * Searching in BST (Iterative)
     */
    public Node searchIterative(Node node, int key) {
        while (node != null) {
            if (node.data == key) {
                return node;
            } else if (key < node.data) {
                node = node.leftChild;
            } else {
                node = node.rightChild;
            }
        }
        return null;
    }

    /**
     * Height Of a Tree
     */
    public int height(Node node) {
        int x, y;
        if (node != null) {
            x = height(node.leftChild);
            y = height(node.rightChild);
            return (x > y) ? x + 1 : y + 1;
        }
        return 0;
    }

    /**
     * Inorder Predecessor of a Node
     */
    public Node inorderPredecessor(Node node) {
        if (node == null || node.leftChild == null) {
            return null;
        }
        node = node.leftChild;
        while (node.rightChild != null) {
            node = node.rightChild;
        }
        return node;
    }

    /**
     * Inorder Successor of a Node
     */
    public Node inorderSuccessor(Node node) {
        if (node == null || node.rightChild == null) {
            return null;
        }
        node = node.rightChild;
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;
    }
    public static void main(String[] args) {
        LinkedRepresentationOfBST bst = new LinkedRepresentationOfBST();
        int[] keys = {9, 15, 5, 20, 16, 8, 12, 3, 6};
    }
}
