package Arrays;

public class Sum {

    /**
     * Find pair such that a+b=k in an UnSorted Array
     * Use HashTable/ BitSet
     *
     * Time Complexity : O(n)
     */
    public static void pairSumInUnSortedArray(int[] array,int sum){
        int low=Integer.MAX_VALUE,high=Integer.MIN_VALUE;
        for (int a : array){
            if (a < low){
                low = a;
            }else if (a > high){
                high = a;
            }
        }
        int[] hashTable = new int[high+1];
        for (int a : array){
            hashTable[a]++;
        }
        for (int i=0 ; i < array.length ; i++ ){
            if (sum-array[i] > 0 && hashTable[sum-array[i]] != 0){
                System.out.println("("+array[i]+","+(sum-array[i])+")");
                hashTable[sum-array[i]]--;
                hashTable[array[i]]--;
            }
        }
    }

    /**
     * Find pair such that a+b=k in an UnSorted Array
     * Approach :   Take two pointer one i at start and another j at end
     *              Compare the sum of both the pointer
     *              if sum is greater j--
     *              if sum is smaller i++
     *              if sum is equal print the sum.
     *
     * Time Complexity : O(n)
     */
    public static void pairSumInSortedArray(int[] array,int sum){
        int i=0,j=array.length-1;
        while (i < j){
            if (array[i]+array[j] == sum){
                System.out.println("("+array[i]+","+array[j]+")");
                i++;
                j++;
            }else if (array[i]+array[j] > sum){
                j--;
            }else {
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,4,12,7,2,11,5,9,6,3,8,10};

        System.out.println("Pair with equal sum in an UnsortedArray");
        pairSumInUnSortedArray(arr,10);

        int[] arr1 = {1,3,4,5,6,7,8,9,10,12,14};
        System.out.println("Pair with equal sum in a SortedArray");
        pairSumInSortedArray(arr1,10);
    }
}
