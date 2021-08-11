package Recursion;

/**
 * Problem Path : https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 *
 * The problem is to count all the possible paths from top left to bottom right of a mXn matrix
 * with the constraints that from each cell you can either move only to right or down
 *
 * Example :
 *      Input :  m = 2, n = 2;
 *      Output : 2
 *          There are two paths
 *          (0, 0) -> (0, 1) -> (1, 1)
 *          (0, 0) -> (1, 0) -> (1, 1)
 *
 *      Input :  m = 2, n = 3;
 *      Output : 3
 *          There are three paths
 *          (0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
 *          (0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
 *          (0, 0) -> (1, 0) -> (1, 1) -> (1, 2)
 */
public class FindPathInMatrix {
    public static int path(int m, int n){
        if (m==1 || n==1){
            return 1;
        }
        return path(m,n-1) + path(m-1, n);
    }
    public static void main(String[] args) {
        System.out.println(path(2,3));
    }
}
