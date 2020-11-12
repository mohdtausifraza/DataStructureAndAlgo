package Matrices;

/**
 * All element is zero if (i < j)
 *              1 0 0 0 0
 *              1 2 0 0 0
 * M[i,j] =     1 2 3 0 0
 *              1 2 3 4 0
 *              1 2 3 4 5
 *
 *      Row-Major Formula       : [i*(i-1)/2 + (j-1)]
 *      Column-Major Formula    : [ n*(j-1)-(j-2)*(j-1)/2+(i-j) ]
 */
public class LowerTriangularMatrix {

    public static int[] result;
    public static int n;

    /**
     * Creating 1-D array of non zero element using ROW-MAJOR Formula [i*(i-1)/2 + (j-1)]
     * and COLUMN-MAJOR Formula [ n*(j-1)-(j-2)*(j-1)/2+(i-j) ]
     */
    LowerTriangularMatrix(int [][] input) {
        n = input.length;
        // Creating 1-D array to store all non-zero element of 2-D Array.
        result = new int[n*(n+1)/2];
        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= input.length; j++) {
                if (i >= j) {
                    //Using Row-Major Formula
//                    result[i*(i-1)/2 + j - 1] = input[i-1][j-1];
                    //Using Column-Major Formula
                    result[n*(j-1)-(j-2)*(j-1)/2+(i-j)] = input[i-1][j-1];
                }
            }
        }
    }

    /**
     *
     *  1-D Array equivalent to 2-D Lower Triangular Matrix
     *  from which we will print equivalent 2-D Lower Triangular Matrix
     */
    public static void display(){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= j) {
                    //Using Row-Major Formula
//                    System.out.print(result[i*(i-1)/2 + j - 1]+" ");
                    //Using Column-Major Formula
                    System.out.print(result[n*(j-1)-(j-2)*(j-1)/2+(i-j)]+" ");

                }else {
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] input = {
                {1,0,0,0,0},
                {1,2,0,0,0},
                {1,2,3,0,0},
                {1,2,3,4,0},
                {1,2,3,4,5},
        };
        // Creating 1-D Matrix equivalent to Lower Triangular Matrix
        new LowerTriangularMatrix(input);
        // Printing Lower Triangular Matrix
        System.out.println("Lower Triangular Matrix :");
        display();
        // Printing 1-D Matrix equivalent to Lower Triangular Matrix
        System.out.println("1-D Matrix equivalent to Lower Triangular Matrix :");
        for (int a : result){
            System.out.print(a+ " ");
        }
    }
}
