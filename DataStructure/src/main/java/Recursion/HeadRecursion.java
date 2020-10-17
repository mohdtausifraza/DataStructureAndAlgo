package Recursion;

/**
 * A function calling itself and that call is the first line of the function,
 * and no work is done before that call (No work is done at calling time), but all the work is done
 * after the function call then it is called HEAD RECURSION
 *
 * A Head Recursion can not be easily converted into loops. But it can be converted
 *
 */
public class HeadRecursion {
    public static void fun(int n){
        if (n > 0){
            // If we add any work here then it will not be a tail recursion.
            fun(n-1);
            System.out.println(n);

        }
    }
    public static void main(String[] args) {
        fun(5);
    }
}
