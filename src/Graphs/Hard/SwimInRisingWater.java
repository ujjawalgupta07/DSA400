package Graphs.Hard;

//You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
//
//The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
//
//Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
//
//
//
//Example 1:
//
//
//Input: grid = [[0,2],[1,3]]
//Output: 3
//Explanation:
//At time 0, you are in grid location (0, 0).
//You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
//You cannot reach point (1, 1) until time 3.
//When the depth of water is 3, we can swim anywhere inside the grid.
//Example 2:
//
//
//Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
//Output: 16
//Explanation: The final route is shown.
//We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
//
//
//Constraints:
//
//n == grid.length
//n == grid[i].length
//1 <= n <= 50
//0 <= grid[i][j] < n2
//Each value grid[i][j] is unique.

import java.util.*;

public class SwimInRisingWater {

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int[] nRows = {-1, 0, 1, 0};
        int[] nCols = {0, -1, 0, 1};

        int finalTime = 0;

        int[][] visited = new int[n][n];
        PriorityQueue<Tuple> q = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        q.add(new Tuple(grid[0][0], 0, 0));

        while(!q.isEmpty()){
            Tuple currTuple = q.remove();
            int currWt = currTuple.wt;
            int currRow = currTuple.row;
            int currCol = currTuple.col;
            visited[currRow][currCol] = 1;
            finalTime = Math.max(finalTime, currWt);
            if(currRow == n - 1 && currCol == n - 1){
                return finalTime;
            }
            for(int k = 0 ; k < 4; k++){
                int nRow = currRow + nRows[k];
                int nCol = currCol + nCols[k];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && visited[nRow][nCol] != 1){
                    q.add(new Tuple(Math.max(currWt, grid[nRow][nCol]), nRow, nCol));
                }
            }

        }

        return finalTime;

    }
}

class Tuple{
    int wt;
    int row;
    int col;

    public Tuple(int wt, int row, int col){
        this.wt = wt;
        this.row = row;
        this.col = col;
    }

}
