package Matrices.SparseMatrix.Polynomial;

import java.util.Scanner;
import static Matrices.SparseMatrix.Polynomial.PolynomialRepresentation.*;

/**
 * Approach:    Create Polynomial representation from the input.
 *              Traverse in that Representation and perform coeff*pow(x,exp) for Ploy.noOfTerms times.
 */

public class PolynomialEvaluation {

    public double evaluate(Poly poly , int x){
        double sum = 0;
        for (int i =0 ; i < poly.noOfTerms ; i++){
            sum = sum + (poly.terms.get(i).coeff*Math.pow(x,poly.terms.get(i).exp));
        }
        return sum;
    }

    public static void main(String[] args) {
        PolynomialRepresentation representation = new PolynomialRepresentation();
        Poly polynomial = representation.createRepresentation();
        int x;
        System.out.println("Enter value of x");
        x = new Scanner(System.in).nextInt();
        double result = new PolynomialEvaluation().evaluate(polynomial , x);
        System.out.println("Evaluation Result = "+result);
    }

}
