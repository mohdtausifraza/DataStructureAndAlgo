package Recursion;

public class isSorted {
    public static boolean isSortedArray(int[] array, int i){
        if (array.length ==1)
            return true;
        if (i==array.length || array[i] < array[i-1])
            return false;
        return isSortedArray(array,i+1);
    }
    public static void main(String[] args) {
        int[] array= new int[]{1,3,5,7,0};
        System.out.println(isSortedArray(array,1));
    }
}


