package Strings.Easy;

//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
//
//
//
//Example 1:
//
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
//
//
//Constraints:
//
//1 <= strs.length <= 200
//0 <= strs[i].length <= 200
//strs[i] consists of only lowercase English letters if it is non-empty.

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        StringBuilder ans = new StringBuilder();
        String smallestWord = "";
        int smallestLength = Integer.MAX_VALUE;
        int n = strs.length;
        for(int i = 0 ; i < n; i++){
            if(strs[i].length() < smallestLength){
                smallestLength = strs[i].length();
                smallestWord = strs[i];
            }
        }

        for(int i = 0 ; i < n; i++){
            String currString = strs[i];
            if(currString != smallestWord){
                for(int j = 0 ; j < smallestLength; j++){
                    if(currString.charAt(j) != smallestWord.charAt(j)){
                        smallestWord = smallestWord.substring(0,j);
                        smallestLength = smallestWord.length();
                    }
                }
            }
        }

        return smallestWord;

    }
}
