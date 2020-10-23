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
    public static void main(String[] args) {
        System.out.println(pow(2,5));
    }
}
