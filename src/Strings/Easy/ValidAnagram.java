package Strings.Easy;

//Given two strings s and t, return true if t is an
//anagram of s, and false otherwise.
// An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.
//
//
//Example 1:
//
//Input: s = "anagram", t = "nagaram"
//
//Output: true
//
//Example 2:
//
//Input: s = "rat", t = "car"
//
//Output: false
//
//
//
//Constraints:
//
//1 <= s.length, t.length <= 5 * 104
//s and t consist of lowercase English letters.

import java.util.HashMap;
import java.util.Scanner;

public class ValidAnagram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first String :: ");
        String s = scanner.nextLine();
        System.out.println("Enter second String :: ");
        String t = scanner.nextLine();
        System.out.println("IS anagram :: " + isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int sLength = s.length();
        int tLength = t.length();
        if(sLength != tLength){
            return false;
        }

        for(int i = 0 ; i < sLength; i++){
            char currChar = s.charAt(i);
            if(freqMap.containsKey(currChar))
                freqMap.put(currChar, freqMap.get(currChar)+1);
            else
                freqMap.put(currChar, 1);
        }

        for(int i = 0 ; i < sLength; i++){
            char currChar = t.charAt(i);
            if(freqMap.containsKey(currChar))
                freqMap.put(currChar, freqMap.get(currChar)-1);
            else
                return false;
        }

        for(int i = 0 ; i < sLength; i++){
            char currChar = s.charAt(i);
            if(freqMap.containsKey(currChar)){
                if(freqMap.get(currChar) != 0){
                    return false;
                }
            }
        }
        return true;
    }
}
