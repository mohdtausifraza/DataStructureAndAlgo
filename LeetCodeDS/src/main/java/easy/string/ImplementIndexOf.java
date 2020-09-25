/*
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/
 *
 * Approach :   Traverse in haystack till you find the first element of needle .
 *              Traverse in needle and compare each element with haystack.
 *              If doesn't match break the inner loop.
 *              At the end of inner loop check if index is pointing to last element of needle return the index of haystack where first element matched
 */


package easy.string;
public class ImplementIndexOf {
    public static int indexOf(String haystack, String needle) {
        int len1=haystack.length(),len2=needle.length();
        if(len2==0 || haystack.equals(needle)){
            return 0;
        }if(haystack == null  || needle == null || len1 < len2){
            return -1;
        }
        int i,j;
        for(i=0 ; i< len1-len2 +1 ; i++){
            j=0;
            if(haystack.charAt(i) == needle.charAt(j)){
                for(j=1 ; j<len2 ; j++){
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        break;
                    }
                }
            }
            if(j==len2){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(indexOf("hello","ll"));
    }
}
