package Recursion;

/**
 * A function calling itself and that call is the last line of that function
 * then it is called TAIL RECURSION
 *
 * A Tail Recursion can be easily converted into loops.
 *
 * Time Complexity for both Loop and Recursion : O(n)
 * Space Complexity Loop O(1), Recursion : O(n) because of unique memory in the stack.
 *
 * Conclusion : If you need to write Tail Recursion the better convert that into loop which is more
 *              efficient in terms of space.
 */
public class TailRecursion {
    public static void fun(int n){
        if (n > 0){
            System.out.println(n);
            // This is a Tail Recursion
            fun(n-1);

            /**
             * This is not a Tail Recursion as it is adding n after the function call.
             */
            //fun(n-1)+n;
        }
    }
    public static void main(String[] args) {
        fun(5);
    }
}
