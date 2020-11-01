package Arrays;

public class InsertInSortedArray {
    // Here i have taken length-2 because arr is having last element
    // as 0 so that we can shift and insert.
    /**
     *  Approach :  Start from the end of the array,
     *              check if data < element at i then shift the element to the right (i+1).
     *              Else insert the element at i+1.
     *  Time Complexity : O(n)
     *  Space Complexity: O(1)
     */
    public static void insertInSortedArray(int[] arr , int data){
        for (int i=arr.length-2 ; i >= 0 ; i--){
            if (data < arr[i]){
                arr[i+1]=arr[i];
            }else {
                arr[i+1] = data;
                return;
            }
        }
        arr[0] = data;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,8,9,0};
        insertInSortedArray(arr,0);
        for (int i=0 ; i < arr.length; i++ ){
            System.out.print(arr[i]+" ");
        }
    }
}
