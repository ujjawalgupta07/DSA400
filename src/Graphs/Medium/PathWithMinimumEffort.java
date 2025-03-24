package Graphs.Medium;

//You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
//
//A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
//
//Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
//
//
//
//Example 1:
//
//
//
//Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
//Output: 2
//Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
//This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
//Example 2:
//
//
//
//Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
//Output: 1
//Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
//Example 3:
//
//
//Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//Output: 0
//Explanation: This route does not require any effort.
//
//
//Constraints:
//
//rows == heights.length
//columns == heights[i].length
//1 <= rows, columns <= 100
//1 <= heights[i][j] <= 106

import java.util.*;

public class PathWithMinimumEffort {

    public static void main(String[] args) {

    }

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] efforts = new int[n][m];
        for(int[] it : efforts){
            Arrays.fill(it, Integer.MAX_VALUE);
        }

        Queue<Struct> q = new LinkedList<>();
        q.add(new Struct(0, 0, 0));
        efforts[0][0] = 0;

        int[] delRows = {-1, 0, 1, 0};
        int[] delCols = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Struct currStruct = q.remove();
            int currEffort = currStruct.effort;
            int currRow = currStruct.row;
            int currCol = currStruct.col;

            for(int i = 0 ; i < 4; i++){
                int nRow = currRow + delRows[i];
                int nCol = currCol + delCols[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                    int effort = Math.max(currEffort, Math.abs(heights[currRow][currCol] - heights[nRow][nCol]));
                    if(effort < efforts[nRow][nCol]){
                        efforts[nRow][nCol] = effort;
                        q.add(new Struct(effort, nRow, nCol));
                    }
                }
            }
        }

        return efforts[n - 1][m - 1];
    }

    static class Struct{
        int effort;
        int row;
        int col;

        public Struct(int effort, int row, int col){
            this.effort = effort;
            this.row = row;
            this.col = col;
        }
    }
}
