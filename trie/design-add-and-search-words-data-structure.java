class TrieNode{
    boolean isEnd;
    TrieNode[] neighbors;
    public TrieNode(){
        isEnd = false;
        neighbors = new TrieNode[26];
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.neighbors[c - 'a'] == null) {
                current.neighbors[c - 'a'] = new TrieNode();
            }
            current = current.neighbors[c - 'a'];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
    return dfs(root, word, 0);
}

    private boolean dfs(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        if (c == '.') {
            // Try all possible children
            for (int i = 0; i < 26; i++) {
                if (node.neighbors[i] != null && dfs(node.neighbors[i], word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            // Normal character
            int charIndex = c - 'a';
            if (node.neighbors[charIndex] == null) {
                return false;
            }
            return dfs(node.neighbors[charIndex], word, index + 1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */