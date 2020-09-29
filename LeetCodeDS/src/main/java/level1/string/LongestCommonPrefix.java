/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 *  Input: ["flower","flow","flight"]
 *  Output: "fl"
 *
 *  Input: ["dog","racecar","car"]
 *  Output: ""
 *  Explanation: There is no common prefix among the input strings.
 *
 * Approach :   Get the length of smallest string (smallestLen)
 *              Take the String at 0th location and get char one by one till smallestLen index.
 *              and compare its char with all the other String of the array
 */


package level1.string;
class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        int smallestStringLength=strs[0].length(),i;
        for(i=0 ; i< strs.length ; i++){
            if(strs[i].length() < smallestStringLength){
                smallestStringLength = strs[i].length();
            }
            if(smallestStringLength == 0){
                return "";
            }
        }
        StringBuilder sb= new StringBuilder();
        int j=0;
        while(j < smallestStringLength){
            char temp = strs[0].charAt(j);
            i=1;
            while(i < strs.length){
                if(temp != strs[i].charAt(j)){
                    return sb.toString();
                }
                i++;
            }
            sb.append(temp);
            j++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[] {"bat","boll","cat"}));
    }
}
