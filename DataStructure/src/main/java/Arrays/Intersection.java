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

    /**
     * Approach :   Compare element of Array1 with element of Array2
     *              if same then copy the element in newArray and move both the pointer
     *              else move the pointer of the smallest element array
     *
     * Time Complexity : theta(m+n) || theta(2n) || theta(n)
     */
    public static int[] intersectionOfSorted(int[] array1, int[] array2){
        List<Integer> arrayList = new ArrayList<>();
        int i=0,j=0;
        while (i < array1.length && j < array2.length){
            if (array1[i] == array2[j]){
                arrayList.add(array1[i++]);
                j++;
            }else if(array1[i] < array2[j]){
                i++;
            }else {
                j++;
            }
        }
        return Arrays.toIntArray(arrayList);
    }
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,6,9};
        int[] arr2 = {1,2,3,4,5,6,7,8};
        int[] arr3 = intersection(arr1,arr2);
        int[] arr4 = intersectionOfSorted(arr1,arr2);
        for (int j : arr3) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int j : arr4) {
            System.out.print(j + " ");
        }
    }
}
