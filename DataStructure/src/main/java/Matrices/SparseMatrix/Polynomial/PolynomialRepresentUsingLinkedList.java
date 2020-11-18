package Matrices.SparseMatrix.Polynomial;

import java.util.Scanner;

/**
 *  p(x) = 3x^5 + 2x^4 + 5x^2 + 2x +10
 *
 *  No Of Terms = 5
 *
 *  p(x) = (3,5)->(2,4)->(5,2),(2,1),(10,0);
 */
public class PolynomialRepresentUsingLinkedList {

    static class Node{
        int coefficient;
        int exponent;
        Node next;

        public Node(int coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
            this.next = null;
        }
    }

    public Node createRepresentation() {
        int n,coefficient,exponent;
        Node head=null,last=null;
        System.out.println("Enter Number of Terms");
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        for (int i=1 ; i <= n ; i++){
            System.out.println("Enter "+i +" Term coefficient");
            coefficient = scanner.nextInt();

            System.out.println("Enter "+i +" Term Exponent");
            exponent = scanner.nextInt();

            if (i==1){
                head=new Node(coefficient,exponent);
                last = head;
            }else {
               last.next = new Node(coefficient,exponent);
               last = last.next;
            }
        }
        printPolynomial(head);
        return head;
    }

    public void printPolynomial(Node head) {
        System.out.println("Printing the polynomial");
        StringBuilder sb = new StringBuilder();
        System.out.print("P(x)=");
        int i=0;
        Node temp = head;
        while (temp != null){
            if (i==0){
                sb.append(temp.coefficient);
                i++;
            }else if (temp.coefficient > 0){
                sb.append("+"+ temp.coefficient);
            }else{
                sb.append(temp.coefficient);
            }
            if (temp.exponent != 0){
                sb.append("x^"+ temp.exponent );
            }
            temp = temp.next;
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        new PolynomialRepresentUsingLinkedList().createRepresentation();
    }
}
