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



    public static void main(String[] args) {
        String s1 = "decimaa";
        String s2 = "medical";

        System.out.println(length(s1));

        System.out.println(toLower(s1));

        System.out.println(toUpper(s1));

        System.out.println(toggleCase(s1));

        System.out.println(countVowels(s1));

        System.out.println(countConsonants(s1));

    }
}
