package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyString {
    public static int length(String s){
        int count = 0;
        char[] array = s.toCharArray();
        for (char c : array){
            count++;
        }
        return count;
    }

    public static String toLower(String s){
        char[] array = s.toCharArray();
        for (int i =0 ; i < array.length ; i++){
            int c = array[i];
            if (c>=65 && c<=90){
                array[i] = (char)(array[i]+32);
            }
        }
        return new String(array);
    }

    public static String toUpper(String s){
        char[] array = s.toCharArray();
        for (int i =0 ; i < array.length ; i++){
            int c = array[i];
            if (c>=97 && c<=122){
                array[i] = (char)(array[i]-32);
            }
        }
        return new String(array);
    }

    public static String toggleCase(String s){
        char[] array = s.toCharArray();
        for (int i =0 ; i < array.length ; i++){
            int c = array[i];
            if (c>='a' && c<='z'){
                array[i] = (char)(array[i]-' ');
            }else if (c>='A' && c<='Z'){
                array[i] = (char) (array[i]+' ');
            }
        }
        return new String(array);
    }

    public static int countVowels(String s) {
        char[] array = s.toCharArray();
        int count = 0;
        for (char c : array){
            if (c=='a' || c=='e' ||c=='i' || c=='o' ||c=='u' || c=='A' ||c=='E' || c=='I' ||c=='O' || c=='U'){
                count++;
            }
        }
        return count;
    }

    public static int countConsonants(String s) {
        char[] array = s.toCharArray();
        int count = 0;
        for (char c : array){
            if (!(c=='a' || c=='e' ||c=='i' || c=='o' ||c=='u' || c=='A' ||c=='E' || c=='I' ||c=='O' || c=='U') && ((c>='a'&& c<='z')||(c>='A'&& c<='Z'))){
                count++;
            }
        }
        return count;
    }

    public static int countWords(String s){
        char[] array = s.toCharArray();
        int count = 0,i=0;
        while (array[i] == ' '){
            i++;
        }
        for (; i<array.length ; i++){
            if (array[i] == ' ' && array[i-1] != ' '){
                count++;
            }
        }
        return (count > 0 && array[i-1]!=' ') ? ++count : count;
    }

    public static boolean isValidString(String s){
        char[] array = s.toCharArray();
        int count = 0,i=0;
        for (char c : array){
            if (!(c>='A' && c<='Z') && !(c>='a' && c<='z') &&  !(c>='0' && c<='9')){
                return false;
            }
        }
        return true;
    }

    public static int compare(String s1, String s2){
        if (s1.length() != s2.length()){
            return (s1.length() > s2.length()) ?  1 :  -1;
        }else {
            for (int i=0 ; i<s1.length() ; i++){
                if (s1.charAt(i) > s2.charAt(i)){
                    return 1;
                }else if (s1.charAt(i) < s2.charAt(i)){
                    return 0;
                }
            }
        }
        return 0;
    }

    public static boolean isPalindrome(String s1){
        int endIndex = s1.length()-1,startIndex=0;
        while ( startIndex<endIndex ){
            if (s1.charAt(startIndex++) != s1.charAt(endIndex--))
                return false;
        }
        return true;
    }

    /**
     * Find duplicates in string (Comparing one element with all other element)
     * Time Complexity : O(n^2)
     */
    public static boolean hasDuplicateChar(String s1){
        for (int i=0 ; i<s1.length() ; i++){
            for (int j=i+1 ; j<s1.length() ; j++){
                if (s1.charAt(i) == s1.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Find duplicates in string (Using HashTable)
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     */
    public static Map<Character,Integer> duplicateUsingHashTable(String s1){
        int[] hashTable = new int[26];
        for (int i=0 ; i<s1.length() ; i++){
            hashTable[s1.charAt(i)-97]++;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0 ; i<26 ; i++){
            if (hashTable[i] > 1) {
                map.put((char) (i + 97), hashTable[i]);
            }
        }
        return map;
    }

    /**
     * Find duplicates in string (Using Bitwise Operator)
     * Approach :   Take 4-byes in which 26bits will be useful.
     *              Take A[i]-97 and check if that bits is set at memory taken above (Using Masking = AND)
     *              If yes print the number
     *              else set that bit (Using Merging = OR)
     *
     * Time Complexity : O(n)
     */
    public static void duplicateUsingBitwiseOperations(String s1){
        int H = 0; // Taking 4 bytes (32 bits) in which we will use 26bits
        int x = 0; // This we will be using for masking and merging
        for (int i=0 ; i<s1.length() ; i++){
            x=1;
            x=x<<s1.charAt(i)-97; // MASKING
            if ((x & H)> 0){
                System.out.println(s1.charAt(i));
            }else {
                H = H | x ; // MERGING
            }
        }
    }

    /**
     * check if the two strings are Anagram using HashTable
     * Approach :   Traverse in the first string and increment element of HashTable by 1 (A[i]-99)
     *              Traverse in the second string and increment element of HashTable by 1
     *                  And check if the element is below 0 return false.
     * Time Complexity : O(n)
     */
    public static boolean isAnagram(String s1, String s2){
        if (s1.length() != s2.length()){
            return false;
        }
        int[] hashTable = new int[26];
        for (int i=0 ; i<s1.length() ; i++){
            hashTable[s1.charAt(i)-97]++;
        }

        for (int i=0 ; i<s2.length() ; i++){
            if(--hashTable[s2.charAt(i)-97] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "decimaa";
        String s2 = "medical";

        System.out.println(length(s1));

        System.out.println(toLower(s1));

        System.out.println(toUpper(s1));

        System.out.println(toggleCase(s1));

        System.out.println(countVowels(s1));

        System.out.println(countConsonants(s1));

        System.out.println(countWords(s1));
        System.out.println(isValidString(s1));
        System.out.println(compare(s1,s2));
        System.out.println(isPalindrome(s1));
        System.out.println(hasDuplicateChar(s1));

        Map<Character,Integer> duplicatesFrequency = duplicateUsingHashTable    (s1);
        for(Map.Entry<Character, Integer> s : duplicatesFrequency.entrySet()){
            System.out.println(s+" ");
        }

        duplicateUsingBitwiseOperations(s1);
        System.out.println(isAnagram(s1,s2));
    }
}
