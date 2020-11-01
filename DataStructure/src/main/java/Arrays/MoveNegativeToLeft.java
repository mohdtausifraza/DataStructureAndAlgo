package Arrays;

public class MoveNegativeToLeft {
    /**
     * Approach :   Take two pointer, i for positive and j for negative.
     *              Start i from 0 and j from length-1
     *              increment i or j and continue if i is pointing to negative or j is pointing to positive.
     *              else swap element at i with element at j.
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     */
    public static void moveNegativeToLeft(int[] array){
        int i=0,j=array.length-1,temp;
        while(i != j){
            if (array[i] < 0){
                i++;
                continue;
            }else if(array[j] >= 0){
                j--;
                continue;
            }else {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-6,3,-1,1,4,5,-2,-1,1,2};
        moveNegativeToLeft(arr);
        for (int i=0 ; i < arr.length; i++ ){
            System.out.print(arr[i]+" ");
        }
    }
}
