package Graphs.Hard;

//You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
//
//A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
//
//Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
//
//
//
//Example 1:
//
//
//Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//Output: 3
//Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
//Example 2:
//
//
//Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//Output: 0
//Explanation: All 1s are either on the boundary or can reach the boundary.
//
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 500
//grid[i][j] is either 0 or 1.

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {

        int numberOfOnes = 0;
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[n][m];

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    numberOfOnes++;
                    if(i == 0 || j == 0 || i == n - 1 || j == m - 1){
                        q.add(new Pair(i, j));
                        visited[i][j] = 1;
                        numberOfOnes--;
                    }
                }
            }
        }

        return bfs(grid, q, visited, n , m, numberOfOnes);

    }

    public int bfs(int[][] grid, Queue<Pair> q, int[][] visited, int n , int m, int numberOfOnes){
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Pair currItem = q.remove();
            int currRow = currItem.row;
            int currCol = currItem.col;
            for(int i = 0 ; i < 4; i++){
                int nRow = currRow + delRow[i];
                int nCol = currCol + delCol[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                    q.add(new Pair(nRow, nCol));
                    visited[nRow][nCol] = 1;
                    numberOfOnes--;
                }
            }
        }
        return numberOfOnes;
    }
}

class Pair{
    int row;
    int col;

    public Pair(int r, int c){
        this.row = r ;
        this.col = c;
    }
}
