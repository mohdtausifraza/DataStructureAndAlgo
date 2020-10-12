package level1.string;

/**
 * Reverse Integer
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
 * Given a 32-bit signed integer, reverse digits of an integer.
 *     Input: -123
 *     Output: -321
 *     Input: 120
 *     Output: 21
 */
public class ReverseInteger {
    /**
     * Approach :  Take a flag to check whether number is positive or negative
     *             Make Number positive and reverse the Integer in long
     *             Make reversed number positive or negative based on flag.
     *             Check that reverse number lies between Integer.MAX_VALUE < reverse > Integer.MIN_VALUE
     *             if yes return 0
     *             else convert long to int and return
     */
    public int reverse(int x) {
        long reverse=0;
        int flag=0;
        if(x < 0){
            flag=1;
            x *= -1;
        }
        while(x != 0){
            reverse = reverse*10+(x%10);
            x /= 10;
        }
        if(flag == 1){
            reverse *= -1;
        }
        if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE){
            return 0;
        }
        else {
            return (int)reverse;
        }
    }
}
