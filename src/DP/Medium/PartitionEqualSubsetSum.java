package DP.Medium;

//Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
//
//
//
//Example 1:
//
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
//Example 2:
//
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
//
//
//Constraints:
//
//1 <= nums.length <= 200
//1 <= nums[i] <= 100
import java.util.*;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i = 0 ; i < n; i++){
            totalSum += nums[i];
        }

        if(totalSum % 2 != 0){
            return false;
        }

        int[][] dp = new int[201][totalSum + 1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return subsetSum(nums, n-1, totalSum/2, dp);
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
