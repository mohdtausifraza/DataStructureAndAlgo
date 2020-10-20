package Recursion;

/**
 * Linear Recursion : A function calling itself only one time. As we saw in Head and Tail Recursion
 *
 * Tree Recursion   : A function calling itself more than one time.
 *
 * Time Complexity  : O(2^n) : Calculate using Geometric Progression.
 * Space Complexity : O(n)
 * 
 */
public class TreeRecursion {
    public static void fun(int n){
        if (n > 0){
            System.out.println(n);
            fun(n-1);
            fun(n-1);
        }
    }
    public static void main(String[] args) {
        fun(3);
    }
}
