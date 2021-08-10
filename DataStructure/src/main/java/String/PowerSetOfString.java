package String;

/**
 * Link : https://www.youtube.com/watch?v=mEBEw_xScsE
 * INPUT    : ABC
 * POWERSET : "", A, B, C, AB, AC, BC, ABC
 *
 *  Approach : There are two things we can do with each char.
 *              1. Select the char and append to string
 *              2. Don't Select the String
 *
 *                          ABC
 *                       A        ""            Selecting A - Not Selecting A
 *                   AB      A
 *                ABC   AB AC   A
 */
public class PowerSetOfString {

    public static void powerSet(String input,int i,String currentSet){
        if (i == input.length()){
            System.out.println(currentSet);
            return;
        }
        powerSet(input, i+1, currentSet+input.charAt(i));
        powerSet(input, i+1, currentSet);
    }
    public static void main(String[] args) {
        String input = "ABC";
        powerSet(input,0,"");
    }
}
