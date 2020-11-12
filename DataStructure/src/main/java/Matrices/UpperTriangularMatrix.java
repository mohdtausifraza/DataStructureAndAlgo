package Matrices;

/**
 * All element is zero if (i > j)
 *              1 2 3 4 5
 *              0 1 2 3 4
 * M[i,j] =     0 0 1 2 3
 *              0 0 0 1 2
 *              0 0 0 0 1
 *
 *      Row-Major Formula       : [ n * (i-1) -(i-2)*(i-1)/2 + (j-i) ]
 *      Column-Major Formula    : [ j * (j-1)/2 + (i-1) ]
 */
public class UpperTriangularMatrix {

    public static int[] result;
    public static int n;

    /**
     * Creating 1-D array of non zero element using ROW-MAJOR Formula [ n * (i-1) -(i-2)*(i-1)/2 + (j-i) ]
     * and COLUMN-MAJOR Formula [ j * (j-1)/2 + (i-1) ]
     */
    UpperTriangularMatrix(int [][] input) {
        n = input.length;
        // Creating 1-D array to store all non-zero element of 2-D Array.
        result = new int[n*(n+1)/2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i <= j) {
                    //Using Row-Major Formula
//                    result[n * (i-1) -(i-2)*(i-1)/2 + (j-i)] = input[i-1][j-1];
                    //Using Column-Major Formula
                    result[ j * (j-1)/2 + (i-1) ] = input[i-1][j-1];
                }
            }
        }
    }

    /**
     *
     *  1-D Array equivalent to 2-D Upper Triangular Matrix
     *  from which we will print equivalent 2-D Upper Triangular Matrix
     */
    public static void display(){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i <= j) {
                    //Using Row-Major Formula
//                    System.out.print(result[n * (i-1) -(i-2)*(i-1)/2 + (j-i)]+" ");
                    //Using Column-Major Formula
                    System.out.print(result[j * (j-1)/2 + (i-1) ]+" ");
                }else {
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] input = {
                {1,2,3,4,5},
                {0,1,2,3,4},
                {0,0,1,2,3},
                {0,0,0,1,2},
                {0,0,0,0,1},
        };
        // Creating 1-D Matrix equivalent to Upper Triangular Matrix
        new UpperTriangularMatrix(input);
        // Printing Upper Triangular Matrix
        System.out.println("Upper Triangular Matrix :");
        display();
        // Printing 1-D Matrix equivalent to Upper Triangular Matrix
        System.out.println("1-D Matrix equivalent to Upper Triangular Matrix :");
        for (int a : result){
            System.out.print(a+ " ");
        }
    }
}
