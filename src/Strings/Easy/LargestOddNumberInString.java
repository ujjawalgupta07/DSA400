package Strings.Easy;

//You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
//
//A substring is a contiguous sequence of characters within a string.
//
//
//
//Example 1:
//
//Input: num = "52"
//Output: "5"
//Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
//Example 2:
//
//Input: num = "4206"
//Output: ""
//Explanation: There are no odd numbers in "4206".
//Example 3:
//
//Input: num = "35427"
//Output: "35427"
//Explanation: "35427" is already an odd number.
//
//
//Constraints:
//
//1 <= num.length <= 105
//num only consists of digits and does not contain any leading zeros.

import java.util.Scanner;

public class LargestOddNumberInString {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string :: ");
        String s = sc.nextLine();
        System.out.println("Largest odd number in the string is :: " + largestOddNumber(s));
    }

    public static String largestOddNumber(String num) {
        StringBuilder ans = new StringBuilder();
        int idx = -1;
        for(int i = num.length() - 1; i >= 0; i--){
            int currValue = (int)(num.charAt(i));
            if(currValue % 2 != 0){
                idx = i;
                break;
            }
        }

        for(int i = 0 ; i <= idx; i++){
            ans.append(num.charAt(i));
        }

        return ans.toString();
    }
}
