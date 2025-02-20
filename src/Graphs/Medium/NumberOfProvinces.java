package Graphs.Medium;

//There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
//
//A province is a group of directly or indirectly connected cities and no other cities outside of the group.
//
//You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
//
//Return the total number of provinces.
//
//
//
//Example 1:
//
//
//Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//Output: 2
//Example 2:
//
//
//Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//Output: 3
//
//
//Constraints:
//
//1 <= n <= 200
//n == isConnected.length
//n == isConnected[i].length
//isConnected[i][j] is 1 or 0.
//isConnected[i][i] == 1
//isConnected[i][j] == isConnected[j][i]

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {

        int numberOfProvinces = 0;
        int vertices = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= vertices; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < vertices; i++){
            for(int j = 0 ; j < isConnected[i].length; j++){
                if(i != j && isConnected[i][j] == 1){
                    adj.get(i+1).add(j+1);
                }
            }
        }

        int[] visited = new int[vertices+1];
        Arrays.fill(visited, 0);

        for(int i = 1; i <= vertices; i++){
            if(visited[i] == 0){
                numberOfProvinces++;
                bfs(i, visited, adj);
            }
        }

        return numberOfProvinces;
    }

    public void bfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> traversalQueue = new LinkedList<>();
        traversalQueue.add(node);

        while(!traversalQueue.isEmpty()){
            int currNode =  traversalQueue.remove();
            visited[currNode] = 1;
            ArrayList<Integer> neighbours = adj.get(currNode);
            for (int currNeighbour : neighbours) {
                if (visited[currNeighbour] == 0) {
                    traversalQueue.add(currNeighbour);
                }
            }
        }
    }
}
