package Graphs.Medium;

//Given a weighted, undirected, and connected graph with V vertices and E edges, your task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph. The graph is represented by an adjacency list, where each element adj[i] is a vector containing vector of integers. Each vector represents an edge, with the first integer denoting the endpoint of the edge and the second integer denoting the weight of the edge.
//
//Input:
//3 3
//0 1 5
//1 2 3
//0 2 1
//
//Output: 4
//Explanation:
//
//The Spanning Tree resulting in a weight
//of 4 is shown above.
//Input:
//2 1
//0 1 5
//
//
//
//Output: 5
//
//Explanation: Only one Spanning Tree is possible which has a weight of 5.
//Constraints:
//2 ≤ V ≤ 1000
//V-1 ≤ E ≤ (V*(V-1))/2
//1 ≤ w ≤ 1000
//The graph is connected and doesn't contain self-loops & multiple edges

import java.util.*;

public class MSTKruskalAlgo {

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<Edge> edges = new ArrayList<>();

        for(int i = 0 ; i < V; i++){
            for(int j = 0 ; j < adj.get(i).size(); j++){
                int[] nodes = adj.get(i).get(j);
                int adjNode = nodes[0];
                int weight = nodes[1];
                int node = i;
                edges.add(new Edge(node, adjNode, weight));
            }
        }

        DisjointSet ds = new DisjointSet(V);

        Collections.sort(edges);
        int minSum = 0;
        for (Edge edge : edges) {
            int fNode = edge.src;
            int sNode = edge.dest;
            int wt = edge.wt;

            if (ds.findUParent(fNode) != ds.findUParent(sNode)) {
                minSum += wt;
                ds.unionBySize(fNode, sNode);
            }
        }

        return minSum;
    }
}

class Edge implements Comparable<Edge>{
    int src;
    int dest;
    int wt;

    public Edge(int src, int dest, int wt){
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }

    public int compareTo(Edge compareEdge){
        return this.wt - compareEdge.wt;
    }

}

class DisjointSet{

    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0 ; i <= n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUParent(int n){
        if(n == parent.get(n)){
            return n;
        }

        int par = findUParent(parent.get(n));
        parent.set(n, par);
        return parent.get(n);
    }

    public void unionBySize(int x, int y){
        int ulp_x = findUParent(x);
        int ulp_y = findUParent(y);

        if(ulp_x == ulp_y){
            return;
        }
        if(size.get(ulp_x) < size.get(ulp_y)){
            parent.set(ulp_x, ulp_y);
            size.set(ulp_y, size.get(ulp_y) + size.get(ulp_x));
        }
        else{
            parent.set(ulp_y, ulp_x);
            size.set(ulp_x, size.get(ulp_y) + size.get(ulp_x));
        }
    }

}
