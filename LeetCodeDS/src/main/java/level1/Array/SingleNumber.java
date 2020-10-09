package level1.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Single Number *
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
 * ***************************************************************************************
 * Given a non-empty array of integers, every element appears twice except for one.
 * Find that single one.
 *
 * Note: Your algorithm should have a linear runtime complexity.
 *       Could you implement it without using extra memory?
 *
 *  Example 1:
 *  Input: [2,2,1]
 *  Output: 1
 */
public class SingleNumber {
    /**
     * Approach :  Traverse in the array and apply nums[i] ^ nums[i+!]
     *             The property of XOR is that when it is applied between same number it gives 0. Like ( 1 ^ 1 = 0 )
     *             Also XOR give 1 for the odd number of 1 else it gives 0;
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int i=0 ; i< nums.length ; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }

    /**
     * Optimal Solution with TimeComplexity= O(n) and ExtraSpace=O(1);
     * */
    public int singleNumberWithoutExtraSpace(int[] nums) {
        int result=0;
        for(int i : nums){
            result ^= i;
        }
        return result;
    }
}
