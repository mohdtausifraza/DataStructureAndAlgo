package level1.Array;

/**
 * Ques : Rotate Image
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/
 * ****************************************************************************************
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation
 */
public class RotateImage {
    /**
     * Approach :   Transpose matrix (Convert rows to column) swap(arr[i][j] , arr[j][i]) where inner loop j starts with i;
     *              Flip Horizontally swap (arr[i][j] , arr[i][n-1-j]). Where j < n/2
     */
    public void rotate(int[][] matrix) {
        if(matrix.length != matrix[0].length || matrix.length < 2)
            return;
        int n = matrix[0].length;
        int temp = 0, i, j;
        // Transpose Matrix (Converts Rows to Column)
        for(i=0 ; i < n ; i++){
            for(j=i ; j < n ; j++){
                if(i != j){
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        // Flip Horizontally
        for(i=0 ; i < n ; i++){
            for(j=0 ; j < n/2 ; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}
