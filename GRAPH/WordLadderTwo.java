import java.util.*;

class WordLadderTwoALlTransformations {

    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
            "des",
            "der",
            "dfr",
            "dgt",
            "dfs"
        };

        Solution obj = new Solution();
        List<List<String>> transformations = obj.wordLadderTransformations(startWord, targetWord, wordList);

        // Print all transformations
        for (List<String> transformation : transformations) {
            System.out.println(transformation);
        }
    }
}

class Solution {
    public List<List<String>> wordLadderTransformations(String startWord, String targetWord, String[] wordList) {
        List<List<String>> result = new ArrayList<>();
        Queue<List<String>> q = new LinkedList<>();

        // Initialize the queue with the startWord as the first transformation path
        q.add(Arrays.asList(startWord));

        // Create a set for quick lookup of wordList
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        wordSet.remove(startWord);

        while (!q.isEmpty()) {
            int size = q.size();

            // Track words used in this level of BFS
            Set<String> usedWords = new HashSet<>();

            for (int i = 0; i < size; i++) {
                List<String> path = q.poll();
                String word = path.get(path.size() - 1);

                // If we find the target word, add the current path to the result
                if (word.equals(targetWord)) {
                    result.add(new ArrayList<>(path));
                }

                // Try all transformations of the current word
                for (int j = 0; j < word.length(); j++) {
                    char[] charArray = word.toCharArray();

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        charArray[j] = ch;
                        String transformedWord = new String(charArray);

                        if (wordSet.contains(transformedWord)) {
                            // Mark the word to be removed at the end of this level
                            usedWords.add(transformedWord);

                            // Add the new transformation path to the queue
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(transformedWord);
                            q.add(newPath);
                        }
                    }
                }
            }

            // Remove all words used in this BFS level from the set
            for (String word : usedWords) {
                wordSet.remove(word);
            }
        }

        return result;
    }
}
