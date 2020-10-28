package Recursion;

/**
 * Also known as selection formula.
 * If sets of objects are given to us, then in how many ways we can select the subset of those objects
 * nCr = n!/r!(n-r)!
 * Condition for this formulae :
 *      If value of n=5 the value of r can be 0-5
 */
public class CombinationFormula_nCr {
    /**
     *  Here we will be using previously written factorial.
     *  Time Complexity : O(n)
     */
    public static int nCrUsingFact(int n, int r){
        int nFact = Factorial.factorial(n);
        int rFact = Factorial.factorial(r);
        int nMinusRFact = Factorial.factorial(n-r);
        return nFact/(rFact*nMinusRFact);
    }

    /**
     * Using Pascal's Triangle
     */
    public static int nCr(int n, int r){
        if (r==0 || r==n){
            return 1;
        }else {
            return nCr(n-1,r-1)+ nCr(n-1,r);
        }
    }
    public static void main(String[] args) {
        System.out.println(nCrUsingFact(4,2));
        System.out.println(nCr(4,2));
    }
}
