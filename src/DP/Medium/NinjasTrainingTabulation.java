package DP.Medium;

//Geek is going for a training program for n days. He can perform any of these activities: Running, Fighting, and Learning Practice. Each activity has some point on each day. As Geek wants to improve all his skills, he can't do the same activity on two consecutive days. Given a 2D array arr[][] of size n where arr[i][0], arr[i][1], and arr[i][2] represent the merit points for Running, Fighting, and Learning on the i-th day, determine the maximum total merit points Geek can achieve .
//
//Example:
//
//Input: arr[]= [[1, 2, 5], [3, 1, 1], [3, 3, 3]]
//Output: 11
//Explanation: Geek will learn a new move and earn 5 point then on second day he will do running and earn 3 point and on third day he will do fighting and earn 3 points so, maximum merit point will be 11.
//Input: arr[]= [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
//Output: 6
//Explanation: Geek can perform any activity each day while adhering to the constraints, in order to maximize his total merit points as 6.
//Input: arr[]= [[4, 2, 6]]
//Output: 6
//Explanation: Geek will learn a new move to make his merit points as 6.
//Constraint:
//1 <=  n <= 105
//1 <=  arr[i][j] <= 100

import java.util.Arrays;

public class NinjasTrainingTabulation {

    public static void main(String[] args) {

    }

    public int maximumPoints(int arr[][]) {
        // code here
        int days = arr.length;
        int[][] dp = new int[days + 1][3];
        for(int i = 0; i < days; i++){
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);

        for(int day = 1; day < days; day++){
            for(int next = 0; next < 3; next++){
                int maxi = 0;
                for(int task = 0; task < 3; task++){
                    if(next != task){
                        int points = arr[day][task] + dp[day - 1][task];
                        maxi = Math.max(maxi, points);
                    }
                }
                dp[day][next] = maxi;
            }
        }
        return Math.max(dp[days - 1][0], Math.max(dp[days - 1][1], dp[days - 1][2]));
    }
}
