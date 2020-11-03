package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Intersection {
    /**
     * Approach :   Compare each element of Array1 with each element of Array2
     *              If that element is present in both the array, copy that element in the third array.
     *
     * Time Complexity : theta(m*n) || theta(n^2)
     */
    public static int[] intersection(int[] array1, int[] array2){
        List<Integer> arrayList = new ArrayList<>();
        for (int k : array1) {
            for (int i : array2) {
                if (k == i) {
                    arrayList.add(k);
                    break;
                }
            }
        }
        return Arrays.toIntArray(arrayList);
    }


    public static void main(String[] args) {
        int[] arr1 = {1,3,5,6,9};
        int[] arr2 = {1,2,3,4,5,6,7,8};
        int[] arr3 = intersection(arr1,arr2);
    }
}
