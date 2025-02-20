package Strings.Easy;

//Given two strings s and t, determine if they are isomorphic.
//
//Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
//
//
//
//Example 1:
//
//Input: s = "egg", t = "add"
//
//Output: true
//
//Explanation:
//
//The strings s and t can be made identical by:
//
//Mapping 'e' to 'a'.
//Mapping 'g' to 'd'.
//Example 2:
//
//Input: s = "foo", t = "bar"
//
//Output: false
//
//Explanation:
//
//The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.
//
//Example 3:
//
//Input: s = "paper", t = "title"
//
//Output: true
//
//
//
//Constraints:
//
//1 <= s.length <= 5 * 104
//t.length == s.length
//s and t consist of any valid ascii character.

import java.util.HashMap;
import java.util.Scanner;

public class IsomorphicStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String s = scanner.nextLine();
        System.out.println("Enter second string: ");
        String t = scanner.nextLine();
        boolean ans = isIsomorphic(s,t);
        if(ans)
            System.out.println("Strings are isomorphic");
        else{
            System.out.println("Strings are not isomorphic");
        }

    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> charMapping = new HashMap<>();
        int n = s.length();
        for(int idx = 0 ; idx < n; idx++){
            char sChar = s.charAt(idx);
            char tChar = t.charAt(idx);

            if(charMapping.containsKey(sChar)){
                char currMapping = charMapping.get(sChar);
                if(currMapping != tChar){
                    return false;
                }
            }
            else if(charMapping.containsValue(tChar)){
                return false;
            }
            else{
                charMapping.put(sChar, tChar);
            }
        }

        return true;
    }
}
