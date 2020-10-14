package level1.string;

/**
 * String to Integer (atoi)
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/884/ *
 * *******************************************************************************************
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 *
 * Input: "42"
 * Output: 42
 *
 * Input: "   -42"
 * Output: -42
 *
 * Input: "4193 with words"
 * Output: 4193
 *
 * Input: "words and 987"
 * Output: 0
 *
 * Input: "-91283472332"
 * Output: -2147483648
 */

public class StringToInteger_atoi {
    /**
     * Approach :  Remove trailing white Spaces by moving pointer.
     *             Check if pointer is pointing to + or -, if yes update flag accordingly 1 or -1;
     *             Traverse till you get digits and check if the num will be underflow or overflown
     */
    public int myAtoi(String str) {
        int n=str.length();
        if(n == 0){
            return 0;
        }
        char[] arr = str.toCharArray();
        int i=0,flag=1;
        int num=0;
        while( (i < n) && (arr[i] == ' ') ){
            i++;
        }
        if((i < n) && (arr[i]== '-' || arr[i]== '+')){
            flag = (arr[i] == '-') ? -1 : 1 ;
            i++;
        }
        while((i < n) && (arr[i] >= '0' && arr[i] <= '9') ){
            if (num > Integer.MAX_VALUE/10){
                return (flag == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            else if(num == Integer.MAX_VALUE/10){
                if(flag==1 && arr[i]-'0' >= Integer.MAX_VALUE%10)
                    return Integer.MAX_VALUE;
                else if(flag==-1 && arr[i]-'0' > Integer.MAX_VALUE%10)
                    return Integer.MIN_VALUE;
            }
            num = (num*10)+(arr[i++]-'0');
        }
        return num*flag;
    }
}
