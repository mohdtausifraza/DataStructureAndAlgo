package Arrays;

public class Reverse {
    /**
     * Reverse by taking an extra memory
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     */
    public static void reverse(int[] arr){
        int temp;
        for (int i=0 ,j= arr.length-1; i<j ; i++,j--){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        reverse(arr);
        for (int i=0 ; i < arr.length; i++ ){
            System.out.print(arr[i]+" ");
        }
    }
}
