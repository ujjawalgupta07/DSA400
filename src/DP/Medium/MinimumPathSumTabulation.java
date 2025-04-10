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

import java.util.Arrays;

public class MinimumPathSumTabulation {

    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = grid[0][0];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                int right = grid[i][j];
                if(j > 0)
                    right = right + dp[i][j - 1];
                else{
                    right += (int)1e9;
                }
                int down = grid[i][j];
                if(i > 0)
                    down = down + dp[i - 1][j];
                else{
                    down += (int)1e9;
                }
                dp[i][j] = Math.min(right, down);
            }
        }

        return dp[n-1][m-1];
    }
}
