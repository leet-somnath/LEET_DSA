import java.util.*;

class Trie {
    static class Node {
        Node[] links;
        int cntEndWith;
        int cntPrefix;

        Node() {
            links = new Node[26];
            cntEndWith = 0;
            cntPrefix = 0;
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        void increaseEnd() {
            cntEndWith++;
        }

        void increasePrefix() {
            cntPrefix++;
        }

        void deleteEnd() {
            cntEndWith--;
        }

        void reducePrefix() {
            cntPrefix--;
        }
    }

    Node root;

    Trie() {
        root = new Node();
    }

    void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.cntEndWith > 0;
    }

    boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }

    String searchRoot(String word) {
        Node node = root;
        StringBuilder prefix = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (node.containsKey(c)) {
                node = node.get(c);
                prefix.append(c);
                if (node.cntEndWith > 0) {
                    return prefix.toString();
                }
            } else {
                break;
            }
        }
        return null;
    }
}

public class TrieProblems {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Problem 1: Implement a Trie (Prefix Tree)
        trie.insert("apple");
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("app")); // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app")); // true

        // Problem 2: Longest Word in Dictionary
        String[] words = { "w", "wo", "wor", "worl", "world" };
        System.out.println(longestWord(words)); // world

        // Problem 3: Replace Words
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary, sentence)); // the cat was rat by the bat

        // Problem 4: Word Search II
        char[][] board = {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };
        String[] searchWords = { "oath", "pea", "eat", "rain" };
        System.out.println(findWords(board, searchWords)); // [oath, eat]

        // Problem 5: Design Add and Search Words Data Structure
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // false
        System.out.println(wordDictionary.search("bad")); // true
        System.out.println(wordDictionary.search(".ad")); // true
        System.out.println(wordDictionary.search("b..")); // true

        // Problem 6: Maximum XOR of Two Numbers in an Array
        int[] nums = { 3, 10, 5, 25, 2, 8 };
        System.out.println(findMaximumXOR(nums)); // 28

        // Problem 7: Palindrome Pairs
        String[] palindromeWords = { "bat", "tab", "cat" };
        System.out.println(palindromePairs(palindromeWords)); // [[0, 1], [1, 0]]

        // Problem 8: Stream of Characters
        StreamChecker streamChecker = new StreamChecker(new String[] { "cd", "f", "kl" });
        System.out.println(streamChecker.query('a')); // false
        System.out.println(streamChecker.query('b')); // false
        System.out.println(streamChecker.query('c')); // false
        System.out.println(streamChecker.query('d')); // true

        // Problem 9: Search Suggestions System
        String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String searchWord = "mouse";
        System.out.println(suggestedProducts(products, searchWord)); // [[mobile, moneypot, monitor], [mobile, moneypot, monitor], [mouse, mousepad], [mouse, mousepad], [mouse, mousepad]]

        // Problem 10: Concatenated Words
        String[] concatWords = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
        System.out.println(findAllConcatenatedWordsInADict(concatWords)); // [catsdogcats, dogcatsdog, ratcatdogcat]
    }

    // Problem 2: Longest Word in Dictionary
    public static String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        String longest = "";
        for (String word : words) {
            if (isBuilt(word, trie) && (word.length() > longest.length() || (word.length() == longest.length() && word.compareTo(longest) < 0))) {
                longest = word;
            }
        }
        return longest;
    }

    private static boolean isBuilt(String word, Trie trie) {
        Trie.Node node = trie.root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i)) || node.get(word.charAt(i)).cntEndWith == 0) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return true;
    }

    // Problem 3: Replace Words
    public static String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String root : dictionary) {
            trie.insert(root);
        }
        StringBuilder result = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            String replacement = trie.searchRoot(word);
            result.append(replacement != null ? replacement : word).append(" ");
        }
        return result.toString().trim();
    }

    // Problem 4: Word Search II
    public static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, visited, i, j, "", trie, result);
            }
        }
        return new ArrayList<>(result);
    }

    private static void dfs(char[][] board, boolean[][] visited, int i, int j, String str, Trie trie, Set<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        str += board[i][j];
        if (!trie.startsWith(str)) {
            return;
        }
        if (trie.search(str)) {
            result.add(str);
        }
        visited[i][j] = true;
        dfs(board, visited, i - 1, j, str, trie, result);
        dfs(board, visited, i + 1, j, str, trie, result);
        dfs(board, visited, i, j - 1, str, trie, result);
        dfs(board, visited, i, j + 1, str, trie, result);
        visited[i][j] = false;
    }

    // Problem 5: Design Add and Search Words Data Structure
    static class WordDictionary {
        private Trie.Node root;

        public WordDictionary() {
            root = new Trie.Node();
        }

        public void addWord(String word) {
            Trie.Node node = root;
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    node.put(ch, new Trie.Node());
                }
                node = node.get(ch);
            }
            node.increaseEnd();
        }

        public boolean search(String word) {
            return searchHelper(word, 0, root);
        }

        private boolean searchHelper(String word, int index, Trie.Node node) {
            if (index == word.length()) {
                return node.cntEndWith > 0;
            }
            char ch = word.charAt(index);
            if (ch == '.') {
                for (Trie.Node child : node.links) {
                    if (child != null && searchHelper(word, index + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!node.containsKey(ch)) {
                    return false;
                }
                return searchHelper(word, index + 1, node.get(ch));
            }
        }
    }

    // Problem 6: Maximum XOR of Two Numbers in an Array
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    public static int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        int max = 0;
        for (int num : nums) {
            TrieNode node = root;
            TrieNode xorNode = root;
            int curXor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
                if (xorNode.children[1 - bit] != null) {
                    curXor = (curXor << 1) | 1;
                    xorNode = xorNode.children[1 - bit];
                } else {
                    curXor = (curXor << 1);
                    xorNode = xorNode.children[bit];
                }
            }
            max = Math.max(max, curXor);
        }
        return max;
    }

    // Problem 7: Palindrome Pairs
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                if (isPalindrome(left)) {
                    String revRight = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(revRight) && map.get(revRight) != i) {
                        result.add(Arrays.asList(map.get(revRight), i));
                    }
                }
                if (isPalindrome(right) && right.length() != 0) {
                    String revLeft = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(revLeft) && map.get(revLeft) != i) {
                        result.add(Arrays.asList(i, map.get(revLeft)));
                    }
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    // Problem 8: Stream of Characters
    static class StreamChecker {
        private Trie.Node root;
        private StringBuilder sb;

        public StreamChecker(String[] words) {
            root = new Trie.Node();
            sb = new StringBuilder();
            for (String word : words) {
                Trie.Node node = root;
                for (int i = word.length() - 1; i >= 0; i--) {
                    char ch = word.charAt(i);
                    if (!node.containsKey(ch)) {
                        node.put(ch, new Trie.Node());
                    }
                    node = node.get(ch);
                }
                node.increaseEnd();
            }
        }

        public boolean query(char letter) {
            sb.append(letter);
            Trie.Node node = root;
            for (int i = sb.length() - 1; i >= 0; i--) {
                char ch = sb.charAt(i);
                if (!node.containsKey(ch)) {
                    return false;
                }
                node = node.get(ch);
                if (node.cntEndWith > 0) {
                    return true;
                }
            }
            return false;
        }
    }

    // Problem 9: Search Suggestions System
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        List<List<String>> result = new ArrayList<>();
        Trie.Node node = trie.root;
        for (char c : searchWord.toCharArray()) {
            if (node.containsKey(c)) {
                node = node.get(c);
                List<String> suggestions = new ArrayList<>();
                collectWords(node, new StringBuilder(searchWord.substring(0, result.size() + 1)), suggestions);
                result.add(suggestions);
            } else {
                while (result.size() < searchWord.length()) {
                    result.add(new ArrayList<>());
                }
                break;
            }
        }
        return result;
    }

    private static void collectWords(Trie.Node node, StringBuilder prefix, List<String> result) {
        if (result.size() == 3) {
            return;
        }
        if (node.cntEndWith > 0) {
            result.add(prefix.toString());
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (node.containsKey(c)) {
                collectWords(node.get(c), prefix.append(c), result);
                prefix.setLength(prefix.length() - 1);
            }
        }
    }

    // Problem 10: Concatenated Words
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (canForm(word, trie, 0, 0)) {
                result.add(word);
            }
        }
        return result;
    }

    private static boolean canForm(String word, Trie trie, int start, int count) {
        Trie.Node node = trie.root;
        for (int i = start; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
            if (node.cntEndWith > 0) {
                if (i == word.length() - 1) {
                    return count >= 1;
                }
                if (canForm(word, trie, i + 1, count + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
