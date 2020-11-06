package Arrays;

import java.util.*;

public class FindDuplicatesInAnArray {

    /**
     *  Find all the duplicates elements in a Sorted Array
     *  Approach : Compare A[i] with A[i+1].
     *
     *  Time Complexity : O(n)
     */
    public static List<Integer> getDuplicates(int[] array){
        List<Integer> duplicates = new ArrayList<>();
        if (array.length <= 1){
            return duplicates;
        }
        int lastDuplicate=0;
        for (int i=0 ; i < array.length-1 ; i++ ){
            if (array[i] == array[i+1] && array[i] != lastDuplicate){
                duplicates.add(array[i]);
                lastDuplicate = array[i];
            }
        }
        return duplicates;
    }

    /**
     *  Find duplicates elements frequency in a Sorted Array
     *  Approach :  Compare A[i] with A[i+1].
     *              If same then move the pointer j till both are equal and increment freq.
     *              Insert a[i] and frequency in the map.
     *              Update i = j-1
     *
     *  Time Complexity : O(n)
     */
    public static Map<Integer,Integer> getDuplicatesFrequency(int[] array){
        Map<Integer,Integer> duplicates = new HashMap<>();
        if (array.length <= 1){
            return duplicates;
        }
        for (int i=0 ; i < array.length-1 ; i++ ){
            if (array[i] == array[i+1]){
                int j = i+1,freq=1;
                while (j < array.length && array[i] == array[j]){
                    freq++;
                    j++;
                }
                duplicates.put(array[i],freq);
                i=j-1;
            }
        }
        return duplicates;
    }

    /**
     *  Find duplicates elements frequency in a Sorted Array
     *  Approach :  Create a BitSet HashTable with the frequency
     *
     *  Time Complexity : O(n)
     */
    public static Map<Integer,Integer> getDuplicatesFrequencyUsingHashTable(int[] array){
        int low=Integer.MAX_VALUE,high=Integer.MIN_VALUE;
        Map<Integer,Integer> duplicateFreq = new HashMap<>();
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
            if (hashTable[i] > 1){
                duplicateFreq.put(i,hashTable[i]);
            }
        }
        return duplicateFreq;
    }

    /**
     *  Find duplicates elements frequency in a Sorted Array
     *  Approach :  Create a BitSet HashTable with the frequency
     *
     *  Time Complexity : O(n)
     */
    public static Map<Integer,Integer> getDuplicatesInUnsortedArray(int[] array){
        int low=Integer.MAX_VALUE,high=Integer.MIN_VALUE;
        Map<Integer,Integer> duplicateFreq = new HashMap<>();
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
            if (hashTable[i] > 1){
                duplicateFreq.put(i,hashTable[i]);
            }
        }
        return duplicateFreq;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,7,7,8,9,9,9,9,10,11};
        List<Integer> duplicates = getDuplicates(arr);
        for (int a : duplicates){
            System.out.print(a+" ");
        }
        System.out.println();

        int[] arr1 = {2,3,4,5,7,7,8,9,9,9,9,10,10,10,11};
        Map<Integer,Integer> frequency = getDuplicatesFrequency(arr1);
        Set<Map.Entry<Integer,Integer>> entrySet = frequency.entrySet();
        for (Map.Entry<Integer,Integer> s : entrySet){
            System.out.print(s+" ");
        }
        System.out.println();

        int[] arr2 = {2,3,4,5,7,7,8,9,9,9,9,10,10,10,11};
        Map<Integer,Integer> frequency2 = getDuplicatesFrequencyUsingHashTable(arr2);
        Set<Map.Entry<Integer,Integer>> entrySet2 = frequency2.entrySet();
        for (Map.Entry<Integer,Integer> s : entrySet2){
            System.out.print(s+" ");
        }
        System.out.println();

        int[] arr3 = {1,4,7,4,2,2,2,5,6,8,2,1,4,5,5,6,10};
        Map<Integer,Integer> frequency3 = getDuplicatesInUnsortedArray(arr3);
        Set<Map.Entry<Integer,Integer>> entrySet3 = frequency3.entrySet();
        for (Map.Entry<Integer,Integer> s : entrySet3){
            System.out.print(s+" ");
        }
    }
}
