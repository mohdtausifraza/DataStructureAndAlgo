package Matrices.SparseMatrix.Polynomial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  p(x) = 3x^5 + 2x^4 + 5x^2 + 2x +10
 *
 *  No Of Terms = 5
 *
 *  Coeff   -> 3 2 5 2 10
 *  Expo    -> 5 4 2 1 0
 */

public class PolynomialRepresentation {

    static class Poly{
        int noOfTerms;
        List<Term> terms;
        Poly(int noOfTerms){
            this.noOfTerms = noOfTerms;
            this.terms = new ArrayList<>();
        }
    }

    static class Term{
        int coeff;
        int exp;
        Term(int coeff, int exp){
            this.coeff = coeff;
            this.exp = exp;
        }
    }

    public Poly createRepresentation() {
        int n=0,coefficient,exponent;
        System.out.println("Enter Number of Terms");
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        Poly polynomial = new Poly(n);
        for (int i=1 ; i <= n ; i++){
            System.out.println("Enter "+i +" Term coefficient");
            coefficient = scanner.nextInt();

            System.out.println("Enter "+i +" Term Exponent");
            exponent = scanner.nextInt();

            polynomial.terms.add(i-1,new Term(coefficient,exponent));
        }
        printPolynomial(n, polynomial);
        return polynomial;
    }

    public void printPolynomial(int n, Poly polynomial) {
        System.out.println("Printing the polynomial");
        StringBuilder sb = new StringBuilder();
        System.out.print("P(x)=");
        for (int i = 0; i < n; i++){
            if (i==0){
                sb.append(polynomial.terms.get(i).coeff);
            }else if (polynomial.terms.get(i).coeff > 0){
                sb.append("+"+ polynomial.terms.get(i).coeff);
            }else{
                sb.append(polynomial.terms.get(i).coeff);
            }
            if (polynomial.terms.get(i).exp != 0){
                sb.append("x^"+ polynomial.terms.get(i).exp );
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Poly polynomial = new PolynomialRepresentation().createRepresentation();
    }

}
