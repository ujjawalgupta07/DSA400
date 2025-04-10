package DP.Medium;

//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
//
//Note: You can only move either down or right at any point in time.
//
//
//
//Example 1:
//
//
//Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//Output: 7
//Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
//Example 2:
//
//Input: grid = [[1,2,3],[4,5,6]]
//Output: 12
//
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 200
//0 <= grid[i][j] <= 200
import java.util.*;

public class MinimumPathSumMemoization {

    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return findPath(grid, n-1, m-1, dp);
    }

    public int findPath(int[][] grid, int row, int col, int[][] dp){
        if(row == 0 && col == 0){
            return grid[row][col];
        }
        if(row < 0 || col < 0){
            return (int)1e9;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int left = grid[row][col] + findPath(grid, row, col - 1, dp);
        int up = grid[row][col] + findPath(grid, row - 1, col, dp);
        return dp[row][col] = Math.min(left, up);
    }
}
