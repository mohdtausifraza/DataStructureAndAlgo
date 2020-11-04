package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the element which is only in First element [A-B]
 */
public class DifferenceOfTwoArray {

    /**
     * Approach :   Compare each element of Array1 with each element of Array2
     *              If that element is not present in the second array, copy that element in the third array.
     *
     * Time Complexity : theta(m*n) || theta(n^2)
     */
    public static int[] difference(int[] array1, int[] array2){
        List<Integer> arrayList = new ArrayList<>();
        for (int k : array1) {
            for (int i=0 ; i<array2.length ; i++) {
                if (k == array2[i]) {
                    break;
                }
                if (i == array2.length-1){
                    arrayList.add(k);
                }
            }
        }
        return Arrays.toIntArray(arrayList);
    }


    public static void main(String[] args) {
        int[] arr1 = {1,3,5,6,9};
        int[] arr2 = {1,2,3,4,5,6,7,8};
        int[] arr3 = difference(arr1,arr2);
    }
}
