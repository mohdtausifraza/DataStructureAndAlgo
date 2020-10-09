package level1.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Ques : Two Sum
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
 * **************************************************************************************
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {
    /**
     * Approach :   Take a HashMap<value , index>.
     *              Put nums[0] in hasMap
     *              Traverse in array and take diff of target and nums[i];
     *              Search that diff in the hashMap.
     *              If found return the value of hashMap and i as the result. [valueOfHashMap , i ]
     *              else add the value and index in the hashMap
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int []result = new int[2];
            Map<Integer,Integer> valueAndIndex = new HashMap();
            valueAndIndex.put(nums[0],0);
            for(int i=1 ; i < nums.length ; i++ ){
                if(valueAndIndex.containsKey(target-nums[i])){
                    result[0] = valueAndIndex.get(target-nums[i]);
                    result[1] = i;
                }else{
                    valueAndIndex.put(nums[i],i);
                }
            }
            return result;
        }
    }
}
