package Arrays.Easy;

//Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.
//
//Note: The second largest element should not be equal to the largest element.
//
//Examples:
//
//Input: arr[] = [12, 35, 1, 10, 34, 1]
//Output: 34
//Explanation: The largest element of the array is 35 and the second largest element is 34.
//Input: arr[] = [10, 5, 10]
//Output: 5
//Explanation: The largest element of the array is 10 and the second largest element is 5.
//Input: arr[] = [10, 10, 10]
//Output: -1
//Explanation: The largest element of the array is 10 and the second largest element does not exist.
//Constraints:
//2 ≤ arr.size() ≤ 105
//1 ≤ arr[i] ≤ 105

import java.util.Scanner;

public class SecondLargestElementInArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements in the array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("The second largest element in the array is :: " + getSecondLargest(arr));

    }

    public static int getSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        // Code Here
        int length = arr.length;
        for(int i = 0 ; i < length; i++){
            if(arr[i] > largest){
                int temp = largest;
                largest = arr[i];
                if(temp > secondLargest)
                    secondLargest = temp;
            }
            else if(arr[i] < largest && arr[i] > secondLargest){
                secondLargest = arr[i];
            }
        }
        if(largest == Integer.MIN_VALUE || secondLargest == Integer.MIN_VALUE){
            return -1;
        }
        return secondLargest;
    }
}
