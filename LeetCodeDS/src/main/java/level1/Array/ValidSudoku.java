package level1.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Ques : Valid Sudoku
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/  *
 * *****************************************************************************************
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */
public class ValidSudoku {
    /**
     * Approach :   Take the element from the matrix and add to a HashSet forming three different string
     *              1.  [Value] found for row [i]
     *              2.  [Value] found for clumn [j]
     *              3.  [Value] found for box [i/3] - [j/3]
     */
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet();
        for(int i=0 ; i< 9 ; i++){
            for(int j=0 ; j< 9 ; j++){
                char currentElement=board[i][j];
                if(board[i][j] != '.')
                {
                    if( !set.add(board[i][j] + "found in row "+i) ||
                            !set.add(board[i][j] + "found in column "+j) ||
                            !set.add(board[i][j] + "found in box "+(i/3)+"-"+(j/3)))
                        return false;
                }
            }
        }
        return true;
    }
}
