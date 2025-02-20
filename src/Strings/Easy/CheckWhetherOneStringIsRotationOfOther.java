package Strings.Easy;

//Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
//
//A shift on s consists of moving the leftmost character of s to the rightmost position.
//
//For example, if s = "abcde", then it will be "bcdea" after one shift.
//
//
//Example 1:
//
//Input: s = "abcde", goal = "cdeab"
//Output: true
//Example 2:
//
//Input: s = "abcde", goal = "abced"
//Output: false
//
//
//Constraints:
//
//1 <= s.length, goal.length <= 100
//s and goal consist of lowercase English letters.

import java.util.Scanner;

public class CheckWhetherOneStringIsRotationOfOther {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = scanner.nextLine();
        System.out.println("Enter the goal string: ");
        String goal = scanner.nextLine();
        boolean ans = rotateString(s, goal);
        System.out.println(ans);
    }

    // public boolean rotateString(String s, String goal) {
    //     if (s.length() != goal.length()) {
    //         return false;
    //     }
    //     return (s + s).contains(goal);
    // }

    public static boolean rotateString(String s, String goal) {

        if(s.equals(goal)){
            return true;
        }
        StringBuilder rotatedString = new StringBuilder(s);
        int n = s.length();
        for(int i = 0 ; i < n - 1 ; i++){
            char toBeAppendedChar = s.charAt(i);
            rotatedString = new StringBuilder(rotatedString.substring(1, n));
            rotatedString.append(toBeAppendedChar);
            if(rotatedString.toString().equals(goal)){
                return true;
            }
        }

        return false;
    }
}
