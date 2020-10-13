package level1.string;

/**
 * Reverse String
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
 *     Input: ["h","e","l","l","o"]
 *     Output: ["o","l","l","e","h"]
 */
public class ReverseString {
    /**
     * Approach :   Take two pointer approach one at start and another at end.
     *              Compare element at end with element at start index till start<end
     */
    public void reverseString(char[] s) {
        int start=0,end=s.length-1;
        char temp;
        while(start < end){
            temp=s[start];
            s[start++]=s[end];
            s[end--]=temp;
        }
    }
}
