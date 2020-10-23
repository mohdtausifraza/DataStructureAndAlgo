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

    /**
     * Storing the result of function call so that it can be utilized again
     * when we need the same Call or avoiding excessive call  is called MEMOIZATION.
     *
     * Time Complexity  : O(n)
     */
    static boolean flag =true;
    static int[] arr;
    public static int fibRecursiveMemoization(int n){
        if (flag){
            arr = new int[n];
            flag =false;
        }
        if (n <= 1)
            return n ;
        if (arr[n-2] == 0)
            arr[n-2] = fibRecursiveMemoization(n-2);
        if (arr[n-1] == 0)
            arr[n-1] = fibRecursiveMemoization(n-1);
        return arr[n-2] + arr[n-1];
    }
    public static void main(String[] args) {
        System.out.println(fibIterative(6));
        System.out.println(fibRecursive(5));
        System.out.println(fibRecursiveMemoization(6));
    }
}
