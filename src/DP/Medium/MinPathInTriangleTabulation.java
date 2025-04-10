package DP.Medium;

//Given a triangle array, return the minimum path sum from top to bottom.
//
//For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
//
//
//
//Example 1:
//
//Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//Output: 11
//Explanation: The triangle looks like:
//   2
//  3 4
// 6 5 7
//4 1 8 3
//The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
//Example 2:
//
//Input: triangle = [[-10]]
//Output: -10
//
//
//Constraints:
//
//1 <= triangle.length <= 200
//triangle[0].length == 1
//triangle[i].length == triangle[i - 1].length + 1
//-104 <= triangle[i][j] <= 104

import java.util.Arrays;
import java.util.List;

public class MinPathInTriangleTabulation {
    public static void main(String[] args) {

    }

    //SC: O(n2)
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] arr : dp){
            Arrays.fill(arr, 0);
        }
        for(int j = 0; j < n; j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2 ; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size() ; j++){
                int first = triangle.get(i).get(j) + dp[i+1][j];
                int second = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(first, second);
            }
        }
        return dp[0][0];
    }

    //Space Optimisation
    //SC:: O(n)
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        Arrays.fill(dp, 0);

        for(int j = 0; j < n; j++){
            dp[j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2 ; i >= 0; i--){
            int[] temp = new int[n];
            for(int j = 0; j < triangle.get(i).size() ; j++){
                int first = triangle.get(i).get(j) + dp[j];
                int second = triangle.get(i).get(j) + dp[j+1];
                temp[j] = Math.min(first, second);;
            }
            dp = temp;
        }
        return dp[0];
    }
}
