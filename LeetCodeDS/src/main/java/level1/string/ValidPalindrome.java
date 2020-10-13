package level1.string;

/**
 * Valid Palindrome
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/ *
 * *******************************************************************************************
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 *     Input: "A man, a plan, a canal: Panama"
 *     Output: true
 */
public class ValidPalindrome {
    /**
     * Approach  :  Convert the string to charArray and toLowerCase
     *              Take two pointer in either direction.
     *              Compare if both the char isLetterOrDigit. If not move the pointer from that char.
     */
    public boolean isPalindrome(String s) {
        if(s.length() == 0)
            return true;

        char arr[]=s.toLowerCase().toCharArray();

        int start=0,end=arr.length-1;
        char startChar,endChar;

        while(start < end){
            startChar=arr[start];
            endChar=arr[end];
            if(!Character.isLetterOrDigit(startChar)){
                start++;
                continue;
            }else if(!Character.isLetterOrDigit(endChar)){
                end--;
                continue;
            }else if(startChar != endChar){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
