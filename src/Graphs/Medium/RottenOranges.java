package Graphs.Medium;

//You are given an m x n grid where each cell can have one of three values:
//
//0 representing an empty cell,
//1 representing a fresh orange, or
//2 representing a rotten orange.
//Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//
//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
//
//
//
//Example 1:
//
//
//Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
//Output: 4
//Example 2:
//
//Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
//Output: -1
//Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
//Example 3:
//
//Input: grid = [[0,2]]
//Output: 0
//Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
//
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 10
//grid[i][j] is 0, 1, or 2.

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int[][] ans = grid;
        int time = 0;
        Queue<Pair> q = new LinkedList<>();
        int freshOranges = 0;

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(grid[i][j] == 2 && vis[i][j] == 0){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
                else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        time = bfs(grid, vis, ans, q, time, freshOranges);
        return time;

    }

    public int bfs(int[][] grid, int[][] vis, int[][] ans, Queue<Pair> q, int time, int freshOranges){
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0 ,-1};
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){
            Pair currItem = q.remove();
            int currRow = currItem.row;
            int currCol = currItem.col;
            int currTime = currItem.time;
            time = currTime;

            for(int i = 0 ; i < 4; i++){
                int nRow = currRow + delRow[i];
                int nCol = currCol + delCol[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0
                        && ans[nRow][nCol] == 1){
                    freshOranges--;
                    ans[nRow][nCol] = 2;
                    q.add(new Pair(nRow, nCol, time+1));
                    vis[nRow][nCol] = 1;
                }
            }
        }

        if(freshOranges == 0)
            return time;

        return -1;
    }
}

class Pair{
    int row;
    int col;
    int time;

    public Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
