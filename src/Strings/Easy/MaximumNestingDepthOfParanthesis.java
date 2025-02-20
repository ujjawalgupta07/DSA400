package Strings.Easy;

//Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.
//
//
//
//Example 1:
//
//Input: s = "(1+(2*3)+((8)/4))+1"
//
//Output: 3
//
//Explanation:
//
//Digit 8 is inside of 3 nested parentheses in the string.
//
//Example 2:
//
//Input: s = "(1)+((2))+(((3)))"
//
//Output: 3
//
//Explanation:
//
//Digit 3 is inside of 3 nested parentheses in the string.
//
//Example 3:
//
//Input: s = "()(())((()()))"
//
//Output: 3
//
//
//
//Constraints:
//
//1 <= s.length <= 100
//s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
//It is guaranteed that parentheses expression s is a VPS.

import java.util.Scanner;

public class MaximumNestingDepthOfParanthesis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = sc.nextLine();
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {
        int currDepth = 0;
        int maxDepth = 0;
        int n = s.length();

        for(int i =0 ; i < n; i++){
            if(s.charAt(i) == '('){
                currDepth++;
                if(currDepth > maxDepth){
                    maxDepth = currDepth;
                }
            }
            else if(s.charAt(i) == ')'){
                currDepth--;
            }
        }
        return maxDepth;
    }
}
