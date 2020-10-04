package level1.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * There are many data structures commonly used as dynamic sets such as Binary Search Tree and Hash Table.
 * The operations we need to support here are search() and insert().
 * For a self-balancing Binary Search Tree (TreeSet or TreeMap in Java), search() and insert() are both O(\log n)O(logn) time.
 * or a Hash Table (HashSet or HashMap in Java), search() and insert() are both O(1)O(1) on average.
 * Therefore, by using hash table, we can achieve linear time complexity for finding the duplicate in an unsorted array.
 *
 *  Approach : Check into HashSet if found return true else add into sets
 *
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2)
            return true;
        Set<Integer> set = new HashSet<Integer>();
        for(int x : nums){
            if(set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }

    /**
     * Approach-2 : Sort the Array and compare arr[i] with arr[i+1]
     *
     * Time complexity : O(n \log n)O(nlogn). Sorting is O(n \log n)O(nlogn) and the sweeping is O(n)O(n).
     * The entire algorithm is dominated by the sorting step, which is O(n \log n)O(nlogn).
     * Space complexity : O(1)O(1). Space depends on the sorting implementation which, usually, costs O(1)O(1) auxiliary space if heapsort is used.
     *
     * */

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i=0, j=1; j <nums.length ; i++ , j++){
            if(nums[i] == nums[j]) return true;
        }
        return false;
    }
}
