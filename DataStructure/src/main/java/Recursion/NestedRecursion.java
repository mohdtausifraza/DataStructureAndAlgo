package Recursion;

/**
 *  In Nested Recursion, Recursive function will pass parameter as a recursive call.
 *  Like fun( funA(n-1) );
 */
public class NestedRecursion {
    public static int fun(int n){
        if (n > 100){
            return n-10;
        }else {
            return fun(fun(n+11));
        }
    }
    public static void main(String[] args) {
        System.out.println(fun(33));
    }
}
