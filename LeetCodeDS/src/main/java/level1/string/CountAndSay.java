/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/886/
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 *  1.     1
 *  2.     11
 *  3.     21
 *  4.     1211
 *  5.     111221
 *
 *  1 is read off as "one 1" or 11.
 *   11 is read off as "two 1s" or 21.
 *   21 is read off as "one 2, then one 1" or 1211.
 *
 * Approach :   Take A string result="1" .
 *              Traverse in that string n times and form the number.
 *
 */


package level1.string;
class CountAndSay {
    public static String countAndSay(int n) {
        if(n==0){
            return null;
        }
        String result = "1";
        int i = 1;
        while(i < n){
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for(int j=1 ; j<result.length() ; j++){
                if(result.charAt(j) == result.charAt(j-1)){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(result.charAt(j-1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(result.charAt(result.length()-1));
            result = sb.toString();
            i++;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
}
