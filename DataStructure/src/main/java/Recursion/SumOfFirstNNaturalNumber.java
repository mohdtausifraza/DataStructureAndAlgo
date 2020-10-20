package Recursion;

public class SumOfFirstNNaturalNumber {

    /**
     * TimeComplexity   : O(n)
     * SpaceComplexity  : O(n)
     */
    public static int sumOfFirstNNaturalNumber(int n){
        if (n==0){
            return 0;
        }else {
            return sumOfFirstNNaturalNumber(n - 1)+n;
        }
    }

    /**
     * TimeComplexity   : O(1)
     * SpaceComplexity  : O(1)
     */
    public static int sumOfFirstNNaturalNumberUsingFormula(int n){
        return (n*(n+1))/2;
    }
    public static void main(String[] args) {
        System.out.println(sumOfFirstNNaturalNumber(100));
        System.out.println(sumOfFirstNNaturalNumberUsingFormula(100));
    }
}
