package Arrays.Easy;

import java.util.Scanner;

//Given an array arr[]. The task is to find the largest element and return it.
//
//Examples:
//
//Input: arr[] = [1, 8, 7, 56, 90]
//Output: 90
//Explanation: The largest element of the given array is 90.
//Input: arr[] = [5, 5, 5, 5]
//Output: 5
//Explanation: The largest element of the given array is 5.
//Input: arr[] = [10]
//Output: 10
//Explanation: There is only one element which is the largest.
//Constraints:
//1 <= arr.size()<= 106
//0 <= arr[i] <= 106

public class LargestElementInArray{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int s = 0;
        if (sc.hasNextInt()) {
            s = sc.nextInt();
        }

        int[] arr = new int[s];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < s; i++) {
            if (sc.hasNextInt()) {
                arr[i] = sc.nextInt();
            }
        }

        System.out.println("Largest Element of the array: " + largestElement(arr));


    }

    public static int largestElement(int[] arr) {
        // code here
        int length = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        return max;
    }

}