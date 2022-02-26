package Heap;

import java.util.stream.IntStream;

/**
 * HEAP is a COMPLETE BINARY TREE (If it is represented in an array, then there is no blank space in the array)
 * MAX HEAP : Every Node is having element GREATER than or EQUAL to all its DESCENDANTS
 * MIN HEAP : Every Node is having element SMALLER than or EQUAL to all its DESCENDANTS
 *
 * HEAP can have DUPLICATE  elements.
 *
 * HEAPS are mostly represented as ARRAY.
 * NOTE : Array Index Starts from 1
 * NODE         = i
 * PARENT       = floor(i/2)
 * LEFT CHILD   = 2*i
 * RIGHT CHILD  = (2*i)+1
 *
 * HEIGHT = (logn)
 */
public class BinaryHeap {
    private int heapSize;
    private int[] array;

    /**
     * Add the element to end of the Array.
     * Traverse from end of the array
     * Compare element at end with its parent
     * If newly added element is greater than its parent swap.
     *
     * Complexity (logn)
     */
    public void insert(int[] array, int valueToInsert){
        this.heapSize=heapSize+1;
        array[heapSize] = valueToInsert;
        for (int i=heapSize ; i>1 ; i=i/2){
            if (array[i] > array[i/2]){
                this.array = swap(array,i,i/2);
            }else {
                break;
            }
        }
    }


    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.array =new int[9];
        binaryHeap.array[0] = Integer.MIN_VALUE; binaryHeap.array[1] = 50;
        binaryHeap.array[2] = 30; binaryHeap.array[3] = 40; binaryHeap.array[4] = 10;
        binaryHeap.array[5] = 5;  binaryHeap.array[6] = 35; binaryHeap.array[7] = 30;
        binaryHeap.heapSize=7;
        int[] finalArray = binaryHeap.array;
        IntStream.range(1, binaryHeap.heapSize+1).forEach(i -> System.out.print(finalArray[i]+" "));
        binaryHeap.insert(binaryHeap.array, 40);
    }
}
