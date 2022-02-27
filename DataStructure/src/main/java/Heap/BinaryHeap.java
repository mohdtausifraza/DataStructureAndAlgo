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

    /**
     * Delete the Root Node.
     * Place last element of the array to the root.
     * Compare root with the greatest of its child, and swap if root is smaller;
     *
     * Complexity (logn)
     */
    public int delete(){
        if (heapSize == 0){
            System.out.println("No Element in the heap");
            return Integer.MIN_VALUE;
        }
        int i=1,j=i*2;
        int temp = array[i];
        array[i] = array[heapSize];
        array[heapSize] =temp;
        heapSize=heapSize-1;
        while (j<=heapSize){
            int left = array[j];
            int right = (j+1 <= heapSize) ? array[j+1] : 0;

            int largerIndex = (left>right) ? j : j+1 ;
            if (array[i] < array[largerIndex]){
                swap(array , i , largerIndex);
                i=largerIndex;
                j=largerIndex*2;
            }else {
                break;
            }
        }
        return temp;
    }

    /**
     * HEAPIFY : Procedure of creating heap from given element.
     * Get the Number of Leaf Node = floor(totalNoOfNodes/2)
     * Compare NON-LEAF nodes with its child and swap
     * COMPLEXITY : O(n)
     *
     * HINTS : If index starts from 0
     * Parent = i
     * lChild = (i*2)+1
     * rchild = (i*2)+2
     * parent = (i-1)/2
     * Non Leaf Node = (array.lenght/2)-1
     */
    public void heapify(int[] array){
        int noOfNonLeafNodes = (array.length/2)-1;
        for (int i=noOfNonLeafNodes ; i>=0 ; i--){
            int parentIndex=i;
            while ((parentIndex*2)+1 < array.length){
                int leftChildIndex = (parentIndex*2)+1;
                int rightChildIndex = (parentIndex*2)+2;
                int leftChild = array[leftChildIndex];
                int rightChild = rightChildIndex < array.length ? array[rightChildIndex] : 0 ;
                int largestIndex = leftChild > rightChild ? leftChildIndex :rightChildIndex;
                if (array[parentIndex] < array[largestIndex]){
                    swap(array,parentIndex,largestIndex);
                    parentIndex = largestIndex;
                }else {
                    break;
                }
            }
        }
    }

    /**
     * Heapify Recursively
     *
     */
    public void createHeap(int[] array){
        // Last leaf node is the parent of last element.
        int lastNonLeafNodeIndex = (array.length/2)-1;
        for (int i= lastNonLeafNodeIndex ; i>=0 ; i--){
            heapifyRecursive(array,i);
        }
    }
    public void heapifyRecursive(int[] array, int parent){
        int largest = parent;
        int leftChildIndex = (largest*2)+1;
        int rightChildIndex = (largest*2)+2;
        if (leftChildIndex < array.length && array[largest] < array[leftChildIndex]){
            largest = leftChildIndex;
        }
        if(rightChildIndex < array.length && array[largest] < array[rightChildIndex]){
            largest = rightChildIndex;
        }
        if (largest != parent){
            swap(array, parent, largest);
            heapifyRecursive(array,largest);
        }
    }

    private int[] swap(int[] array , int fromIndex, int toIndex){
        int temp = array[fromIndex];
        array[fromIndex] = array[toIndex];
        array[toIndex] = temp;
        return array;
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
        System.out.println("Deleted value is : "+binaryHeap.delete());
        System.out.println("Deleted value is : "+binaryHeap.delete());
        System.out.println("Deleted value is : "+binaryHeap.delete());
        System.out.println("Deleted value is : "+binaryHeap.delete());
        System.out.println("Deleted value is : "+binaryHeap.delete());
        System.out.println("Deleted value is : "+binaryHeap.delete());
        System.out.println("Deleted value is : "+binaryHeap.delete());
        System.out.println("Deleted value is : "+binaryHeap.delete());
        System.out.println("Deleted value is  : "+binaryHeap.delete());

        System.out.print("Printing Sorted Heap:");
        for (int i=1; i< binaryHeap.array.length;i++){
            System.out.print(binaryHeap.array[i]+" ");
        }
        System.out.println();

        int[] heapifyArray = new int[]{1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        binaryHeap.heapify(heapifyArray);

        System.out.println("Printing Heapify Array");
        for (int data : heapifyArray){
            System.out.print(data+" ");
        }

        int[] heapifyArray1 = new int[]{1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        binaryHeap.createHeap(heapifyArray1);

        System.out.println("Printing Heapify Recursive Array");
        for (int data : heapifyArray1){
            System.out.print(data+" ");
        }
    }
}
