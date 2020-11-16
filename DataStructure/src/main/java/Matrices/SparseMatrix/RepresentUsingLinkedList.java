package Matrices.SparseMatrix;

/**
 * A matrix in which more elements are zero elements.
 *
 *  0 0 0 0 0 0 1 0 0
 *  0 0 0 5 0 0 0 0 0
 *  9 0 0 0 0 7 0 0 0
 *  0 0 0 0 0 0 0 0 0
 *  0 0 0 0 5 0 0 0 0
 *  0 0 0 0 0 0 0 0 0
 *  0 3 0 0 0 0 0 0 0
 *  0 0 0 0 0 0 0 0 0

 */
public class RepresentUsingLinkedList {

    Node[] row;
    int m,n;
    static class Node{
        int col;
        int val;
        Node next;

        public Node(int col, int val, Node next) {
            this.col = col;
            this.val = val;
            this.next = next;
        }
    }

    RepresentUsingLinkedList(int[][] sparseMatrix){
        m = sparseMatrix.length;
        n = sparseMatrix[0].length;
        row = new Node[sparseMatrix.length];
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (sparseMatrix[i][j] != 0){
                    if (row[i] == null){
                        row[i] = new Node(j,sparseMatrix[i][j],null);
                    }else {
                        Node node = row[i];
                        while (node.next != null){
                            node = node.next;
                        }
                        node.next = new Node(j,sparseMatrix[i][j],null);
                    }
                }
            }
        }
    }

    public void display(){

        for (int i = 0 ; i < m ; i++) {
            Node node = row[i];
            for (int j = 0; j < n; j++) {
                if (node != null && node.col==j){
                    System.out.print(node.val+" ");
                    node = node.next;
                }else{
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    public void displayRepresentation(){

        for (int i = 0 ; i < row.length ; i++){
            if (row[i] != null){
                Node node = row[i];
                while (node != null){
                    System.out.println("Row="+i +" Col="+node.col+ " Value="+node.val);
                    node = node.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] sparseMatrix = {
                {1,0,0,0,0},
                {0,2,0,0,0},
                {0,2,3,0,0},
                {0,0,0,4,0},
                {0,0,0,0,5},
        };
        RepresentUsingLinkedList list = new RepresentUsingLinkedList(sparseMatrix);
        //Displaying Sparse Matrix from CoordinateList which we have created.
        list.display();
        System.out.println("1-D equivalent Sparse Matrix");
        list.displayRepresentation();
    }

}
