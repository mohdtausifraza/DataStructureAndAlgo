package Recursion;

public class Factorial {

    /**
     * TimeComplexity   : O(n)
     * SpaceComplexity  : O(n)
     */
    public static int factorial(int n){
        if (n==0){
            return 1;
        }else {
            return factorial(n-1) * n ;
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
