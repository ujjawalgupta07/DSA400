package Arrays.Medium;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
//
//
//
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
//
//
//Constraints:
//
//2 <= nums.length <= 104
//-109 <= nums[i] <= 109
//-109 <= target <= 109
//Only one valid answer exists.
//
//
//Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements in the array");
        for(int i=0; i<n; i++){
            int ele = sc.nextInt();
            arr[i] = ele;
        }
        System.out.println("Enter target :: ");
        int target = sc.nextInt();

        int[] indices = twoSum(arr, target);
        for(int i = 0; i < indices.length; i++){
            System.out.println(indices[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int length = nums.length;
        int[] indices = new int[2];
        for(int i = 0 ;  i < length; i++){
            int key = target - nums[i];
            if(hm.containsKey(key) && hm.get(key) != i){
                indices[0] = hm.get(key);
                indices[1] = i;
            }
            else{
                hm.put(nums[i], i);
            }
        }

        return indices;
    }
}
