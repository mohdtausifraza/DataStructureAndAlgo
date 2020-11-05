package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MissingElements {
    /**
     *  Find a missing element in a Sorted Array,
     *  Here element is first n Natural Number
     *  Approach : Return sum - n(n+1)/2
     *
     *  Time Complexity : O(n)
     */
    public static int missingElement(int[] array, int n){
        int sum = 0;
        for (int a : array){
            sum += a;
        }
        // Calculate the sum using the formula of first n natural number
        int s = n*(n+1)/2;
        return s-sum;
    }
    /**
     *  Find a missing element in a Sorted Array,
     *  Here element can start from any number like
     *  arr = {101,102,103,104,105,106,108,109,110,111,112}
     *  Approach :  If diff of element and index is not equal to the first element
     *              then number will be first element + index where it does not differ.
     *
     *  Time Complexity : O(n)
     */
    public static int missingElement(int[] array){
        int missingElement=-1;
        for (int i=0 ; i < array.length ; i++){
            if (array[i]-i != array[0]){
                missingElement = array[0]+i;
                break;
            }
        }
        return missingElement;
    }

    /**
     *  Find more than one missing element in an Un-Sorted Array,
     *  arr = {8,3,5,7,2,4,1,11,12}
     *  Approach :  Use HashTable / BitSet
     *              Create a array (HashTable) of size = max element of the array with all bits to 0.
     *              Set the bit of HashTable for the index equal to the element of the unsorted array.
     *              Traverse in HashTable and add the index to missing number list where where value is 0.
     *
     *  Time Complexity : O(n)
     */
    public static List<Integer> missingElementInUnSortedArray(int[] array){
        int low=Integer.MAX_VALUE,high=Integer.MIN_VALUE;
        List<Integer> missingElement = new ArrayList<>();
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
        for (int i=low; i< high ; i++){
            if (hashTable[i] == 0){
                missingElement.add(i);
            }
        }
        return missingElement;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,7,8,9};
        System.out.println(missingElement(arr,9));

        int[] arr1 = {101,102,103,104,105,106,108,109,110,111,112};
        System.out.println(missingElement(arr1));

        int[] arr3 = {8,3,5,7,2,4,1,11,12};
        List<Integer> missingList2 = missingElementInUnSortedArray(arr3);
        for (int a : missingList2){
            System.out.print(a+" ");
        }
    }
}
