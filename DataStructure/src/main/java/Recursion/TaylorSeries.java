package Recursion;

/**
 * e^x = (1)+(x/1)+(x^2/2!)+(x^3/3!)+(x^4/4!)+.......+(x^n/n!)
 *
 * Here we are having three things to solve [ sum(n) , fact(n) , pow(x,n) ].
 *
 * For keeping the value of pow(x,n) and fact(n), we will use two STATIC variable.
 */
public class TaylorSeries {

    //For keeping the value of pow(x,n) and fact(n), we will use two STATIC variable.
    static double p=1,f=1;
    public static double taylorSeries(int x, int n){
        double r;
        if (n==0){
            return 1;
        }
        r = taylorSeries(x , n-1);
        p = p*x;
        f = f*n;
        return r+p/f;
    }

    // By taking common we can reduce multiplication from Quadratic to linear
    // 1+(x/1) [ 1+(x/2) + [1+(x/3)] + [1+(x/4)]]]
    static double s = 1;
    public static double taylorSeriesByHornersRule(int x, int n){
        if (n==0)
            return s;
        s = 1+x*s/n;
        return taylorSeriesByHornersRule(x , n-1);
    }
    public static void main(String[] args){
        System.out.println(taylorSeries(4,10)); //54.44310405643739
        System.out.println(taylorSeriesByHornersRule(4,10));
    }
}
