package Graphs.Medium;

//Given a Directed Acyclic Graph of V vertices from 0 to n-1 and a 2D Integer array(or vector) edges[ ][ ] of length E, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.
//
//Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.
//
//Examples :
//
//Input: V = 4, E = 2, edges = [[0,1,2], [0,2,1]]
//Output: [0, 2, 1, -1]
//Explanation: Shortest path from 0 to 1 is 0->1 with edge weight 2. Shortest path from 0 to 2 is 0->2 with edge weight 1. There is no way we can reach 3, so it's -1 for 3.
//Input: V = 6, E = 7, edges = [[0,1,2], [0,4,1], [4,5,4], [4,2,2], [1,2,3], [2,3,6], [5,3,1]]
//Output: [0, 2, 3, 6, 1, 5]
//Explanation: Shortest path from 0 to 1 is 0->1 with edge weight 2. Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3. Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6. Shortest path from 0 to 4 is 0->4 with edge weight 1.Shortest path from 0 to 5 is 0->4->5 with edge weight 1+4=5.
//Constraint:
//1 <= V <= 100
//1 <= E <= min((N*(N-1))/2,4000)
//0 <= edgesi,0, edgesi,1 < n
//0 <= edgei,2 <=105

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class ShortestPathInDirectedAcyclicGraphBFS {

    public static void main(String[] args) {

    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        //5.13
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        dist[0] = 0;

        while(!q.isEmpty()){
            Pair currPair = q.remove();
            int currNode = currPair.node;
            int currDist = currPair.dist;

            ArrayList<Pair> neighbours = adj.get(currNode);
            for(Pair neighbour : neighbours){
                if(currDist + neighbour.dist < dist[neighbour.node]){
                    dist[neighbour.node] = currDist + neighbour.dist;
                    q.add(new Pair(neighbour.node, dist[neighbour.node]));
                }
            }
        }

        for(int i = 0 ; i < V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }

        return dist;
    }

    public class Pair{
        int node;
        int dist;

        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
}
