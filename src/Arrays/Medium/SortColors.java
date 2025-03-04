package Arrays.Medium;

//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//You must solve this problem without using the library's sort function.
//
//
//
//Example 1:
//
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
//Example 2:
//
//Input: nums = [2,0,1]
//Output: [0,1,2]
//
//
//Constraints:
//
//n == nums.length
//1 <= n <= 300
//nums[i] is either 0, 1, or 2.

import java.util.Scanner;

public class SortColors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sortColors(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void sortColors(int[] nums) {
        int zeroes = 0;
        int ones = 0;
        int twos = 0;

        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == 0){
                zeroes++;
            }
            else if(nums[i] == 1){
                ones++;
            }
            else{
                twos++;
            }
        }

        int ctr = 0;
        for(int i = 0 ; i < zeroes; i++){
            nums[ctr] = 0;
            ctr++;
        }
        for(int i = 0 ; i < ones; i++){
            nums[ctr] = 1;
            ctr++;
        }
        for(int i = 0 ; i < twos; i++){
            nums[ctr] = 2;
            ctr++;
        }
    }
}
