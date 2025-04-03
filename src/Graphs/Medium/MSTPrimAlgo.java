package Graphs.Medium;

import java.util.*;

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
//The graph is connected and doesn't contain self-loops & multiple edges.

public class MSTPrimAlgo {

    public static void main(String[] args) {

    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1])); //sorting according to weights
        int[] visited=new int[V];
        int sum=0;
        pq.offer(new int[]{0,0}); //node,weight;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int u=curr[0];
            int wt=curr[1];
            if(visited[u]==1) continue;
            visited[u]=1;
            sum+=wt;
            for(int[] neighbor:adj.get(u)){
                int v=neighbor[0];
                int w=neighbor[1];
                if(visited[v]==0)
                    pq.add(new int[]{v,w});
            }

        }
        return sum;
    }
}
