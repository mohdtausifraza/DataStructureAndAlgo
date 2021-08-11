package Recursion;

/**
 * Link    :    https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 * Problem :    Count ways to reach the n’th stair
 *              Condition : He can jump 1 or 2, or 3 Stair at one time.
 */
public class StairCaseProblem {
    private static int noOfWays(int n){
        if (n<0)
            return 0;
        if (n == 0 || n==1)
            return 1;
        return noOfWays(n-1)+ noOfWays(n-2)+ noOfWays(n-3);
    }
    public static void main(String[] args) {
        System.out.println(noOfWays(5));
    }
}
