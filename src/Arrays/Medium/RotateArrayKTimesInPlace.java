package Arrays.Medium;

import java.util.Scanner;

public class RotateArrayKTimesInPlace {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array :: ");
        int n = in.nextInt();
        System.out.println("Enter the rotations :: ");
        int k = in.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements in the array :: ");
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        rotate(a, k);
        System.out.println("The rotated array is : " );
        for(int a_i=0; a_i < n; a_i++){
            System.out.print(a[a_i] + " ");
        }
    }

    public static void rotate(int[] nums, int k) {

        int n = nums.length;
        k %= n;
        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);

    }

    public static void reverseArray(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
