package Graphs.Medium;

//There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.
//
//You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
//
//Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
//
//
//
//Example 1:
//
//
//Input: n = 4, connections = [[0,1],[0,2],[1,2]]
//Output: 1
//Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
//Example 2:
//
//
//Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
//Output: 2
//Example 3:
//
//Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
//Output: -1
//Explanation: There are not enough cables.
//
//
//Constraints:
//
//1 <= n <= 105
//1 <= connections.length <= min(n * (n - 1) / 2, 105)
//connections[i].length == 2
//0 <= ai, bi < n
//ai != bi
//There are no repeated connections.
//No two computers are connected by more than one cable.

import java.util.*;

public class NumberOfOperationsToConnectNetwork {

    public static void main(String[] args) {

    }

    public int makeConnected(int n, int[][] connections) {

        DisjointSet ds = new DisjointSet(n);
        int extraWires = 0;
        for (int[] connection : connections) {
            int fNode = connection[0];
            int sNode = connection[1];

            if (ds.findUParent(fNode) == ds.findUParent(sNode)) {
                extraWires++;
            } else {
                ds.unionBySize(fNode, sNode);
            }
        }

        int numberOfNetworks = 0;

        for(int i = 0 ; i < n; i++){
            if(ds.parent.get(i) == i){
                numberOfNetworks++;
            }
        }

        int ans = numberOfNetworks - 1;
        if(extraWires >= ans){
            return ans;
        }

        return -1;
    }

    static class DisjointSet{

        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public List<Integer> getParentList(){
            return this.parent;
        }

        public DisjointSet(int n){
            for(int i = 0 ; i < n ; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findUParent(int n){
            if(parent.get(n) == n){
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
                size.set(ulp_y, size.get(ulp_x) + size.get(ulp_y));
            }
            else{
                parent.set(ulp_y, ulp_x);
                size.set(ulp_x, size.get(ulp_x) + size.get(ulp_y));
            }
        }
    }

}

