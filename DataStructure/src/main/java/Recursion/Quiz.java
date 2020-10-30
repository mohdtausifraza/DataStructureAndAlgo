package Recursion;

public class Quiz {
    /**
     * Use of static
     * What will be returned if call for ques(1);
     */
    static int i;
    public static int ques1(int n){
        if (n >= 5){
            return n;
        }
        n = n+i;
        i++;
        return ques1(n);
    }

    /**
     * Ques 2;
     */
    public static void ques2(int n , int sum){
        int k=0, j=0;
        if (n == 0){
            return;
        }
        k = n%10;
        j = n/10;
        sum = sum + k;
        ques2(j , sum);
        System.out.println(k);
    }
    /**
     * Ques 3
     */
    static int x = 5;
    public static int ques3(int c){
        c = c-1;
        if (c==0){
            return 1;
        }
        x = x+1;
        return ques3(c)*x;
    }

    /**
     * Ques 4
     */
    public static int ques4(int n){
        int x=1;
        if (n==1){
            return x;
        }
        for (int k=1 ; k < n ; ++k){
            x = x+ques4(k)*ques4(n-k);
        }
        return x;
    }

    /**
     * Ques 5
     */
    static int d =1;
    public static void ques5(int n){
        System.out.print(n+",");
        System.out.print(d+",");
        d++;
        if (n > 1)
            ques5(n-1);
        System.out.print(d+",");
    }

    public static void main(String[] args) {
        System.out.println(ques1(1));
        //Ques 2
        int a=2048 , sum =0;
        ques2(a,sum);
        System.out.println(sum);
        //Ques 3
        System.out.println(ques3(5));
        //Ques 4
        System.out.println(ques4(5));
        //Ques 5
        ques5(3);
    }
}
