package Graphs.Medium;

//Given a weighted and directed graph of v vertices and edges, Find the shortest distance of all the vertex's from the source vertex, src and return a list of integers where the ith integer denotes the distance of the ith node from the source node. If a vertices can't be reach from the s then mark the distance as 10^8.
//Note: If there exist a path to a negative weighted cycle from the source node then return {-1}.
//
//Examples:
//
//Input: edges = [[0,1,9]], src = 0
//
//Output: [0, 9]
//Explanation: Shortest distance of all nodes from source is printed.
//Input: edges = [[0,1,5], [1,0,3], [1,2,-1], [2,0,1]], src = 2
//
//Output: [1, 6, 0]
//Explanation: For nodes 2 to 0, we can follow the path: 2-0. This has a distance of 1. For nodes 2 to 1, we cam follow the path: 2-0-1, which has a distance of 1+5 = 6,
//Constraints:
//1 ≤ V ≤ 500
//1 ≤ E ≤ V*(V-1)
//-1000 ≤ data of nodes, weight ≤ 1000
//0 ≤ S < V

import java.util.Arrays;

public class BellmanFordAlgo {

    public static void main(String[] args) {

    }

    static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 10e7);

        dist[src] = 0;

        for(int k = 0 ; k < V - 1 ; k++){
            for (int[] edge : edges) {
                int fNode = edge[0];
                int sNode = edge[1];
                int wt = edge[2];

                if (dist[fNode] != (int) 10e7 &&
                        dist[fNode] + wt < dist[sNode]) {
                    dist[sNode] = dist[fNode] + wt;
                }
            }
        }

        for (int[] edge : edges) {
            int fNode = edge[0];
            int sNode = edge[1];
            int wt = edge[2];

            if (dist[fNode] != (int) 10e7 &&
                    dist[fNode] + wt < dist[sNode]) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return dist;

    }
}
