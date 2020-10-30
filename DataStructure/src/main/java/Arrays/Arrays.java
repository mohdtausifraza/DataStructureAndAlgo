package Arrays;

import java.util.List;

public class Arrays {
    static int[] arr;
    static int size;
    // Number of elements
    static int length;
    Arrays(int[] arr , int size){
        this.arr = new int[size];
        this.size = size;
        this.length = arr.length;
        copy(arr, this.arr);
    }
    Arrays(int[] arr , int size, int length){
        this.arr = new int[size];
        this.size = size;
        this.length = length;
        copy(arr, this.arr);
    }
    /**
     * Copy from one array to another array
     * @param fromArray
     * @param toArray
     * @return
     */
    public static void copy(int[] fromArray, int[] toArray){
        if (fromArray.length > toArray.length){
            System.out.println("Destination Array length is smaller than Source Array");
            return;
        }
        for (int i =0 ; i < fromArray.length ; i++){
            toArray[i] = fromArray[i];
        }
    }
    public static void display(){
        for (int i =0 ; i < Arrays.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * Adding or appending value(x) at the end of the array;
     * @param value;
     */
    public static void add(int value){
        if (Arrays.length == Arrays.size){
            System.out.println("Array is full. No new insertion is possible");
            return;
        }
        Arrays.arr[length] = value;
        length++;
    }

    /**
     * Insert the element at the given index
     * @param index
     * @param value
     * Time Complexity : O(n)
     */
    public static void insert(int index , int value){
        if (Arrays.length == Arrays.size){
            System.out.println("Array is full. Cannot insert at given index");
            return;
        }if (index == length){
            arr[index] = value;
            length++;
        }
        int tempIndex;
        for (tempIndex=length ; tempIndex > index ; tempIndex--){
            arr[tempIndex] = arr[tempIndex-1];
        }
        arr[tempIndex] = value;
        length++;
    }

    /**
     * Delete and return the element at the given index
     * @param index
     * @return
     * Time Complexity : O(n)
     */
    public static int delete(int index){
        int deletedElement = -1;
        if (index >=  Arrays.length){
            System.out.println("Array Index Out Of bound : Cannot delete the given index");
        }else if (index == length-1){
            deletedElement = arr[index];
            arr[index] = 0;
            length--;
        }else {
            deletedElement = arr[index];
            for (int i=index+1 ; i < length ; i++){
                arr[i-1] = arr[i];
            }
            length--;
        }
        return  deletedElement;
    }

    /**
     * Search and return the index of the element, if element is not found return -1;
     * Time Complexity : O(n)
     */
    public static int linearSearch(int value){
        for (int i =0 ; i < arr.length ; i++ ){
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }

    /**
     * Improved Linear Search (Using Transposition)
     * Time Complexity : O(n)
     * Approach :   It is a possibility that we can search the same element multiple times
     *              Thus to improve the search we can move the element to one previous index at every search
     * Search and return the index of the element, if element is not found return -1;
     */
    public static int linearSearchWithTransposition(int value){
        for (int i =0 ; i < arr.length ; i++ ){
            if (arr[i] == value){
                if(i != 0) {
                   int temp = arr[i-1];
                   arr[i-1] = arr[i];
                   arr[i] = temp;
                }
                return i;
            }
        }
        return -1;
    }

    /**
     * Improved Linear Search (Move to head)
     * Time Complexity : O(n)
     * Approach :   It is a possibility that we can search the same element multiple times
     *              Thus to improve the search we can move the element to head if found
     * Search and return the index of the element, if element is not found return -1;
     */
    public static int linearSearchWithMoveToHead(int value){
        for (int i =0 ; i < arr.length ; i++ ){
            if (arr[i] == value){
                if(i != 0) {
                    int temp = arr[0];
                    arr[0] = arr[i];
                    arr[i] = temp;
                }
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        Arrays array = new Arrays(arr , 10,6);
        System.out.println("Arrays Length is : "+Arrays.length);
        System.out.println("Arrays Size is : "+Arrays.size);
        Arrays.display();

        Arrays.add(7);
        System.out.println("Arrays Length is : "+Arrays.length);
        System.out.println("Arrays Size is : "+Arrays.size);
        Arrays.display();

        Arrays.insert(4, -1);
        System.out.println("Arrays Length is : "+Arrays.length);
        System.out.println("Arrays Size is : "+Arrays.size);
        Arrays.display();

        System.out.println(Arrays.delete(6));
        System.out.println("Arrays Length is : "+Arrays.length);
        System.out.println("Arrays Size is : "+Arrays.size);
        Arrays.display();

        System.out.println(Arrays.linearSearch(12));

        System.out.println(Arrays.linearSearchWithTransposition(6));
        display();

        System.out.println(Arrays.linearSearchWithMoveToHead(4));
        display();

    }
}
