package Graphs.Medium;

//Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
//The graph is represented as an adjacency list, where adj[i] contains a list of vertices that are directly reachable from vertex i. Specifically, adj[i][j] represents an edge from vertex i to vertex j.
//
//Example 1:
//
//Input:
//
//
//
//Output: 1
//Explanation: 3 -> 3 is a cycle
//Example 2:
//Input:
//
//
//Output: 0
//Explanation: no cycle in the graph
//Constraints:
//1 ≤ V, E ≤ 105

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInDirectedGraphBFS {

    public static void main(String[] args) {

    }

    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int vertices = adj.size();

        int[] indegree = new int[vertices];

        for(int i = 0 ; i < adj.size(); i++){
            for(int j = 0 ; j < adj.get(i).size(); j++){
                indegree[adj.get(i).get(j)]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < vertices; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int currVertex = q.remove();
            ArrayList<Integer> neighbours = adj.get(currVertex);
            for(int neighbour : neighbours){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }

        for(int i = 0 ; i < vertices; i++){
            if(indegree[i] != 0){
                return true;
            }
        }

        return false;
    }
}
