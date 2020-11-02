package Arrays;

/**
 * Having only one copy of each element in the new array
 */
public class Union {
    /**
     * Approach :   Copy First Array to new Array.
     *              Check if Array2 element is not in newArray copy the element.
     * Time Complexity : theta(m*n) || theta(n^2)
     */
    public static int[] union(int[] array1, int[] array2){
        int[] newArray = new int[array1.length+array2.length];
        int i=0;
        while(i < array1.length){
            newArray[i] = array1[i];
            i++;
        }
        for (int j=0 ; j < array2.length ; j++){
            for (int k=0 ; k < i ; k++){
                if (newArray[k] == array2[j]){
                    break;
                }else if (k == i-1){
                    newArray[i++] = array2[j];
                }
            }
        }
        return newArray;
    }
    /**
     * Approach :   Copy smallest of A1 and A2 to new array and increment the pointer
     *              If element at both the array is same copy one element to new array and increment both i and j
     *
     * Time Complexity : theta(m+n) || theta(2n) || theta(n)
     */
    public static int[] unionOfSorted(int[] array1, int[] array2){
        int[] newArray = new int[array1.length+array2.length];
        int i=0,j=0,k=0;
        while (i < array1.length && j < array2.length){
            if (array1[i] < array2[j]){
                newArray[k++] = array1[i++];
            }else if (array2[j] < array1[i]){
                newArray[k++] = array2[j++];
            } else if (array1[i] == array2[j]) {
                newArray[k++] = array1[i++];
                j++;
            }
        }
        while (i < array1.length){
            newArray[k++] = array1[i++];
        }
        while (j < array2.length){
            newArray[k++] = array2[j++];
        }
        return newArray;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,6,9};
        int[] arr2 = {1,2,3,4,5,6,7,8};
        int[] arr3 = unionOfSorted(arr1,arr2);
        for (int j : arr3) {
            System.out.print(j + " ");
        }
    }
}
