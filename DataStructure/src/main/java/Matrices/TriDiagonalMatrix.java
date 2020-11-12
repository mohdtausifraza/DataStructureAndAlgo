package Matrices;

/**
 * Element is Non-Zero if   (i-j=1) OR (i-j=0) OR (i-j=-1)
 *                          |i-j| <= 1;
 *              1 1 0 0 0
 *              1 1 1 0 0
 * A[i,j] =     0 1 1 1 0
 *              0 0 1 1 1
 *              0 0 0 1 1
 *
 *  Formula to store this 2-D Array in equivalent 1-D array Diagonal By Diagonal (Lower Diagonal -> Main Diagonal -> Upper Diagonal)
 *
 *  Size of 1-D array will be : 3n-2
 *
 *  A[i][j] = a21,a32,a43,a54 , a11,a22,a33,a44,a55 , a12,a23,a34,a45
 *            Lower-Diagonal    Main-Diagonal         Upper-Diagonal
 *
 * How to get Index
 *      CASE 1 : if (i-j=1) => Lower-Diagonal   => Store in result[j-1]
 *      CASE 2 : if (i-j=0) => Main-Diagonal    => Store in result[(n-1)+(i-1)]
 *      CASE 3 : if (i-j=-1) => Upper-Diagonal  => Store in result[(2n-1)+(i-1)]
 */
public class TriDiagonalMatrix {

    public static int[] result;
    public static int n;

    /**
     * Creating 1-D array of non zero element using above formula.
     */
    TriDiagonalMatrix(int [][] input) {
        n = input.length;
        // Creating 1-D array to store all non-zero element of 2-D Array.
        result = new int[(3*n)-2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i-j == 1) {
                    result[j-1] = input[i-1][j-1];
                }else if (i-j == 0){
                    result[(n-1)+(i-1)] = input[i-1][j-1];
                }else if (i-j == -1){
                    result[(2*n-1)+(i-1)] = input[i-1][j-1];
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
                if (i-j == 1) {
                    System.out.print(result[j-1] + " ");
                }else if (i-j == 0){
                    System.out.print(result[(n-1)+(i-1)] +" ");
                }else if (i-j == -1){
                    System.out.print(result[(2*n-1)+(i-1)] +" ");
                }else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] input = {
                {1,1,0,0,0},
                {1,1,1,0,0},
                {0,1,1,1,0},
                {0,0,1,1,1},
                {0,0,0,1,1},
        };
        // Creating 1-D Matrix equivalent to TriDiagonal Matrix
        new TriDiagonalMatrix(input);
        // Printing TriDiagonal Matrix
        System.out.println("TriDiagonal Matrix :");
        display();
        // Printing 1-D Matrix equivalent to TriDiagonal Matrix
        System.out.println("1-D Matrix equivalent to TriDiagonal Matrix :");
        for (int a : result){
            System.out.print(a+ " ");
        }
    }
}
