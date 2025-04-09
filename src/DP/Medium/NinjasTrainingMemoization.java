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
import java.util.*;

public class NinjasTrainingMemoization {

    public static void main(String[] args) {

    }

    public int maximumPoints(int arr[][]) {
        // code here
        int days = arr.length;
        int[][] dp = new int[days + 1][4];
        for(int i = 0; i < days; i++){
            Arrays.fill(dp[i], -1);
        }
        return calcMaxPoints(arr, days - 1, 3, dp);
    }

    public int calcMaxPoints(int[][] arr, int day, int task, int[][] dp){
        if(day == 0){
            int maxi = 0;
            for(int i = 0 ; i < 3; i++){
                if(i != task){
                    maxi = Math.max(maxi, arr[0][i]);
                }
            }
            return maxi;
        }

        if(dp[day][task] != -1){
            return dp[day][task];
        }

        int max = 0;
        for(int i = 0; i < 3; i++){
            if(i != task)
                max = Math.max(max, arr[day][i] + calcMaxPoints(arr, day - 1, i, dp));
        }

        return dp[day][task] = max;
    }
}
