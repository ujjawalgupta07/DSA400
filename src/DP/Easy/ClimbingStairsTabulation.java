package DP.Easy;

public class ClimbingStairsTabulation {

    public static void main(String[] args) {
        int n = 3;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println("Answer :: " + dp[n]);
    }

    //Space Optimisation
    public int climbStairs(int n) {
        int prev2 = 1;
        int prev = 1;
        int ans = 0;
        for(int i = 2; i <= n ; i++){
            ans = prev + prev2;
            prev2 = prev;
            prev = ans;
        }
        return ans;
    }
}
