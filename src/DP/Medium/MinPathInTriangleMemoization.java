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

import java.util.*;

public class MinPathInTriangleMemoization {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(0).size();
        int[][] dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return findPath(triangle, 0, 0, dp, n, m);
    }

    public int findPath(List<List<Integer>> triangle, int i, int j, int[][] dp, int n, int m) {
        if (i == n - 1) {
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int first = triangle.get(i).get(j) + findPath(triangle, i + 1, j, dp, n, m);
        int second = triangle.get(i).get(j) + findPath(triangle, i + 1, j + 1, dp, n, m);

        return dp[i][j] = Math.min(first, second);

    }
}
