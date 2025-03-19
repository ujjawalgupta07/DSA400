package Graphs.Hard;

import java.util.*;

//A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
//
//Every adjacent pair of words differs by a single letter.
//Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
//sk == endWord
//Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
//
//
//
//Example 1:
//
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//Output: 5
//Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
//Example 2:
//
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
//Output: 0
//Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
//
//
//Constraints:
//
//1 <= beginWord.length <= 10
//endWord.length == beginWord.length
//1 <= wordList.length <= 5000
//wordList[i].length == beginWord.length
//beginWord, endWord, and wordList[i] consist of lowercase English letters.
//beginWord != endWord
//All the words in wordList are unique.
public class WordLadderI {

    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> set = new HashSet<>();
            int seq = 0;
            for(int i = 0 ; i < wordList.size(); i++){
                set.add(wordList.get(i));
            }

            if (!set.contains(endWord)) {
                return 0;
            }

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(beginWord, 1));

            while(!q.isEmpty()){
                Pair currPair = q.remove();
                String currWord = currPair.word;
                int currSeqDis = currPair.sequenceDistance;
                if(currWord.equals(endWord)){
                    return currSeqDis;
                }

                int length = currWord.length();
                for(int i = 0 ; i < length; i++){
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        char replacedCharArray[] = currWord.toCharArray();
                        replacedCharArray[i] = ch;
                        String replacedWordString = new String(replacedCharArray);
                        if(set.contains(replacedWordString)){
                            set.remove(replacedWordString);
                            q.add(new Pair(replacedWordString, currSeqDis + 1));
                        }
                    }
                }
            }
            return seq;
        }
    }

    static class Pair{
        String word;
        int sequenceDistance;

        public Pair(String word, int seqDis){
            this.word = word;
            this.sequenceDistance = seqDis;
        }
    }
}
