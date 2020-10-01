/**
 * The Array should be sorted, then only we can perform Binary Search.
 *  This can be solved by DIVIDE AND CONQUER Strategies.
 *
 */

public class BinarySearch {
    /**
     * Take low=arr[0] and high=arr[n-1]
     * Iterate the array till low < high and calculate mid = (low+high)/2
     * Compare arr[mid] with the key
     *      if yes return mid
     *      else if key < arr[mid] then , update high=mid-1
     *      else if key > arr[mid] then , update low=mid+1
     */
    public static int binarySearchIterative(int[] arr, int n,int key){
        int low=0,high=n-1,mid;
        while(low <= high){
            mid = (low + high)/2;
            if (arr[mid] == key){
                return  mid;
            }else if(key < arr[mid]){
                high = mid - 1;
            }else if(key > arr[mid]){
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,8,12,14,17,25,29,31,36,42,47,53,55,62,65};
        System.out.println(binarySearchIterative(arr,16,31));
    }
}
