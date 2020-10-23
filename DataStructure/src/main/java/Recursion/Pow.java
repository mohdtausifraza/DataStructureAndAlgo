package Recursion;

public class Pow {

    /**
     * TimeComplexity   : O(n)
     * SpaceComplexity  : O(n)
     */
    public static int pow(int m, int n){
        if (n==0){
            return 1;
        }else {
            return pow(m ,n-1)*m;
        }
    }

    // Second way with less multiplications.
    public static int powLessMultiplication(int m, int n){
        if (n==0){
            return 1;
        }else if (n % 2 == 0){
            return powLessMultiplication(m*m ,n/2);
        }else {
            return m* powLessMultiplication(m*m ,(n-1)/2);
        }
    }
    public static void main(String[] args) {
        System.out.println(pow(2,5));
        System.out.println(powLessMultiplication(2,5));
    }
}
