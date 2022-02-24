package Tree;

/**
 * Height Balanced Binary Search Trees.
 * Its is balanced using Balance Factor, which is calculated on every one
 * balanceFactor = Height of Left SubTree - Height of Right Subtree
 * balanceFactor = (-1,0,1)
 * If |bf| = |hl-hr| <= 1 (Balanced)
 * If |bf| = |hl-hr| > 1 (ImBalanced)
 * <p>
 * We perform rotation for balancing the Tree.
 */
public class AVLTree {
    static class Node {
        Node leftChild;
        int data;
        int height;
        Node rightChild;

        Node(int data) {
            this.leftChild = null;
            this.data = data;
            this.rightChild = null;
            this.height = 1;
        }
    }

    Node root = null;

    public Node insert(Node node, int data) {
        // 1. Perform Normal BST Insertion
        if (node == null) {
            return new Node(data);
        } else if (data < node.data) {
            node.leftChild = insert(node.leftChild, data);
        } else if (data > node.data) {
            node.rightChild = insert(node.rightChild, data);
        } else { // Duplicate keys not allowed
            return node;
        }
        // 2. Update height of the ancestor Node
        node.height = 1+ Integer.max(height(node.leftChild),height(node.rightChild));

        // 3. Calculate Balance Factor of the Node, to check whether this ancestor node became unbalanced.
        int balanceFactor = getBalanceFactor(node);

        // If this node becomes unbalanced, then there are 4 cases
        // 1 Left-Left Case
        if (balanceFactor > 1 && data < node.leftChild.data){
            return rotateRight(node);
        }
        // 2. Right-Right Case
        if(balanceFactor < -1 && data > node.rightChild.data){
            return rotateLeft(node);
        }
        // 3. Left-Right Case
        if (balanceFactor > 1 && data > node.leftChild.data){
            node.leftChild = rotateLeft(node.leftChild);
            return rotateRight(node);
        }
        // 4. Right-Left Case
        if (balanceFactor < -1 && data < node.rightChild.data){
            node.rightChild = rotateRight(node.rightChild);
            return rotateLeft(node);
        }
        return node;
    }

    public Node delete(Node node, int data){
        // 1. Perform Standard BST delete
        if (node == null){
            return null;
        }
        // Deleting the leaf Node
        if (node.leftChild== null && node.rightChild==null && data==node.data){
            return null;
        }
        // Search In the Tree
        if (data < node.data){
            node.leftChild = delete(node.leftChild, data);
        }else if (data > node.data){
            node.rightChild= delete(node.rightChild,data);
        }
        // If the data as same as node.data, this node to be deleted
        else {
            // Replacing the node with the Predecessor
            if (height(node.leftChild) > height(node.rightChild)){
                Node temp = inorderPredecessor(node);
                node.data=temp.data;
                node.leftChild = delete(node.leftChild, temp.data);
            }else { // Replacing the node with the Accessor
                Node temp = inorderSuccessor(node);
                node.data = temp.data;
                node.rightChild = delete(node.rightChild,temp.data);
            }
        }
        // Return if root becomes null;
        if (root==null){
            return root;
        }
        // 2. Update height of the ancestor Node
        node.height = 1+ Integer.max(height(node.leftChild), height(node.rightChild));

        // Get the Balance Factor of the Node
        int balanceFactor = getBalanceFactor(node);

        // If the node becomes unbalanced than there are four cases
        // Left Left Case
        if (balanceFactor>1 && getBalanceFactor(node.leftChild)>=0){
            return rotateRight(node);
        }
        // Left Right Case
        if (balanceFactor>1 && getBalanceFactor(node.leftChild)<0){
            node.leftChild = rotateLeft(node.leftChild);
            return rotateRight(node);
        }
        // Right Right Case
        if (balanceFactor<-1 && getBalanceFactor(node.rightChild)<=0){
            return rotateLeft(node);
        }
        // Right Left Case
        if (balanceFactor<-1 && getBalanceFactor(node.rightChild)>0){
            node.rightChild= rotateRight(node.rightChild);
            return rotateLeft(node);
        }
        return node;
    }

    private Node inorderPredecessor(Node node){
        if (node == null || node.leftChild == null){
            return null;
        }
        node = node.leftChild;
        while (node.rightChild!=null){
            node = node.rightChild;
        }
        return node;
    }

    private Node inorderSuccessor(Node node){
        if (node==null || node.rightChild==null){
            return null;
        }
        node = node.rightChild;
        while (node.leftChild!=null){
            node=node.leftChild;
        }
        return node;
    }
    // Rotate Right
    private Node rotateRight(Node p){
        System.out.println("Performing Rotate Right");
        Node pl = p.leftChild;
        Node plr = pl.rightChild;

        //Perform rotation
        p.leftChild = plr;
        pl.rightChild = p;

        p.height = Integer.max(height(p.leftChild), height(p.rightChild))+1;
        pl.height = Integer.max(height(pl.leftChild), height(pl.rightChild))+1;

        if (p == this.root){
            this.root=pl;
        }
        return pl;
    }

    //Left Rotate
    private Node rotateLeft(Node p){
        System.out.println("Performing Rotate Left");
        Node pr = p.rightChild;
        Node prl = pr.leftChild;

        //Perform rotation
        p.rightChild = prl;
        pr.leftChild = p;

        p.height = Integer.max(height(p.leftChild), height(p.rightChild))+1;
        pr.height = Integer.max(height(pr.leftChild), height(pr.rightChild))+1;

        if (p==root){
            root = pr;
        }
        return pr;
    }

    // A utility method to get the Balance Factor of a node.
    private int getBalanceFactor(Node node){
        if (node==null){
            return 0;
        }
        return height(node.leftChild)-height(node.rightChild);
    }
    // A utility function to get height of a tree
    public int  height(Node node) {
        if (node == null){
            return 0;
        }
        return node.height;
    }

    // Inorder Traversal of AVL tree, which will give sorted elements
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.leftChild);
            System.out.print(root.data + "(" + root.height + ") ");
            inorder(root.rightChild);
        }
    }

    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        avl.root = avl.insert(avl.root, 10);
        avl.root = avl.insert(avl.root, 20);
        avl.root = avl.insert(avl.root, 30);
        avl.root = avl.insert(avl.root, 25);
        avl.root = avl.insert(avl.root, 28);
        avl.root = avl.insert(avl.root, 27);
        avl.root = avl.insert(avl.root, 5);
        System.out.print("Inorder Traversal :");
        avl.inorder(avl.root);
        System.out.println();
        avl.root = avl.delete(avl.root, 30);
        avl.root = avl.delete(avl.root, 27);
        avl.root = avl.delete(avl.root, 28);
        avl.root = avl.delete(avl.root, 5);
        System.out.print("Inorder Traversal :");
        avl.inorder(avl.root);
        System.out.println();

    }
}
