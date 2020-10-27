package Recursion;

/**
 * Move Disc A to C.
 * You have to take out one disc at a time.
 * Transfer such that no larger disk is placed on smaller disc
 */
public class TowerOfHanoi {
    public static void TOH(int n , char A, char B, char C){
        if (n > 0){
            TOH(n-1 , A , C, B);
            System.out.println("("+A +"->"+C+")");
            TOH(n-1 , B , A ,C);
        }
    }
    public static void main(String[] args) {
        TOH(3,'A','B','C');
    }
}
