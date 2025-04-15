package DP.Medium;

//Given an array arr of n integers and an integer target, determine if there is a subset of the given array with a sum equal to the given target.
//
//
//Examples:
//Input: arr = [1, 2, 7, 3], target = 6
//
//Output: True
//
//Explanation: There is a subset (1, 2, 3) with sum 6.
//
//Input: arr = [2, 3, 5], target = 6
//
//Output: False
//
//Explanation: There is no subset with sum 6.
import java.util.*;

public class SubsetSumEqualsToTarget {

    public static void main(String[] args) {

    }

    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }

        return subsetSum(arr, n-1, target, dp);
    }

    private boolean subsetSum(int[] nums, int ind, int target, int[][] dp){
        if(target == 0){
            return true;
        }
        if(ind == 0){
            return nums[ind] == target;
        }

        if(dp[ind][target] != -1){
            return dp[ind][target] == 1;
        }

        boolean notTake = subsetSum(nums, ind - 1, target, dp);
        boolean take = false;
        if(target >= nums[ind]){
            take = subsetSum(nums, ind - 1, target - nums[ind], dp);
        }

        dp[ind][target] = 0;
        if(take || notTake){
            dp[ind][target] = 1;
        }
        return take || notTake;
    }
}
