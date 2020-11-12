package Matrices;

/**
 * Element At A[i][j] == A[j][i]
 *
 * Its like folding the matrix diagonally.
 *              2 2 2 2 2
 *              2 3 3 3 3
 * A[i,j] =     2 3 4 4 4
 *              2 3 4 5 5
 *              2 3 4 5 6
 *  If we store either LOWER OR UPPER TRIANGULAR matrix of this in a 1-D array. We will be having all the elements.
 *
 *  We will be using Upper Triangular Matrix
 *      Row-Major Formula       : [ n * (i-1) -(i-2)*(i-1)/2 + (j-i) ]
 *      Column-Major Formula    : [ j * (j-1)/2 + (i-1) ]
 */
public class SymmetricMatrix {

    public static int[] result;
    public static int n;

    /**
     * Creating 1-D array of non zero element using ROW-MAJOR Formula [ n * (i-1) -(i-2)*(i-1)/2 + (j-i) ]
     * and COLUMN-MAJOR Formula [ j * (j-1)/2 + (i-1) ]
     */
    SymmetricMatrix(int [][] input) {
        n = input.length;
        // Creating 1-D array to store all non-zero element of 2-D Array.
        result = new int[n*(n+1)/2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i <= j) {
                    //Using Row-Major Formula
                    result[n * (i-1) -(i-2)*(i-1)/2 + (j-i)] = input[i-1][j-1];
                    //Using Column-Major Formula
//                    result[ j * (j-1)/2 + (i-1) ] = input[i-1][j-1];
                }
            }
        }
    }

    /**
     *
     *  1-D Array equivalent to 2-D Symmetric Matrix
     *  from which we will print equivalent 2-D Symmetric Matrix
     */
    public static void display(){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i <= j) {
                    //Using Row-Major Formula
                    System.out.print(result[n * (i-1) -(i-2)*(i-1)/2 + (j-i)]+" ");
                    //Using Column-Major Formula
//                    System.out.print(result[j * (j-1)/2 + (i-1) ]+" ");
                }else if (i  > j){
                    // Replace i with j in both the formula.

                    //Using Row-Major Formula
                    System.out.print(result[n * (j-1) -(j-2)*(j-1)/2 + (i-j)]+" ");
                    //Using Column-Major Formula
//                    System.out.print(result[j * (i-1)/2 + (i-1) ]+" ");
                }else {

                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] input = {
                {2,2,2,2,2},
                {2,3,3,3,3},
                {2,3,4,4,4},
                {2,3,4,5,5},
                {2,3,4,5,6},
        };
        // Creating 1-D Matrix equivalent to Symmetric Matrix
        new SymmetricMatrix(input);
        // Printing Symmetric Matrix
        System.out.println("Symmetric Matrix :");
        display();
        // Printing 1-D Matrix equivalent to Symmetric Matrix
        System.out.println("1-D Matrix equivalent to Symmetric Matrix :");
        for (int a : result){
            System.out.print(a+ " ");
        }
    }
}
