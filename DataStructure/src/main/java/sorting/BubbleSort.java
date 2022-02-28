package sorting;

import java.util.stream.IntStream;

/**
 * Compares two consecutive Elements and swap
 * 1 pass sort the largest element
 * It is ADAPTIVE(No Sorting if already sorted) and STABLE
 * MAX Complexity = O(n^2) - If list is not Sorted;
 * MIN Complexity = O(n) - If list is already sorted;
 * Max Number of Swap = O(N^2)
 * Working of Bubble Sort
 *
 * K Passes give K no of Largest element at the end of the array
 */
public class BubbleSort {
    /**
     *  COMPLEXITY : O(n^2)
     */
     public void bubbleSort(int[] array){
         int lastUnSortedIndex = array.length-1;
         while (lastUnSortedIndex > 0){
             for (int i=0; i<lastUnSortedIndex;i++){
                 if (array[i] > array[i+1]){
                     int temp = array[i];
                     array[i] = array[i+1];
                     array[i+1] = temp;
                 }
             }
             lastUnSortedIndex--;
         }
     }

    /**
     * Making Bubble Sort as Adaptive by introducing a flag.
     * If the Array is already sorted than it must stop in first pass
     *
     * COMPLEXITY : O(n)
     */
    public void bubbleSortAdaptive(int[] array){
        int lastUnSortedIndex = array.length-1;
        while (lastUnSortedIndex > 0){
            int flag =0;
            for (int i=0; i<lastUnSortedIndex;i++){
                if (array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0){
                System.out.println("List is Sorted");
                return;
            }
            lastUnSortedIndex--;
        }
    }
    public static void main(String[] args) {
        int[] array = {8,5,7,3,2,0};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(array);
        IntStream.range(0,array.length).forEach(i -> System.out.print(array[i]+" "));
        System.out.println();
        bs.bubbleSortAdaptive(array);
        IntStream.range(0,array.length).forEach(i -> System.out.print(array[i]+" "));
    }
}
