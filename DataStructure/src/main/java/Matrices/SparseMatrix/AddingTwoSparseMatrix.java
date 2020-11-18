package Matrices.SparseMatrix;

import static Matrices.SparseMatrix.RepresentUsingCoordinateList.CoordinateList;
import static Matrices.SparseMatrix.RepresentUsingCoordinateList.Element;

/**
 * Approach : Traverse in both the spare matrix and check and add and create a new sparse matrix.
 */
public class AddingTwoSparseMatrix {
    public CoordinateList add(CoordinateList coordinateList1 , CoordinateList coordinateList2){
        int index = 0,index1=0,index2=0,noOfElements=0;
        CoordinateList coordinateList = new CoordinateList(coordinateList1.m,coordinateList1.n,coordinateList1.noOfElement+coordinateList2.noOfElement);
        Element[] elements1 = coordinateList1.elements;
        Element[] elements2 = coordinateList2.elements;
        while(index1<elements1.length && index2<elements2.length){
            if (elements1[index1].i < elements2[index2].i){
                coordinateList.elements[index++]=new Element(elements1[index1].i,elements1[index1].j,elements1[index1].value);
                index1++;
                noOfElements++;
            }else if (elements1[index1].i > elements2[index2].i){
                coordinateList.elements[index++]=new Element(elements2[index2].i,elements2[index2].j,elements2[index2].value);
                index2++;
                noOfElements++;
            }else{
                if (elements1[index1].j < elements2[index2].j){
                    coordinateList.elements[index++]=new Element(elements1[index1].i,elements1[index1].j,elements1[index1].value);
                    index1++;
                    noOfElements++;
                }else if (elements1[index1].j > elements2[index2].j){
                    coordinateList.elements[index++]=new Element(elements2[index2].i,elements2[index2].j,elements2[index2].value);
                    index2++;
                    noOfElements++;
                } else if (elements1[index1].j == elements2[index2].j){
                    coordinateList.elements[index++]=new Element(elements2[index2].i,elements2[index2].j,elements1[index1].value+elements2[index2].value);
                    index1++;
                    index2++;
                    noOfElements++;
                }
            }
        }
        for (int i=index1 ; i<elements1.length;i++){
            coordinateList.elements[index++]=new Element(elements1[index1].i,elements1[index1].j,elements1[index1].value);
            noOfElements++;
        }
        for (int i=index2 ; i<elements2.length;i++){
            coordinateList.elements[index++]=new Element(elements2[index2].i,elements2[index2].j,elements2[index2].value);
            noOfElements++;
        }
        coordinateList.noOfElement=noOfElements;
        return coordinateList;
    }

    public static void main(String[] args) {
        int[][] sparseMatrix1 = {
                {1,0,0,0,0},
                {0,2,0,0,0},
                {0,2,3,0,0},
                {0,0,0,4,0},
                {0,0,0,0,5},
        };

        int[][] sparseMatrix2 = {
                {0,1,0,0,0},
                {0,5,0,0,0},
                {0,2,0,6,0},
                {0,0,0,0,3},
                {0,0,2,0,0},
        };

        RepresentUsingCoordinateList coordinateList1 = new RepresentUsingCoordinateList(sparseMatrix1);
        RepresentUsingCoordinateList coordinateList2 = new RepresentUsingCoordinateList(sparseMatrix2);
        CoordinateList list1 = coordinateList1.coordinateList;
        CoordinateList list2 = coordinateList2.coordinateList;

        System.out.println("Printing First Sparse Matrix");
        coordinateList1.display(coordinateList1.coordinateList);
        // Displaying Co-ordinate Matrix for First sparse matrix;
        System.out.println("1-D equivalent Sparse Matrix");
        System.out.println("No Of Row="+ list1.m+", No Of Column="+ list1.n+", No Of Element="+ list1.noOfElement);
        for (int i=0 ; i < list1.noOfElement ; i++){
            System.out.println("Row="+ list1.elements[i].i+", Column="+ list1.elements[i].j+", Value="+ list1.elements[i].value);
        }

        System.out.println("Printing Second Sparse Matrix");
        coordinateList2.display(coordinateList2.coordinateList);
        // Displaying Co-ordinate Matrix for Second sparse matrix;
        System.out.println("1-D equivalent Sparse Matrix");
        System.out.println("No Of Row="+ list2.m+", No Of Column="+ list2.n+", No Of Element="+ list2.noOfElement);
        for (int i=0 ; i < list2.noOfElement ; i++){
            System.out.println("Row="+ list2.elements[i].i+", Column="+ list2.elements[i].j+", Value="+ list2.elements[i].value);
        }

        AddingTwoSparseMatrix addingTwoSparseMatrix = new AddingTwoSparseMatrix();
        CoordinateList coordinateList = addingTwoSparseMatrix.add(coordinateList1.coordinateList,coordinateList2.coordinateList);
        CoordinateList newCoordinateList = new CoordinateList(coordinateList.m,coordinateList.n,coordinateList.noOfElement);
        for (int i=0 ; i< coordinateList.noOfElement ; i++){
            newCoordinateList.elements[i]= new Element(coordinateList.elements[i].i,coordinateList.elements[i].j,coordinateList.elements[i].value);
        }
        System.out.println("Printing Sum Sparse Matrix");
        coordinateList1.display(newCoordinateList);
        System.out.println("1-D equivalent Sum Sparse Matrix");
        System.out.println("No Of Row="+ newCoordinateList.m+", No Of Column="+ newCoordinateList.n+", No Of Element="+ newCoordinateList.noOfElement);
        for (int i=0 ; i < newCoordinateList.noOfElement ; i++){
            System.out.println("Row="+ newCoordinateList.elements[i].i+", Column="+ newCoordinateList.elements[i].j+", Value="+ newCoordinateList.elements[i].value);
        }


    }

}
