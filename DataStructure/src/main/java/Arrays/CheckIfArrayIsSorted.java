package Arrays;

public class CheckIfArrayIsSorted {
    /**
     * Approach :   Check current number with the next number
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     */
    public static boolean isSortedArray(int[] array){
        for (int i=0 ; i < array.length-1 ; i++){
            if (array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,8,9};
        System.out.println(isSortedArray(arr));
    }
}
