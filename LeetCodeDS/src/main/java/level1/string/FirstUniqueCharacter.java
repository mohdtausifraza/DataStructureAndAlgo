package level1.string;

import java.util.HashMap;
import java.util.Map;

/**
 * First Unique Character in a String
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
 *
 * Given a string, find the first non-repeating character in it and return its index.
 * If it doesn't exist, return -1.
 *     s = "leetcode"
 *     return 0.
 *
 *     s = "loveleetcode"
 *     return 2.
 */
public class FirstUniqueCharacter {
    /**
     *  Approach :  Take a HashMap to keep the frequency of the character.
     */
    public int firstUniqChar(String s) {
        int i=0,n=s.length();
        Map<Character,Integer> map = new HashMap();
        for(i=0 ; i< n ; i++){
            char c = s.charAt(i);
            map.put(c , map.getOrDefault(c,0)+1);
        }
        for(i=0 ; i< n ; i++)
        {
            if( map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
