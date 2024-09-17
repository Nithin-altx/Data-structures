import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Combine both sentences into one
        String combined = s1 + " " + s2;
        
        // Split the combined string into words
        String[] words = combined.split(" ");
        
        // Create a map to count the frequency of each word
        Map<String, Integer> wordCount = new HashMap<>();
        
        // Count each word's frequency
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Collect words that appear exactly once
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        
        // Convert the list to an array and return
        return result.toArray(new String[0]);
    }
}
