package Graphs.Medium;

//Given a weighted, undirected and connected graph where you have given adjacency list adj. You have to find the shortest distance of all the vertices from the source vertex src, and return a list of integers denoting the shortest distance between each node and source vertex src.
//
//Note: The Graph doesn't contain any negative weight edge.
//
//Examples:
//
//Input: adj = [[[1, 9]], [[0, 9]]], src = 0
//Output: [0, 9]
//Explanation:
//
//The source vertex is 0. Hence, the shortest distance of node 0 is 0 and the shortest distance from node 0 to 1 is 9.
//Input: adj = [[[1, 1], [2, 6]], [[2, 3], [0, 1]], [[1, 3], [0, 6]]], src = 2
//Output: [4, 3, 0]
//Explanation:
//
//For nodes 2 to 0, we can follow the path 2-1-0. This has a distance of 1+3 = 4, whereas the path 2-0 has a distance of 6. So, the Shortest path from 2 to 0 is 4.
//The shortest distance from 0 to 1 is 1 .
//Constraints:
//1 ≤ no. of vertices ≤ 1000
//0 ≤ adj[i][j] ≤ 1000
//0 ≤ src < no. of vertices

import java.util.*;

public class DijkstraAlgoUsingPriorityQueue {

    public static void main(String[] args) {

    }

    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        int nodes = adj.size();
        PriorityQueue<iPair> pq = new PriorityQueue<iPair>
                ((x,y) -> x.first - y.first);
        int[] dist = new int[nodes];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new iPair(0, src));
        dist[src] = 0;

        while(!pq.isEmpty()){
            iPair currPair = pq.remove();
            int currDist = currPair.first;
            int currNode = currPair.second;

            ArrayList<iPair> neighbours = adj.get(currNode);
            for(iPair neighbour : neighbours){
                if(neighbour.second + currDist < dist[neighbour.first]){
                    dist[neighbour.first] = neighbour.second + currDist;
                    pq.add(new iPair(dist[neighbour.first], neighbour.first));
                }
            }
        }

        for(int i = 0 ; i < nodes; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }

        ArrayList<Integer> distList = new ArrayList<>();

        for(int i = 0 ; i < nodes; i++){
            distList.add(dist[i]);
        }

        return distList;
    }

    class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
