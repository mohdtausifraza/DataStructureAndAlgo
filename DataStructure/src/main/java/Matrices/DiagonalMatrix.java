/**
 * Diagonal Matrix : A matrix having 0 at non diagonal position. M[i,j]=0 if(i != j).
 * Here we will represent a special Special 2-D Matrix called DiagonalMatrix into 1-D Array
 */
package Matrices;

import java.sql.SQLOutput;

public class DiagonalMatrix {
    static int[] array;
    DiagonalMatrix(int n){
        array = new int[n];
    }
    public static void set(int i, int j, int value){
        if (i==j){
            array[i-1] = value ;
        }
    }
    public static int get(int i, int j){
        return (i==j) ? array[i-1] : 0 ;
    }
    public static void display(){
        for (int i=0 ; i<array.length ; i++){
            for (int j=0 ; j<array.length ; j++){
                System.out.print(get(i+1 , j+1)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        DiagonalMatrix diagonalMatrix = new DiagonalMatrix(6);
        set(1,1,1);
        set(2,2,2);
        set(3,3,3);
        set(4,4,4);
        set(5,5,5);
        set(6,6,6);

        // Printing Diagonal Matrix from equivalent 1-D Matrix
        System.out.println("DiagonalMatrix : ");
        display();
        // Printing 1-D Matrix Equivalent to Diagonal Matrix
        System.out.println("1-D Matrix Equivalent to DiagonalMatrix");
        for (int i : array){
            System.out.print(i+" ");
        }
    }
}
