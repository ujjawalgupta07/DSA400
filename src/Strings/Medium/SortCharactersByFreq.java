package Strings.Medium;

import java.util.*;

public class SortCharactersByFreq {

    public static String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int n = s.length();
        StringBuilder ans = new StringBuilder();

        // Step 1: Build the frequency map
        for (int i = 0; i < n; i++) {
            char currChar = s.charAt(i);
            freqMap.put(currChar, freqMap.getOrDefault(currChar, 0) + 1);
        }

        // Step 2: Convert the HashMap entries to a list
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freqMap.entrySet());

        // Step 3: Sort the list using a comparator that compares the values
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // Step 4: Build the result string directly from the sorted list
        for (Map.Entry<Character, Integer> entry : list) {
            char key = entry.getKey();
            int value = entry.getValue();
            while (value != 0) {
                ans.append(key);
                value--;
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(frequencySort(s));
    }
}

