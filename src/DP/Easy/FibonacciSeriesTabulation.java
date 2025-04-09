package DP.Easy;

import java.util.*;

public class FibonacciSeriesTabulation {

    //TC :: O(N)
    //SC :: O(N)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number :: ");
        int n = scanner.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println("Answer :: " + dp[n]);
        System.out.println(fibo(n));
    }

    //Optimising Space complexity
    //SC :: (1)
    //TC :: O(N)
    public static int fibo(int n){
        int prev2 = 0;
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
