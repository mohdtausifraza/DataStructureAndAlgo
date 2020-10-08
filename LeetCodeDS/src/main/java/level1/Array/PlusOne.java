package level1.Array;

/**
 * Ques : Plus One                                                                            *
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/  *
 * *****************************************************************************************
 * Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
public class PlusOne {
    /**
     * Approach :   Take carry=1
     *              Traverse in the array from the end and add carry
     *              if result <=9
     *                  updated element at index and return the array
     *              if result > 9
     *                  leave carry to be 1 place zero at that index and move backward
     *              if result>9 and index==0
     *                  create new array with one more size and place carry at 0 and rest array from previous array.
     */
    class Solution {
        public int[] plusOne(int[] digits) {
            if(digits[digits.length-1] != 9){
                digits[digits.length-1] = digits[digits.length-1]+1;
                return digits;
            }
            int carry=1;
            for( int i=digits.length-1 ; i >=0 ; i-- ){
                int temp=digits[i]+carry;
                if(temp <=9){
                    digits[i]=temp;
                    carry=0;
                    return digits;
                }
                if(temp > 9){
                    digits[i]=0;
                }if(temp > 9 && i == 0 && carry == 1 ){
                    digits[0]=0;
                    int[] newDigits = new int[digits.length+1];
                    newDigits[0]=carry;
                    for(int j = 0 ; j< newDigits.length-1 ;j++){
                        newDigits[j+1]=digits[j];
                    }
                    return newDigits;
                }
            }
            return null;
        }
    }
}
