class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // Build frequency map of all words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.merge(word, 1, Integer::sum);
        }
      
        List<Integer> result = new ArrayList<>();
        int stringLength = s.length();
        int wordArrayLength = words.length;
        int wordLength = words[0].length();
      
        // Try all possible starting positions within a word length
        // This ensures we check all possible alignments
        for (int startPos = 0; startPos < wordLength; startPos++) {
            int left = startPos;
            int right = startPos;
            Map<String, Integer> currentWindowCount = new HashMap<>();
          
            // Slide the window through the string
            while (right + wordLength <= stringLength) {
                // Extract the next word from the right side of window
                String currentWord = s.substring(right, right + wordLength);
                right += wordLength;
              
                // If current word is not in our target words, reset the window
                if (!wordCount.containsKey(currentWord)) {
                    currentWindowCount.clear();
                    left = right;
                    continue;
                }
              
                // Add current word to our window count
                currentWindowCount.merge(currentWord, 1, Integer::sum);
              
                // Shrink window from left if we have too many occurrences of current word
                while (currentWindowCount.get(currentWord) > wordCount.get(currentWord)) {
                    String leftWord = s.substring(left, left + wordLength);
                    // Decrease count and remove if it becomes zero
                    if (currentWindowCount.merge(leftWord, -1, Integer::sum) == 0) {
                        currentWindowCount.remove(leftWord);
                    }
                    left += wordLength;
                }
              
                // Check if current window contains exactly all words
                if (right - left == wordArrayLength * wordLength) {
                    result.add(left);
                }
            }
        }
      
        return result;
    }
}