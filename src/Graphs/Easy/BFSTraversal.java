package Graphs.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

//Given a undirected graph represented by an adjacency list adj, which is a vector of vectors where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Traversal (BFS) starting from vertex 0, visiting vertices from left to right according to the adjacency list, and return a list containing the BFS traversal of the graph.
//
//Note: Do traverse in the same order as they are in the adjacency list.
//
//Examples:
//
//Input: adj = [[2,3,1], [0], [0,4], [0], [2]]
//
//Output: [0, 2, 3, 1, 4]
//Explanation: Starting from 0, the BFS traversal will follow these steps:
//Visit 0 → Output: 0
//Visit 2 (first neighbor of 0) → Output: 0, 2
//Visit 3 (next neighbor of 0) → Output: 0, 2, 3
//Visit 1 (next neighbor of 0) → Output: 0, 2, 3,
//Visit 4 (neighbor of 2) → Final Output: 0, 2, 3, 1, 4
//Input: adj = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]
//
//Output: [0, 1, 2, 3, 4]
//Explanation: Starting from 0, the BFS traversal proceeds as follows:
//Visit 0 → Output: 0
//Visit 1 (the first neighbor of 0) → Output: 0, 1
//Visit 2 (the next neighbor of 0) → Output: 0, 1, 2
//Visit 3 (the first neighbor of 2 that hasn't been visited yet) → Output: 0, 1, 2, 3
//Visit 4 (the next neighbor of 2) → Final Output: 0, 1, 2, 3, 4
//Input: adj = [[1], [0, 2, 3], [1], [1, 4], [3]]
//Output: [0, 1, 2, 3, 4]
//Explanation: Starting the BFS from vertex 0:
//Visit vertex 0 → Output: [0]
//Visit vertex 1 (first neighbor of 0) → Output: [0, 1]
//Visit vertex 2 (first unvisited neighbor of 1) → Output: [0, 1, 2]
//Visit vertex 3 (next neighbor of 1) → Output: [0, 1, 2, 3]
//Visit vertex 4 (neighbor of 3) → Final Output: [0, 1, 2, 3, 4]
//Constraints:
//1 ≤ adj.size() ≤ 104
//1 ≤ adj[i][j] ≤ 104

public class BFSTraversal {

    public ArrayList<Integer> bfsOfGraph(int V,
                                                   ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Arrays.fill(vis, 0);
        java.util.Queue<Integer> traversalQueue = new LinkedList<>();
        traversalQueue.add(0);
        ArrayList<Integer> bfs = new ArrayList<>();

        while(!traversalQueue.isEmpty()){
            int currEle = traversalQueue.remove();

            if(vis[currEle] == 0)
                bfs.add(currEle);
            vis[currEle] = 1;
            List<Integer> currNodeNeighbour = adj.get(currEle);
            for (Integer integer : currNodeNeighbour) {
                if (vis[integer] == 0)
                    traversalQueue.add(integer);
            }
        }

        return bfs;

    }

}