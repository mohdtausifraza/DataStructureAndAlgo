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



    public static void main(String[] args) {
        String s1 = "decimaa";
        String s2 = "medical";

//        System.out.println(length(s1));
//
//        System.out.println(toLower(s1));
//
//        System.out.println(toUpper(s1));
//
    }
}
