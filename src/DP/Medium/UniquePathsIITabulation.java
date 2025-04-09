package DP.Medium;

//You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
//
//An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
//
//Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
//
//The testcases are generated so that the answer will be less than or equal to 2 * 109.
//
//
//
//Example 1:
//
//
//Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//Output: 2
//Explanation: There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
//Example 2:
//
//
//Input: obstacleGrid = [[0,1],[0,0]]
//Output: 1
//
//
//Constraints:
//
//m == obstacleGrid.length
//n == obstacleGrid[i].length
//1 <= m, n <= 100
//obstacleGrid[i][j] is 0 or 1.
import java.util.*;

public class UniquePathsIITabulation {

    public static void main(String[] args) {

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(n == m && n == 1 && obstacleGrid[0][0] == 0){
            return 1;
        }
        if(obstacleGrid[0][0] == 1){
            return 0;
        }

        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m; i++){
            Arrays.fill(dp[i], 0);
        }

        dp[0][0] = 1;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                if(i > 0 && obstacleGrid[i][j] == 0)
                    dp[i][j] += dp[i-1][j];
                if(j > 0 && obstacleGrid[i][j] == 0)
                    dp[i][j] += dp[i][j-1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
