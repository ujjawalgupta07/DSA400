package Graphs.Medium;

//Given an adjacency list for a Directed Acyclic Graph (DAG) where adj[u] contains a list of all vertices v such that there exists a directed edge u -> v. Return topological sort for the given graph.
//
//Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
//Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be 1 else 0.
//
//Examples:
//
//Input: adj = [[], [0], [0], [0]]
//
//Output: 1
//Explanation: The output 1 denotes that the order is valid. Few valid Topological orders for the given graph are:
//[3, 2, 1, 0]
//[1, 2, 3, 0]
//[2, 3, 1, 0]
//Input: adj = [[], [3], [3], [], [0,1], [0,2]]
//
//Output: 1
//Explanation: The output 1 denotes that the order is valid. Few valid Topological orders for the graph are:
//[4, 5, 0, 1, 2, 3]
//[5, 2, 4, 0, 1, 3]
//Constraints:
//2  ≤  V  ≤  103
//1  ≤  E  ≤  (V * (V - 1)) / 2

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> topoSort = new ArrayList<>();
        int nodes = adj.size();
        int[] vis = new int[nodes];

        for(int i = 0 ; i < nodes; i++){
            if(vis[i] == 0){
                dfs(i, st, vis, adj);
            }
        }

        while(!st.isEmpty()){
            topoSort.add(st.peek());
            st.pop();
        }
//        return topoSort;

    }

    public static void dfs(int node, Stack<Integer> st,
                    int[] vis, ArrayList<ArrayList<Integer>> adj){

        vis[node] = 1;
        ArrayList<Integer> neighbours = adj.get(node);
        for(int neighbour : neighbours){
            if(vis[neighbour] == 0){
                dfs(neighbour, st, vis, adj);
            }
        }

        st.push(node);

    }
}
