package level1.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Valid Anagram
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/ *
 * *******************************************************************************************
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 *     Input: s = "anagram", t = "nagaram"
 *     Output: true
 */
public class ValidAnagram {
    /**
     * Approach :  Increment frequency of char in map for first array and decrement for second array.
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        Map<Character, Integer> map = new HashMap();
        for(int i=0 ; i< s.length() ; i++){
            map.put(first[i],map.getOrDefault(first[i],0)+1);
            map.put(second[i],map.getOrDefault(second[i],0)-1);
        }
        for(Map.Entry entry : map.entrySet()){
            if((int)entry.getValue() < 0 ){
                return false;
            }
        }
        return true;
    }
}
