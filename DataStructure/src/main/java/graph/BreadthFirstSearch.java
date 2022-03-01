package graph;

import Queues.QueueUsingLinkedList;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch {
    // Here G is the graph and s is the Source Vertex.
    public List<Integer> bfs(int[][] g, int s){
        // Create a Queue, and enqueue the source vertices in that queue.
        QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
        queue.enqueue(s);
        // Create a Set of visited nodes, and update source vertices here.
        List<Integer> visited = new ArrayList<>();
        visited.add(s);
        while (!queue.isEmpty()){
            // 1. Dequeue from the Queue
            int i = queue.dequeue();
            // 2. Explore all its non-visited adjacent vertices and add in the queue and Visited Set.
            for (int j=0 ; j<g.length ; j++){
                if (g[i][j] != 0 && !visited.contains(j)){
                    queue.enqueue(j);
                    visited.add(j);
                }
            }
        }
        return visited;
    }
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0,0,0,0,0,0,0},
                {0,0,1,1,0,0,0},
                {0,1,0,0,1,1,0},
                {0,1,0,0,0,1,0},
                {0,0,1,0,0,1,1},
                {0,0,1,0,1,0,1},
                {0,0,0,0,1,1,0}
        };
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        List<Integer> result = bfs.bfs(adjacencyMatrix,1);
        System.out.println(result);
    }
}
