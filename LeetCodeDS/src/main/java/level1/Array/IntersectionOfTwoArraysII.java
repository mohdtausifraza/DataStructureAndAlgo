package level1.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Ques : Intersection of Two Arrays II
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/ *
 * ****************************************************************************************
 * Given two arrays, write a function to compute their intersection.
 *     Input: nums1 = [1,2,2,1], nums2 = [2,2]
 *     Output: [2,2]
 */
public class IntersectionOfTwoArraysII {
    /**
     * Approach :   Take a HashMap<Value,Frequency> and put Array1 in the HashMap.
     *              Traverse in Array2 and check that element in the map.
     *              If Found
     *                  Get frequency-1 for that key in the map.
     *              Check if the map contains the element.
     *                  if yes, get the frequency-1 of that element
     *                      if the frequency is zero, then remove that entry from the map.
     *                      else update the frequency to frequency-1
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map = new HashMap();

        List<Integer> resultList = new ArrayList();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num , 0)+1);
        }
        for(int num : nums2){
            if(map.containsKey(num)){
                int temp=map.get(num)-1;
                resultList.add(num);
                if(temp==0)
                {
                    map.remove(num);
                }else{
                    map.put(num, map.get(num)-1);
                }
            }

        }
        int[] result = new int[resultList.size()];
        int i=0;
        for(int num : resultList){
            result[i]=num;
            i++;
        }
        return result;

    }
}
