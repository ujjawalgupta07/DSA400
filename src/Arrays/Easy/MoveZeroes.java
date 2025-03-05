package Arrays.Easy;

//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//Note that you must do this in-place without making a copy of the array.
//
//
//
//Example 1:
//
//Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
//Example 2:
//
//Input: nums = [0]
//Output: [0]
//
//
//Constraints:
//
//1 <= nums.length <= 104
//-231 <= nums[i] <= 231 - 1
//

import java.util.Scanner;

public class MoveZeroes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array ::");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements in the array ::");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Original Array : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Array after moving zeroes in end :: ");
        moveZeroes(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int first = 0 ;
        int second = 1;
        if(nums.length == 1){
            return;
        }
        while(first < second && second < nums.length){
            if(nums[first] == 0 && nums[second] != 0){
                int temp = nums[first];
                nums[first] = nums[second];
                nums[second] = temp;
                first++;
                second++;
            }
            else if(nums[first] == 0 && nums[second] == 0){
                second++;
            }
            else {
                first++;
                second++;
            }
        }
    }
}
