package Matrices;

/**
 * Elements in Diagonal Are same
 *
 *  A[i][j] == A[i-1][j-1]
 *
 *              1 2 3 4 5
 *              6 1 2 3 4
 * A[i,j] =     7 6 1 2 3
 *              8 7 6 1 2
 *              9 8 7 6 1
 *
 *  We can Store only First ROW and FIRST column element in the 1-D Array
 *
 *  Size of 1-D array will be : 2n-1
 *
 *  A[i][j] = a11,a12,a13,a14,a15 , a21,a31,a41,a51,a55
 *            ROW               COLUMN
 *
 * How to get Index
 *      CASE 1 : if (i <= j)    => Upper Triangular Matrix  => It will be found in ROW   => Store in result[j-i]
 *      CASE 2 : if (i > j)     => Upper Triangular Matrix  => It will be found in COLUMN=> Store in result[n+i-j-1]
 */
public class ToeplitzMatrix {

    public static int[] result;
    public static int n;

    /**
     * Creating 1-D array of non zero element using above formula.
     */
    ToeplitzMatrix(int [][] input) {
        n = input.length;
        // Creating 1-D array to store all non-zero element of 2-D Array.
        result = new int[(2*n)-1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i <= j) {
                    result[j-i] = input[i-1][j-1];
                }else if (i > j){
                    result[n+i-j-1] = input[i-1][j-1];
                }
            }
        }
    }

    /**
     *
     *  1-D Array equivalent to 2-D TriDiagonal Matrix
     *  from which we will print equivalent 2-D TriDiagonal Matrix
     */
    public static void display(){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i <= j) {
                    System.out.print(result[j-i]+" ");
                }else if (i > j){
                    System.out.print(result[n+i-j-1]+" ");
                }else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] input = {
                {1,2,3,4,5},
                {6,1,2,3,4},
                {7,6,1,2,3},
                {8,7,6,1,2},
                {9,8,7,6,1},
        };
        // Creating 1-D Matrix equivalent to Toeplitz Matrix
        new ToeplitzMatrix(input);
        // Printing Toeplitz Matrix
        System.out.println("Toeplitz Matrix :");
        display();
        // Printing 1-D Matrix equivalent to Toeplitz Matrix
        System.out.println("1-D Matrix equivalent to Toeplitz Matrix :");
        for (int a : result){
            System.out.print(a+ " ");
        }
    }
}
