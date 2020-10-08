package level1.Array;
/**
 * Rotate Array   *
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Time Complexity : 0 (n) Space Complexity : 0(1) No extra space required.
 *     Input: nums = [1,2,3,4,5,6,7], k = 3
 *     Output: [5,6,7,1,2,3,4]
 *     Explanation:
 *     rotate 1 steps to the right: [7,1,2,3,4,5,6]
 *     rotate 2 steps to the right: [6,7,1,2,3,4,5]
 *     rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 *     Approach : Reverse Complete Array, Then Reverse from 0 K-1 , and the reverse k to n-1
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
