package Graphs.Medium;

//Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
//
//A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
//
//All the visited cells of the path are 0.
//All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
//The length of a clear path is the number of visited cells of this path.
//
//
//
//Example 1:
//
//
//Input: grid = [[0,1],[1,0]]
//Output: 2
//Example 2:
//
//
//Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
//Output: 4
//Example 3:
//
//Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
//Output: -1
//
//
//Constraints:
//
//n == grid.length
//n == grid[i].length
//1 <= n <= 100
//grid[i][j] is 0 or 1

import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestPathInBinaryMaze {

    public static void main(String[] args) {

    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] != 0 || grid[n - 1][m - 1] != 0){
            return -1;
        }

        if(n == 1 && m == 1 && grid[0][0] == 0){
            return 1;
        }

        int[][] dist = new int[n][m];
        int[] delRows = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] delCols = {-1, 0, 1, 1, 1, 0, -1, -1};

        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0 ; j < m; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Struct> pq = new PriorityQueue<>(
                Comparator.comparingInt(x -> x.step)
        );
        pq.add(new Struct(1, 0, 0));
        dist[0][0] = 0;

        while(!pq.isEmpty()){
            Struct currStruct = pq.remove();
            int currStep = currStruct.step;
            int currRow = currStruct.row;
            int currCol = currStruct.col;

            for(int i = 0 ; i < 8; i++){
                int nRow = currRow + delRows[i];
                int nCol = currCol + delCols[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                        grid[nRow][nCol] == 0){
                    int newSteps = currStep + 1;
                    if(dist[nRow][nCol] > newSteps){
                        dist[nRow][nCol] = newSteps;
                        pq.add(new Struct(newSteps, nRow, nCol));
                    }
                }
            }
        }

        if(dist[n - 1][m - 1] == Integer.MAX_VALUE){
            return -1;
        }

        return dist[n - 1][m - 1];

    }

    static class Struct{
        int step;
        int row;
        int col;

        public Struct(int step, int row, int col){
            this.step = step;
            this.row = row;
            this.col = col;
        }
    }
}
