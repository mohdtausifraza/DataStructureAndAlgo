package Arrays;

public class Merge {
    /**
     * Note :   We can merge two array only if they are sorted.
     *          Else we can perform operations like append, concat, compare and copy
     * Approach :   Compare A1 element with A2 element and copy the smallest
     *              Among them to the third array and move the pointer to next element of that array
     * Time Complexity : theta(m+n)
     * Space Complexity: theta(m+n)
     */

    public static int[] merge(int[] array1, int[] array2){
        int[] newArray = new int[array1.length+array2.length];
        int i=0,j=0,k=0;
        while (i < array1.length && j < array2.length){
            if (array1[i] < array2[j]){
                newArray[k++] = array1[i++];
            }else {
                newArray[k++] = array2[j++];
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
        int[] arr2 = {2,3,4,6,8,9};
        int[] arr3 = merge(arr1,arr2);
        for (int j : arr3) {
            System.out.print(j + " ");
        }
    }
}
