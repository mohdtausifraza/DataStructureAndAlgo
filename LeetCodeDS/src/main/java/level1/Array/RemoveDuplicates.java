package level1.Array;

/**
 * Remove Duplicates from Sorted Array
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/
 *
 * Approach : Take two pointer left and right and move;
            if(arr[left] != arr[right]){
                nums[++left] = nums[right]
            }
*/
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if(nums.length < 2)
            return nums.length;
        int len=0;
        int i=1;
        while(i < nums.length){
            if(nums[len] != nums[i]){
                ++len;
                nums[len]=nums[i];
            }
            i++;
        }
        return len+1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 3, 4}));
    }
}
