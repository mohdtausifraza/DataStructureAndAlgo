package level1.Array;

/**
 * Ques : Move Zeroes
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/  *
 * *****************************************************************************************
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes {
    /**
     *  Approach :  Take two pointer left and right.
     *              Right will move till it found the non zero
     *                  Swap the element of right with left
     *                  Increment left
     *              Fill rest places starting from left with Zero
     */
    class Solution {
        public void moveZeroes(int[] nums) {
            if(nums.length<2)
                return;
            int left=0;
            for(int right=0; right<nums.length ; right++){
                if(nums[right] != 0){
                    nums[left++]=nums[right];
                }
            }
            for(int i=left; i<nums.length ; i++){
                nums[i] =0;
            }
        }
    }
}
