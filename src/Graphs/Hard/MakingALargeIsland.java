package Graphs.Hard;


//You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
//
//Return the size of the largest island in grid after applying this operation.
//
//An island is a 4-directionally connected group of 1s.
//
//
//
//Example 1:
//
//Input: grid = [[1,0],[0,1]]
//Output: 3
//Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
//Example 2:
//
//Input: grid = [[1,1],[1,0]]
//Output: 4
//Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
//Example 3:
//
//Input: grid = [[1,1],[1,1]]
//Output: 4
//Explanation: Can't change any 0 to 1, only one island with area = 4.
//
//
//Constraints:
//
//n == grid.length
//n == grid[i].length
//1 <= n <= 500
//grid[i][j] is either 0 or 1.

import java.util.*;

public class MakingALargeIsland {

    public static void main(String[] args) {

    }

    public int makeConnected(int n, int[][] connections) {

        DisjointSet ds = new DisjointSet(n);
        int extraWires = 0;
        for(int i = 0 ; i < connections.length; i++){
            int fNode = connections[i][0];
            int sNode = connections[i][1];

            if(ds.findUParent(fNode) == ds.findUParent(sNode)){
                extraWires++;
            }
            else{
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


