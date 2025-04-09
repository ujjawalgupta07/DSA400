package DP.Easy;

import java.util.Scanner;

public class FibonacciSeriesMemoization {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number :: ");
        int n = scanner.nextInt();
        int[] dp = new int[n+1];
        int ans = fibo(n, dp);
        System.out.println("Answer :: " + ans);
    }

    private static int fibo(int n, int[] dp) {
        if(n <= 1){
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        return dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
    }
}
