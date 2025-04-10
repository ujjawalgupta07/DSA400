package DP.Medium;

//Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
//
//A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
//
//
//
//Example 1:
//
//
//Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
//Output: 13
//Explanation: There are two falling paths with a minimum sum as shown.
//Example 2:
//
//
//Input: matrix = [[-19,57],[-40,-5]]
//Output: -59
//Explanation: The falling path with a minimum sum is shown.
//
//
//Constraints:
//
//n == matrix.length == matrix[i].length
//1 <= n <= 100
//-100 <= matrix[i][j] <= 100

public class MinimumFallingPathVariableStartingEndingPoints {

    public static void main(String[] args) {

    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++)
        {
            dp[0][i] = matrix[0][i];
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int up = matrix[i][j] + dp[i - 1][j];
                int ld = Integer.MAX_VALUE,rd = Integer.MAX_VALUE;
                if(j<n-1)
                {
                    ld = matrix[i][j] + dp[i-1][j+1];
                }
                if( j>=1)
                {
                    rd = matrix[i][j] + dp[i-1][j-1];
                }
                dp[i][j] = Math.min(up,Math.min(ld,rd));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int num:dp[n-1])
        {
            ans = Math.min(num,ans);
        }
        return ans;
    }
}
