package Graphs.Medium;

//You are given an adjacency list, adj of Undirected Graph having unit weight of the edges, find the shortest path from src to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.
//
//Examples :
//
//Input: adj[][] = [[1, 3], [0, 2], [1, 6], [0, 4], [3, 5], [4, 6], [2, 5, 7, 8], [6, 8], [7, 6]], src=0
//Output: [0, 1, 2, 1, 2, 3, 3, 4, 4]
//
//Input: adj[][]= [[3], [3], [], [0, 1]], src=3
//Output: [1, 1, -1, 0]
//
//Input: adj[][]= [[], [], [], [4], [3], [], []], src=1
//Output: [-1, 0, -1, -1, -1, -1, -1]
//Constraint:
//1<=adj.size()<=104
//0<=edges<=adj.size()-1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class ShortestPathInUndirectedGraphBFS {

    public static void main(String[] args) {

    }

    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int nodes = adj.size();
        int[] dist = new int[nodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        while(!q.isEmpty()){
            int currNode = q.remove();
            ArrayList<Integer> neighbours = adj.get(currNode);
            for(int neighbour : neighbours){
                if(dist[currNode] + 1 < dist[neighbour]){
                    dist[neighbour] = dist[currNode] + 1;
                    q.add(neighbour);
                }
            }
        }

        for(int i = 0; i < dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }

        return dist;
    }
}
