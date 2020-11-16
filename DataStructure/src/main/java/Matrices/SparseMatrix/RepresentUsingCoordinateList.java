package Matrices.SparseMatrix;

/**
 * A matrix in which more elements are zero elements.
 *
 *  0 0 0 0 0 0 1 0 0
 *  0 0 0 5 0 0 0 0 0
 *  9 0 0 0 0 7 0 0 0
 *  0 0 0 0 0 0 0 0 0
 *  0 0 0 0 5 0 0 0 0
 *  0 0 0 0 0 0 0 0 0
 *  0 3 0 0 0 0 0 0 0
 *  0 0 0 0 0 0 0 0 0
 *
 *  Approach :  Create an array of size equal to no or rows;
 *              Create LinkedList(Col,Val,next) for each row non zero element and store in that array
 *
 *              0  (7,1,null)
 *              1  (4,5,null)
 *              2  (0,9,)->(5,7,null)
 *              3  null
 *              4  (4,5,null)
 *              5  null
 *              6  (1,3,null)
 *              7  null
 *
 */
public class RepresentUsingCoordinateList {
    CoordinateList coordinateList;
    int noOfElement = 0;
    static class Element{
        int i,j,value;
        Element(int i, int j, int value){
            this.i=i;
            this.j=j;
            this.value=value;
        }
    }
    static class CoordinateList {
        int m,n,noOfElement;
        Element[] elements;
        CoordinateList(int m, int n, int noOfElement){
            this.m=m;
            this.n=n;
            this.noOfElement = noOfElement;
            this.elements = new Element[noOfElement];
        }
    }
    RepresentUsingCoordinateList(int[][] sparseMatrix){
        int row = sparseMatrix.length;
        int col = sparseMatrix[0].length;
        noOfElement = 0;
        for (int i = 0 ; i < sparseMatrix.length ; i++){
            for (int j = 0 ; j < sparseMatrix[0].length ; j++){
                if (sparseMatrix[i][j] != 0){
                    noOfElement++;
                }
            }
        }
        coordinateList = new CoordinateList(row,col,noOfElement);
        int sparseIndex=0;
        for (int i = 0 ; i < sparseMatrix.length ; i++){
            for (int j = 0 ; j < sparseMatrix[0].length ; j++){
                if (sparseMatrix[i][j] != 0){
                    coordinateList.elements[sparseIndex++] = new Element(i,j,sparseMatrix[i][j]);
                }
            }
        }
    }

    public void display(CoordinateList coordinateList){
        int sparseIndex=0;
        for (int i = 0; i< coordinateList.m ; i++ ){
            for (int j = 0; j< coordinateList.n ; j++ ){
                Element element = coordinateList.elements[sparseIndex];
                if ( (element.i == i) && (element.j == j)){
                    System.out.print(coordinateList.elements[sparseIndex].value+" ");
                    if (sparseIndex < coordinateList.noOfElement-1){
                        sparseIndex++;
                    }
                }else {
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] sparseMatrix = {
                {1,0,0,0,0},
                {0,2,0,0,0},
                {0,2,3,0,0},
                {0,0,0,4,0},
                {0,0,0,0,5},
        };
        RepresentUsingCoordinateList list = new RepresentUsingCoordinateList(sparseMatrix);
        //Displaying Sparse Matrix from CoordinateList which we have created.
        list.display(list.coordinateList);
        System.out.println("1-D equivalent Sparse Matrix");
        System.out.println("No Of Row="+ list.coordinateList.m+", No Of Column="+ list.coordinateList.n+", No Of Element="+ list.coordinateList.noOfElement);
        for (int i=0 ; i < list.noOfElement ; i++){
            System.out.println("Row="+ list.coordinateList.elements[i].i+", Column="+ list.coordinateList.elements[i].j+", Value="+ list.coordinateList.elements[i].value);
        }
    }

}
