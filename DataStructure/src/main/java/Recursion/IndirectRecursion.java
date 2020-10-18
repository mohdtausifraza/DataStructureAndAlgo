package Recursion;

/**
 *  In Indirect Recursion there may be more than one function calling one another in a circular fashion.
 *  Like A --> B --> C --> D --> A
 */
public class IndirectRecursion {
    public static void funA(int n){
        if (n > 0){
            System.out.println(n);
            // funA is calling funB
            funB(n-1);
        }
    }
    public static void funB(int n){
        if (n > 1){
            System.out.println(n);
            // funB is calling funA
            funA(n/2);
        }
    }
    public static void main(String[] args) {
        funA(20);
    }
}
