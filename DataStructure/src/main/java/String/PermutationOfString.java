package String;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {
    /**
     * Permutation of String using Backtracking
     * Time Complexity : O(n^2)
     */
    static List<String> permList = new ArrayList<>();
    public static List<String> permutation(String input , int start , int end){
        if (start == end){
            permList.add(input);
        }else {
            for (int i = start ; i <= end ; i++){
                input = swap(input , start , i );
                permutation(input , start+1 , end );
                input = swap(input , start , i );
            }
        }
        return permList;
    }
    public static String swap(String s , int index1, int index2){
        char[] tempArray = s.toCharArray();
        char temp = tempArray[index1];
        tempArray[index1] = tempArray[index2];
        tempArray[index2] = temp;
        return  String.valueOf(tempArray);
    }
    public static void main(String[] args) {
        String s1 = "AAA";
        List<String> permList = permutation(s1, 0 , s1.length()-1);
        System.out.println(permList);
    }
}
