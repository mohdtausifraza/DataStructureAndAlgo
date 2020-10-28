package Arrays;
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


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        Arrays array = new Arrays(arr , 10,6);
        System.out.println("Arrays Length is : "+Arrays.length);
        System.out.println("Arrays Size is : "+Arrays.size);
        Arrays.display();
    }
}