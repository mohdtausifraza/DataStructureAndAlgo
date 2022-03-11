package graph;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PrimsMinimumCostSpanningTree {

    public void primMST(int[][] g){

        // Create 1-D array to store nearest element, and Initialize all element with Integer.Max;
        int[] near= new int[g.length];
        Arrays.fill(near,Integer.MAX_VALUE);

        // Create to 2-D Array to store MST Result
        int[][] result  = new int[2][g.length-2];

        // Find the minimum cost edge from upper or lower triangle of the matrix.
        int v1=Integer.MAX_VALUE,v2=Integer.MAX_VALUE,minimumCost = Integer.MAX_VALUE;
        for (int i=0 ; i< g.length ; i++){
            for(int j=i ; j<g[0].length ; j++){
                if (g[i][j] < minimumCost){
                    minimumCost=g[i][j];
                    v1=i;
                    v2=j;
                }
            }
        }
        // Add both the vertex with minimum cost in the result array.
        result[0][0] = v1;
        result[1][0] = v2;
        // Mark v1 and v2 as visited in the near array
        near[v1] = 0;
        near[v2] = 0;

        // Update near[] with the nearest vertex
        for (int i=1; i< g.length ; i++){
            if(near[i]!=0){
                near[i] = g[i][v1] < g[i][v2] ? v1 : v2;
            }
        }

        // Check all the vertices weather they are nearer to v1 or v2;
        int resultIndex=1;
        for(int i=1 ; i<g.length-2 ; i++){
            // Find the minimum cost edge in the near[]
            minimumCost = Integer.MAX_VALUE;
            int k=0;
            for (int j=1; j< g.length ; j++){
                if(near[j]!=0 && g[j][near[j]]<minimumCost){
                    minimumCost= g[j][near[j]];
                    k=j;
                }
            }
            //Update v1 and v2 in result[][]
            result[0][resultIndex] = k;
            result[1][resultIndex++] = near[k];

            near[k]=0;

            // Update near array
            for (int j=1; j< g.length ; j++){
                if(near[j]!=0){
                    near[j] = g[j][k] < g[j][near[j]] ? k : near[j];
                }
            }
        }
        printResult(result);
    }
    public void printResult(int[][] result){
        for (int i=0 ; i<result[0].length ; i++){
            System.out.println(result[0][i]+" -> "+result[1][i]);
        }
    }
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 25, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 5, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 25, Integer.MAX_VALUE, 12, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 10},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 12, Integer.MAX_VALUE, 8, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 8, Integer.MAX_VALUE, 16, Integer.MAX_VALUE, 14},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 16, Integer.MAX_VALUE, 20, 18},
                {Integer.MAX_VALUE, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 20, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 10, Integer.MAX_VALUE, 14, 18, Integer.MAX_VALUE, Integer.MAX_VALUE,}
        };
        PrimsMinimumCostSpanningTree mst = new PrimsMinimumCostSpanningTree();
        mst.primMST(adjacencyMatrix);
    }
}
