package Recursion;

public class FibonacciSeries {
    /**
     *  Fibonacci Series recursively
     * Complexity : O(n);
     */
    public static int fibIterative(int n){
        int x1=0,x2=1,fib=0;
        if (n <= 1){
            return n;
        }
        for (int i=2 ; i <= n ; i++){
            fib = x1+x2;
            x1 = x2;
            x2 = fib;
        }
        return fib;
    }

    /**
     * Time Complexity   : O(2^n)
     *
     * Note :   If a recursive function is calling itself multiple times for the same value
     *          Such a recursive function is called as Excessive Recursion.
     * Below function is an example of excessive Recursion
     */
    public static int fibRecursive(int n){
        if (n <= 1){
            return n ;
        }
        return fibRecursive(n-2) + fibRecursive(n-1);
    }


    public static void main(String[] args) {
        System.out.println(fibIterative(6));
        System.out.println(fibRecursive(5));
    }
}
