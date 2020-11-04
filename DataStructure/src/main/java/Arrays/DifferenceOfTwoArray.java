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

    /**
     * Approach :   Compare element of Array1 with element of Array2
     *              If Array1 > Array2 element, then increment Array2 pointer.
     *              If Array1 < Array2 element, then copy the element of Array1 in new array and increment Array1 pointer.
     *              If Array1 == Array2 element, then increment both array pointer.
     *
     * Time Complexity : theta(m+n) || theta(2n) || theta(n)
     */
    public static int[] differenceOfSorted(int[] array1, int[] array2){
        List<Integer> arrayList = new ArrayList<>();
        int i=0,j=0;
        while (i<array1.length && j<array2.length){
            if (array1[i] > array2[j]){
                j++;
            }else if (array1[i] < array2[j]){
                arrayList.add(array1[i++]);
            }else if (array1[i] == array2[j]){
                i++;
                j++;
            }
        }
        while ( i<array1.length ){
            arrayList.add(array1[i++]);
        }
        return Arrays.toIntArray(arrayList);
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,6,9};
        int[] arr2 = {1,2,3,4,5,6,7,8};
        int[] arr3 = difference(arr1,arr2);
        int[] arr4 = differenceOfSorted(arr1,arr2);
        for (int j : arr3) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int j : arr4) {
            System.out.print(j + " ");
        }
    }
}
