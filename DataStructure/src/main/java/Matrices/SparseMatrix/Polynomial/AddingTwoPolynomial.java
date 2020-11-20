package Matrices.SparseMatrix.Polynomial;

import java.util.Scanner;

import static Matrices.SparseMatrix.Polynomial.PolynomialRepresentation.Poly;

/**
 * Approach:    Create Polynomial representation from the input.
 *              Traverse in that Representation .
 */

public class AddingTwoPolynomial {

    public Poly add(Poly poly1 , Poly poly2){
        Poly result = new Poly(poly1.noOfTerms+poly2.noOfTerms);
        int index=0,index1=0,index2=0;
        result.noOfTerms=0;
        while(index1<poly1.noOfTerms && index2<poly2.noOfTerms){
            if (poly1.terms.get(index1).exp > poly2.terms.get(index2).exp){
                result.terms.add(index,new PolynomialRepresentation.Term(poly1.terms.get(index1).coeff,poly1.terms.get(index1).exp));
                index1++;
            }else if (poly1.terms.get(index1).exp < poly2.terms.get(index2).exp){
                result.terms.add(index,new PolynomialRepresentation.Term(poly2.terms.get(index2).coeff,poly2.terms.get(index2).exp));
                index2++;
            }else {
                result.terms.add(index,new PolynomialRepresentation.Term(poly1.terms.get(index1).coeff+poly2.terms.get(index2).coeff,poly2.terms.get(index2).exp));
                index1++;
                index2++;
            }
            result.noOfTerms++;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        PolynomialRepresentation representation = new PolynomialRepresentation();

        System.out.println("Enter the details of Polynomial-1");
        Poly polynomial1 = representation.createRepresentation();

        System.out.println("Enter the details of Polynomial-2");
        Poly polynomial2 = representation.createRepresentation();

        Poly polynomial = new AddingTwoPolynomial().add(polynomial1,polynomial2);

        representation.printPolynomial(polynomial.noOfTerms , polynomial);

    }

}
